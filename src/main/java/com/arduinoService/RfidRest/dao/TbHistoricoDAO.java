package com.arduinoService.RfidRest.dao;

import com.arduinoService.RfidRest.entity.TbHistorico;

import java.util.List;

public interface TbHistoricoDAO {
    void create(TbHistorico historico);
    List<TbHistorico> findByDate(String date);
    Long verifyES(String codRfid);
    String returnName(String codRfid);
}
