package com.arduinoService.RfidRest.restController;

import com.arduinoService.RfidRest.entity.TbHistorico;
import com.arduinoService.RfidRest.service.TbHistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RfidHandle {

    @Autowired
    private TbHistoricoService historicoService;

    @PostMapping(value = "/historico", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TbHistorico insertHistorico(@RequestBody TbHistorico historico) {
        historico.setIdHistorico(0);
        historicoService.create(historico);
        return historico;
    }

    @GetMapping("/historico")
    public List<TbHistorico> retrieveHistorico() {
        return historicoService.findAll();
    }

}
