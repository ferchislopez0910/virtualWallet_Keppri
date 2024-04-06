package com.keppri.wallet.wallet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Min(value = 0, message="Balance Should be greater than zero")
	@NotNull
	private double saldo;

	@JoinColumn(name = "cliente_id")
	@OneToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
}