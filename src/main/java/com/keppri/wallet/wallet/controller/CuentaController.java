package com.keppri.wallet.wallet.controller;

import com.keppri.wallet.wallet.entity.Cuenta;
import com.keppri.wallet.wallet.entity.RecargaDTO;
import com.keppri.wallet.wallet.entity.SaldoDTO;
import com.keppri.wallet.wallet.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    @PostMapping(value = "/recharge")
    public ResponseEntity<Cuenta> recargar(@RequestBody RecargaDTO recargaDto) {
        return ResponseEntity.ok(cuentaService.updateCuenta(recargaDto));
    }

    @GetMapping(value = "/balance")
    public ResponseEntity<Cuenta> getSaldo(@RequestBody SaldoDTO saldoDto) {
        return ResponseEntity.ok(cuentaService.obtenerSaldo(saldoDto));
    }
}
