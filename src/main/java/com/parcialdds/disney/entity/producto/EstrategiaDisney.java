package com.parcialdds.disney.entity.producto;

import java.util.List;

public class EstrategiaDisney implements Estrategia{


    @Override
    public Integer calcularMontoFinal(Integer monto, List<Turista> turistas) {

        return turistas.size() * ((monto * 90) / 100) ;
    }
}
