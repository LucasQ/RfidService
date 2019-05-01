package com.arduinoService.RfidRest.dao;

import com.arduinoService.RfidRest.entity.TbHistorico;

import java.util.List;

public interface TbHistoricoDAO {
    void create(TbHistorico historico);
    List<TbHistorico> findAll();
}
