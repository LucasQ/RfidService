package com.arduinoService.RfidRest.dao;

import com.arduinoService.RfidRest.entity.TbHistorico;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TbHistoricoDAOImpl implements TbHistoricoDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(TbHistorico historico) {
        Session session = entityManager.unwrap(Session.class);
        session.save(historico);
    }

    @Override
    public List<TbHistorico> findByDate(String date) {
        Session session = entityManager.unwrap(Session.class);
        Query query2 = session.createQuery("SELECT nome, tipoAcesso, time(timeStamp)  FROM TbHistorico " +
                "WHERE date(timestamp) = '"+date+"'");

        return query2.getResultList();
    }

    @Override
    public Long verifyES(String codRfid) {
        Session session = entityManager.unwrap(Session.class);
        Query theQuery = session.createQuery("SELECT count(*) FROM TbHistorico " +
                "WHERE date(timestamp) = curdate() AND codRfid = '" + codRfid +"'");

        return (Long) theQuery.uniqueResult();
    }

    @Override
    public String returnName(String codRfid) {
        Session session = entityManager.unwrap(Session.class);
        Query theQuery = session.createQuery("SELECT DISTINCT nome FROM TbHistorico " +
                "WHERE codRfid = '" +codRfid+ "'");

        return (String) theQuery.uniqueResult();
    }
}
