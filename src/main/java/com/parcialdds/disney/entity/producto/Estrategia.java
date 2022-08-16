package com.parcialdds.disney.entity.producto;

import java.util.List;

public interface Estrategia {

    public Integer calcularMontoFinal(Integer monto, List<Turista> turistas);
}
