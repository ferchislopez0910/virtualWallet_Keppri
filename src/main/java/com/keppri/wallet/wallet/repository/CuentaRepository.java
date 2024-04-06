package com.keppri.wallet.wallet.repository;

import com.keppri.wallet.wallet.entity.Cliente;
import com.keppri.wallet.wallet.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    public Optional<Cuenta> findByCliente(Cliente cliente);
}
