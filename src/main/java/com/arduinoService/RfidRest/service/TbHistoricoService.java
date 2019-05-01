package com.arduinoService.RfidRest.service;

import com.arduinoService.RfidRest.entity.TbHistorico;

import java.util.List;

public interface TbHistoricoService {
    void create(TbHistorico historico);
    List<TbHistorico> findAll();
}
