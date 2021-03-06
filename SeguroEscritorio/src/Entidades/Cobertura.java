/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DarKMeYeR
 */
@Entity
@Table(name = "COBERTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cobertura.findAll", query = "SELECT c FROM Cobertura c"),
    @NamedQuery(name = "Cobertura.findByIdCobertura", query = "SELECT c FROM Cobertura c WHERE c.idCobertura = :idCobertura"),
    @NamedQuery(name = "Cobertura.findByPerdidaTotal", query = "SELECT c FROM Cobertura c WHERE c.perdidaTotal = :perdidaTotal"),
    @NamedQuery(name = "Cobertura.findByDanoTerceros", query = "SELECT c FROM Cobertura c WHERE c.danoTerceros = :danoTerceros")})
public class Cobertura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_COBERTURA")
    private String idCobertura;
    @Basic(optional = false)
    @Column(name = "PERDIDA_TOTAL")
    private Character perdidaTotal;
    @Basic(optional = false)
    @Column(name = "DANO_TERCEROS")
    private Character danoTerceros;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "coberturaIdCobertura")
    private Seguro seguro;

    public Cobertura() {
    }

    public Cobertura(String idCobertura) {
        this.idCobertura = idCobertura;
    }

    public Cobertura(String idCobertura, Character perdidaTotal, Character danoTerceros) {
        this.idCobertura = idCobertura;
        this.perdidaTotal = perdidaTotal;
        this.danoTerceros = danoTerceros;
    }

    public String getIdCobertura() {
        return idCobertura;
    }

    public void setIdCobertura(String idCobertura) {
        this.idCobertura = idCobertura;
    }

    public Character getPerdidaTotal() {
        return perdidaTotal;
    }

    public void setPerdidaTotal(Character perdidaTotal) {
        this.perdidaTotal = perdidaTotal;
    }

    public Character getDanoTerceros() {
        return danoTerceros;
    }

    public void setDanoTerceros(Character danoTerceros) {
        this.danoTerceros = danoTerceros;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobertura != null ? idCobertura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cobertura)) {
            return false;
        }
        Cobertura other = (Cobertura) object;
        if ((this.idCobertura == null && other.idCobertura != null) || (this.idCobertura != null && !this.idCobertura.equals(other.idCobertura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cobertura[ idCobertura=" + idCobertura + " ]";
    }
    
}
