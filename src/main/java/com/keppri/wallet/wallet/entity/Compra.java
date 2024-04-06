package com.keppri.wallet.wallet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compra

 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	@NotNull
    @Min(0)
	private double total;


	@CreatedDate
	@CreationTimestamp
	private LocalDate fecha_compra;

	 @ManyToOne(cascade = CascadeType.ALL)
	 @JsonIgnore
	 private Cuenta cuenta;

	
}