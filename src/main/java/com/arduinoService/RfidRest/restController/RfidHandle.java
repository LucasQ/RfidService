package com.arduinoService.RfidRest.restController;

import com.arduinoService.RfidRest.entity.TbHistorico;
import com.arduinoService.RfidRest.service.TbHistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/api")
public class RfidHandle {

    @Autowired
    private TbHistoricoService historicoService;

    @PostMapping(value = "/historico", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TbHistorico insertHistorico(@RequestBody TbHistorico historico) throws ParseException {

        historico.setIdHistorico(0);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));

        Date currentDate = dateFormat.parse(dateFormat.format(date));

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.HOUR, -3);
        Date hourback = cal.getTime();

        historico.setTimeStamp(hourback);
        Long count = historicoService.verifyES(historico.getCodRfid());

        if (count == 0){
            historico.setTipoAcesso("E");
        }else if((count%2) == 0){
            historico.setTipoAcesso("E");
        }else {
            historico.setTipoAcesso("S");
        }

        historico.setNome(historicoService.returnName(historico.getCodRfid()));

        if(historico.getNome() != null && !historico.getNome().isEmpty()) {
            historicoService.create(historico);
        }
        return historico;
    }

    @GetMapping("/historico/{date}")
    public List<TbHistorico> retrieveHistorico(@PathVariable("date") String date) {
        return historicoService.findByDate(date);
    }

}
