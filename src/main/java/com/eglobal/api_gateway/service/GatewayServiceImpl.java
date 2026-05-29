package com.eglobal.api_gateway.service;

import com.eglobal.api_gateway.client.ApiServiceClient;
import com.eglobal.api_gateway.dto.CancelRequest;
import com.eglobal.api_gateway.dto.SaleDto;
import com.eglobal.api_gateway.dto.SaleRequest;
import com.eglobal.api_gateway.dto.SaleResponse;
import com.eglobal.api_gateway.exception.ExternalServiceException;
import com.eglobal.api_gateway.exception.InvalidSecretException;
import com.eglobal.api_gateway.util.AESUtil;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import static com.eglobal.api_gateway.util.Constants.MSG_ERROR_FEIGN;

@RequiredArgsConstructor
@Log4j2
@Service
public class GatewayServiceImpl implements GatewayService {

    private final ApiServiceClient apiServiceClient;


    @Override
    public SaleResponse process(SaleRequest request) {

        try {
            String secretoDescifrado = AESUtil.decrypt("claveSecreta1234", request.getSecreto());
            request.setSecreto(secretoDescifrado);
            return apiServiceClient.sendSale(request);
        } catch (ResourceAccessException | FeignException e) {
            log.error(MSG_ERROR_FEIGN, e);
            throw new ExternalServiceException("No se pudo conectar con el servicio externo");
        }  catch (Exception e) {
            throw new InvalidSecretException("El secreto enviado es inválido o fue manipulado");
        }
    }

    @Override
    public Page<SaleDto> get(Integer page, Integer size, String sort, String direction) {
        try {
            return apiServiceClient.get(page, size, sort, direction);
        } catch (ResourceAccessException | FeignException e) {
            log.error(MSG_ERROR_FEIGN, e);
            throw new ExternalServiceException("No se pudo conectar con el servicio externo");
        }
    }

    @Override
    public void cancel(Long id, CancelRequest request) {
        try {
            apiServiceClient.cancel(id, request);
        } catch (ResourceAccessException | FeignException e) {
            log.error(MSG_ERROR_FEIGN, e);
            throw new ExternalServiceException("No se pudo conectar con el servicio externo");
        }
    }
}
