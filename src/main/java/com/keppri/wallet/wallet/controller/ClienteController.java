package com.keppri.wallet.wallet.controller;

import com.keppri.wallet.wallet.entity.Cliente;
import com.keppri.wallet.wallet.repository.ClienteRepository;
import com.keppri.wallet.wallet.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/register")
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.crearCliente(cliente));
    }


}
