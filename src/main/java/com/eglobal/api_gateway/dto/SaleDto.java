package com.eglobal.api_gateway.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class SaleDto extends SaleResponse{

    private String cliente;

}
