package com.parcialdds.disney.entity.producto;

import java.util.List;

public class EstrategiaCredito implements Estrategia{

    @Override
    public Integer calcularMontoFinal(Integer monto, List<Turista> turistas) {
        return turistas.size() * (monto + monto * 5 / 100);
    }

}
