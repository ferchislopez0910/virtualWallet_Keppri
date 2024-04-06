package com.keppri.wallet.wallet.service;

import com.keppri.wallet.wallet.entity.Cliente;
import com.keppri.wallet.wallet.entity.Cuenta;
import com.keppri.wallet.wallet.exception.ClienteException;
import com.keppri.wallet.wallet.repository.ClienteRepository;
import com.keppri.wallet.wallet.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        Optional<Cliente> opt = clienteRepository.findById(cliente.getDocumento());

        if(opt.isPresent()){
            System.out.println("User Already Exist");
            throw new ClienteException("Usuario ya existe");
        }

        Cuenta cuenta = new Cuenta();
        cuenta.setCliente(cliente);

        cliente.setCuenta(cuenta);
        return clienteRepository.save(cliente);

    }
}
