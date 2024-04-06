package com.keppri.wallet.wallet.service;

import com.keppri.wallet.wallet.entity.Cuenta;
import com.keppri.wallet.wallet.entity.RecargaDTO;
import com.keppri.wallet.wallet.entity.SaldoDTO;

public interface CuentaService {
    public Cuenta updateCuenta(RecargaDTO recargaDto);
    public Cuenta obtenerSaldo(SaldoDTO saldoDto);

}
