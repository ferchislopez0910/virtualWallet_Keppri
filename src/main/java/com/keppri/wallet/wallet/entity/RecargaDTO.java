package com.keppri.wallet.wallet.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecargaDTO {
    @NotNull
    @Pattern(regexp = "^[0-9]{10}")
    private String documento;

    @Pattern(regexp = "[0-9]{10}", message = "Mobile No is Invalid")
    private String celular;

    @Min(value = 0, message="Balance Should be greater than zero")
    @NotNull
    private double valor;
}
