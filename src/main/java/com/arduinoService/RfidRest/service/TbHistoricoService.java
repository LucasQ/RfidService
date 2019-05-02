package com.arduinoService.RfidRest.service;

import com.arduinoService.RfidRest.entity.TbHistorico;

import java.util.List;

public interface TbHistoricoService {
    void create(TbHistorico historico);
    List<TbHistorico> findByDate(String date);
    Long verifyES(String codRfid);
    String returnName(String codRfid);
}
