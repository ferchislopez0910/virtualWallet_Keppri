package com.keppri.wallet.wallet.repository;

import com.keppri.wallet.wallet.entity.Cliente;
import com.keppri.wallet.wallet.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,String> {
    public Optional<Cliente> findByDocumentoAndCelular(String documento, String celular);
}
