/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UES_BRYAN
 */
@Entity
@Table(name = "gencorr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gencorr.findAll", query = "SELECT g FROM Gencorr g")
    , @NamedQuery(name = "Gencorr.findByNombre", query = "SELECT g FROM Gencorr g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "Gencorr.findByCorr", query = "SELECT g FROM Gencorr g WHERE g.corr = :corr")
    , @NamedQuery(name = "Gencorr.findByLimite", query = "SELECT g FROM Gencorr g WHERE g.limite = :limite")})
public class Gencorr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "corr")
    private Integer corr;
    @Column(name = "limite")
    private Integer limite;

    public Gencorr() {
    }

    public Gencorr(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCorr() {
        return corr;
    }

    public void setCorr(Integer corr) {
        this.corr = corr;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gencorr)) {
            return false;
        }
        Gencorr other = (Gencorr) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.entity.Gencorr[ nombre=" + nombre + " ]";
    }
    
}
