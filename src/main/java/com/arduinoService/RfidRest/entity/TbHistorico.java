package com.arduinoService.RfidRest.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historico")
public class TbHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historico")
    private int idHistorico;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cod_rfid")
        private String codRfid;

    @Column(name = "tipo_acesso")
    private String tipoAcesso;

    @Column(name = "timestamp")
    private Date timeStamp;

    public TbHistorico() {}

    public TbHistorico(String nome, String codRfid, String tipoAcesso, Date timeStamp) {
        this.nome = nome;
        this.codRfid = codRfid;
        this.tipoAcesso = tipoAcesso;
        this.timeStamp = timeStamp;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodRfid() {
        return codRfid;
    }

    public void setCodRfid(String codRfid) {
        this.codRfid = codRfid;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(String tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "TbHistorico{" +
                "idHistorico=" + idHistorico +
                ", nome='" + nome + '\'' +
                ", codRfid='" + codRfid + '\'' +
                ", tipoAcesso=" + tipoAcesso +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
