package com.eglobal.api_gateway.client;

import com.eglobal.api_gateway.dto.CancelRequest;
import com.eglobal.api_gateway.dto.SaleDto;
import com.eglobal.api_gateway.dto.SaleRequest;
import com.eglobal.api_gateway.dto.SaleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "api-service-client", url = "${api.external-url}", configuration = FeignConfig.class)
public interface ApiServiceClient {

    @PostMapping("/save")
    SaleResponse sendSale(@RequestBody SaleRequest request);

    @GetMapping("/get")
    Page<SaleDto> get(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sort, @RequestParam String direction);

    @PutMapping(value = "/{id}")
    void cancel(@PathVariable Long id, @RequestBody CancelRequest request);

}
