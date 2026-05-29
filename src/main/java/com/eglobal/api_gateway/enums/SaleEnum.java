package com.eglobal.api_gateway.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SaleEnum {

    ID("id"),
    REFERENCE("referencia"),
    OPERATION("operacion"),
    AMOUNT("importe"),
    CLIENT("cliente"),
    STATUS("status");

    private final String fieldName;

}
