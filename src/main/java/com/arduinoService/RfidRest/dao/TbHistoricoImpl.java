package com.arduinoService.RfidRest.dao;

import com.arduinoService.RfidRest.entity.TbHistorico;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TbHistoricoImpl implements TbHistoricoDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(TbHistorico historico) {
        Session session = entityManager.unwrap(Session.class);
        session.save(historico);
    }

    @Override
    public List<TbHistorico> findAll() {

        Session session = entityManager.unwrap(Session.class);

        Query<TbHistorico> theQuery = session.createQuery("from TbHistorico",
                TbHistorico.class);

        List<TbHistorico> historicos = theQuery.getResultList();

        return historicos;
    }
}
