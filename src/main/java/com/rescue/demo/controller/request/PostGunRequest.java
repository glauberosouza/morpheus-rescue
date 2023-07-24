package com.rescue.demo.controller.request;

import com.rescue.demo.model.enums.GunSizeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostGunRequest {
    @NotBlank(message = "Vixi! Você esqueceu de digitar o nome. Por favor, preencha este campo.")
    private String name;
    @NotBlank(message = "Esqueceu do peso! Não pode deixar o peso em branco. Informe o peso da arma.")
    private String weight;
    @NotBlank(message = "Oh, não pode esquecer de especificar o calibre da arma!")
    private String caliber;
    @NotNull(message = "Você precisa especificar o tamanho da arma.")
    private GunSizeEnum gunSize;
    @NotNull(message = "Antes de prosseguir, informe se a arma é automática ou não.")
    private Boolean automatic;
}