/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DarKMeYeR
 */
@Entity
@Table(name = "VEHICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByIdVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idVehiculo = :idVehiculo"),
    @NamedQuery(name = "Vehiculo.findByPatente", query = "SELECT v FROM Vehiculo v WHERE v.patente = :patente"),
    @NamedQuery(name = "Vehiculo.findByAno", query = "SELECT v FROM Vehiculo v WHERE v.ano = :ano"),
    @NamedQuery(name = "Vehiculo.findByValorFiscal", query = "SELECT v FROM Vehiculo v WHERE v.valorFiscal = :valorFiscal")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_VEHICULO")
    private String idVehiculo;
    @Basic(optional = false)
    @Column(name = "PATENTE")
    private String patente;
    @Basic(optional = false)
    @Column(name = "ANO")
    private short ano;
    @Basic(optional = false)
    @Column(name = "VALOR_FISCAL")
    private int valorFiscal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoIdVehiculo")
    private Collection<Cliente> clienteCollection;
    @JoinColumn(name = "MODELO_ID_MODELO", referencedColumnName = "ID_MODELO")
    @ManyToOne(optional = false)
    private Modelo modeloIdModelo;

    public Vehiculo() {
    }

    public Vehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo(String idVehiculo, String patente, short ano, int valorFiscal) {
        this.idVehiculo = idVehiculo;
        this.patente = patente;
        this.ano = ano;
        this.valorFiscal = valorFiscal;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public int getValorFiscal() {
        return valorFiscal;
    }

    public void setValorFiscal(int valorFiscal) {
        this.valorFiscal = valorFiscal;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Modelo getModeloIdModelo() {
        return modeloIdModelo;
    }

    public void setModeloIdModelo(Modelo modeloIdModelo) {
        this.modeloIdModelo = modeloIdModelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Vehiculo[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
