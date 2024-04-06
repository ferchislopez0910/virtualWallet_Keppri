package com.keppri.wallet.wallet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Entity
public class Cliente
 {

	 @Id
	 @NotNull
	 @Pattern(regexp = "^[0-9]{6,10}")
	 private String documento;

	@NotNull
	@Pattern(regexp="[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+")
	private String nombre;

	@Email(message = "Email format is wrong")
	@NotNull(message = "Name should not be null")
	private String email;

	 @Pattern(regexp = "[0-9]{10}", message = "Mobile No is Invalid")
	 private String celular;


	 @JsonIgnore
	 @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private Cuenta cuenta;
	
	
}