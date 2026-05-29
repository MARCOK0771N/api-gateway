package com.eglobal.api_gateway.service;

import com.eglobal.api_gateway.dto.CancelRequest;
import com.eglobal.api_gateway.dto.SaleDto;
import com.eglobal.api_gateway.dto.SaleRequest;
import com.eglobal.api_gateway.dto.SaleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

public interface GatewayService {

    SaleResponse process(SaleRequest request);

    Page<SaleDto> get(Integer page, Integer size, String sort, String direction);

    void cancel(Long id, CancelRequest request);
}
