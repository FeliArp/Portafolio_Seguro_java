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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DarKMeYeR
 */
@Entity
@Table(name = "ENCARGADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encargado.findAll", query = "SELECT e FROM Encargado e"),
    @NamedQuery(name = "Encargado.findByIdEncargado", query = "SELECT e FROM Encargado e WHERE e.idEncargado = :idEncargado")})
public class Encargado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ENCARGADO")
    private String idEncargado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encargadoIdEncargado")
    private Collection<Taller> tallerCollection;
    @JoinColumn(name = "EMPLEADO_ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @OneToOne(optional = false)
    private Empleado empleadoIdEmpleado;

    public Encargado() {
    }

    public Encargado(String idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(String idEncargado) {
        this.idEncargado = idEncargado;
    }

    @XmlTransient
    public Collection<Taller> getTallerCollection() {
        return tallerCollection;
    }

    public void setTallerCollection(Collection<Taller> tallerCollection) {
        this.tallerCollection = tallerCollection;
    }

    public Empleado getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(Empleado empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncargado != null ? idEncargado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encargado)) {
            return false;
        }
        Encargado other = (Encargado) object;
        if ((this.idEncargado == null && other.idEncargado != null) || (this.idEncargado != null && !this.idEncargado.equals(other.idEncargado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Encargado[ idEncargado=" + idEncargado + " ]";
    }
    
}
