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
public class CancelRequest {

    @NotBlank(message = "Referencia no puede estar vacía")
    @Pattern(regexp = "^[0-9]{6}$", message = "Referencia inválida, debe ser un número de 6 dígitos")
    private String referencia;

    @NotBlank(message = "Estatus no puede estar vacío")
    @Pattern(regexp = "aprobada|cancelar", message = "Estatus inválido, debe ser 'aprobada' o 'cancelar'")
    private String estatus;
}
