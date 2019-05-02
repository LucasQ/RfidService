package com.arduinoService.RfidRest.service;

import com.arduinoService.RfidRest.dao.TbHistoricoDAO;
import com.arduinoService.RfidRest.entity.TbHistorico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbHistoricoServiceImpl implements TbHistoricoService {

    @Autowired
    private TbHistoricoDAO historicoDAO;

    @Override
    public void create(TbHistorico historico) {
        historicoDAO.create(historico);
    }

    @Override
    public List<TbHistorico> findByDate(String date) {
        return historicoDAO.findByDate(date);
    }

    @Override
    public Long verifyES(String codRfid) {
        return historicoDAO.verifyES(codRfid);
    }

    @Override
    public String returnName(String codRfid) {
        return historicoDAO.returnName(codRfid);
    }
}
