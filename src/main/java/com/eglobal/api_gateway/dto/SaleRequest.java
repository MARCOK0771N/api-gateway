package com.eglobal.api_gateway.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SaleRequest {

    @NotBlank(message = "Operación no puede estar vacía")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Operación inválida")
    private String operacion;

    @NotBlank(message = "Importe no puede estar vacío")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "Importe inválido")
    private String importe;

    @NotBlank(message = "Cliente no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Cliente inválido")
    private String cliente;

    private String secreto;
}
