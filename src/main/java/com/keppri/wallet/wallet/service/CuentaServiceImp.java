package com.keppri.wallet.wallet.service;

import com.keppri.wallet.wallet.entity.Cliente;
import com.keppri.wallet.wallet.entity.Cuenta;
import com.keppri.wallet.wallet.entity.RecargaDTO;
import com.keppri.wallet.wallet.entity.SaldoDTO;
import com.keppri.wallet.wallet.exception.ClienteException;
import com.keppri.wallet.wallet.repository.ClienteRepository;
import com.keppri.wallet.wallet.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaServiceImp implements CuentaService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @Override
    public Cuenta updateCuenta(RecargaDTO recargaDto) {
        Optional<Cliente> cliente = clienteRepository.findById(recargaDto.getDocumento());

        if(cliente.isPresent()) {
            var cuenta = cliente.get().getCuenta();
            var saldo = cuenta.getSaldo();
            cuenta.setSaldo(saldo + recargaDto.getValor());
            return cuentaRepository.save(cuenta);
        }else{
            throw new ClienteException("Cliente no existe");
        }

    }

    @Override
    public Cuenta obtenerSaldo(SaldoDTO saldoDto) {
        Optional<Cliente> cliente = clienteRepository.findByDocumentoAndCelular(saldoDto.getDocumento(), saldoDto.getCelular());

        if(cliente.isPresent()) {

            return cliente.get().getCuenta();

        }else{
            throw new ClienteException("Cliente no existe");
        }
    }
}
