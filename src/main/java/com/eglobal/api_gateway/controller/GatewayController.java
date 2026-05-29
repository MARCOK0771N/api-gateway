package com.eglobal.api_gateway.controller;

import com.eglobal.api_gateway.dto.CancelRequest;
import com.eglobal.api_gateway.dto.SaleDto;
import com.eglobal.api_gateway.dto.SaleRequest;
import com.eglobal.api_gateway.dto.SaleResponse;
import com.eglobal.api_gateway.enums.SaleEnum;
import com.eglobal.api_gateway.service.GatewayService;
import com.eglobal.api_gateway.util.ValidationUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.eglobal.api_gateway.util.Transform.toPageable;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/gateway")
public class GatewayController {

    private final GatewayService gatewayService;

    @PostMapping("/sale")
    public SaleResponse process(@Valid @RequestBody SaleRequest request) {
        return gatewayService.process(request);
    }

    @GetMapping("/sale")
    public Page<SaleDto> get(@RequestParam(required = false) Integer page,
                                @RequestParam(required = false) Integer size,
                                @RequestParam(required = false) String sort,
                                @RequestParam(required = false) String direction) {
        Pageable pageable = toPageable(page, size, sort, direction);
        log.info("pageable = {}", pageable);
        String sortBy = Optional.ofNullable(sort).map(ValidationUtils.sortFieldValidator).map(SaleEnum::valueOf).map(SaleEnum::getFieldName).orElse(SaleEnum.ID.getFieldName());
        return gatewayService.get(page, size, sortBy, direction);
    }

    @PatchMapping("/sale/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id, @RequestBody CancelRequest request) {
        gatewayService.cancel(id, request);
        return ResponseEntity.ok().build();
    }

}
