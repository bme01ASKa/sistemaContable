/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UES_BRYAN
 */
@Entity
@Table(name = "gentelefonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gentelefonos.findAll", query = "SELECT g FROM Gentelefonos g")
    , @NamedQuery(name = "Gentelefonos.findByIdPersona", query = "SELECT g FROM Gentelefonos g WHERE g.gentelefonosPK.idPersona = :idPersona")
    , @NamedQuery(name = "Gentelefonos.findByModTel", query = "SELECT g FROM Gentelefonos g WHERE g.gentelefonosPK.modTel = :modTel")
    , @NamedQuery(name = "Gentelefonos.findByCatTel", query = "SELECT g FROM Gentelefonos g WHERE g.gentelefonosPK.catTel = :catTel")
    , @NamedQuery(name = "Gentelefonos.findByCorTel", query = "SELECT g FROM Gentelefonos g WHERE g.gentelefonosPK.corTel = :corTel")
    , @NamedQuery(name = "Gentelefonos.findByTelefono", query = "SELECT g FROM Gentelefonos g WHERE g.telefono = :telefono")})
public class Gentelefonos implements Serializable {

    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GentelefonosPK gentelefonosPK;
    @JoinColumns({
        @JoinColumn(name = "modTel", referencedColumnName = "codMod", insertable = false, updatable = false)
        , @JoinColumn(name = "catTel", referencedColumnName = "codCat", insertable = false, updatable = false)
        , @JoinColumn(name = "corTel", referencedColumnName = "codCor", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Correlativos correlativos;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersonas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Genpersonas genpersonas;

    public Gentelefonos() {
    }

    public Gentelefonos(GentelefonosPK gentelefonosPK) {
        this.gentelefonosPK = gentelefonosPK;
    }

    public Gentelefonos(int idPersona, int modTel, int catTel, int corTel) {
        this.gentelefonosPK = new GentelefonosPK(idPersona, modTel, catTel, corTel);
    }

    public GentelefonosPK getGentelefonosPK() {
        return gentelefonosPK;
    }

    public void setGentelefonosPK(GentelefonosPK gentelefonosPK) {
        this.gentelefonosPK = gentelefonosPK;
    }


    public Correlativos getCorrelativos() {
        return correlativos;
    }

    public void setCorrelativos(Correlativos correlativos) {
        this.correlativos = correlativos;
    }

    public Genpersonas getGenpersonas() {
        return genpersonas;
    }

    public void setGenpersonas(Genpersonas genpersonas) {
        this.genpersonas = genpersonas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gentelefonosPK != null ? gentelefonosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gentelefonos)) {
            return false;
        }
        Gentelefonos other = (Gentelefonos) object;
        if ((this.gentelefonosPK == null && other.gentelefonosPK != null) || (this.gentelefonosPK != null && !this.gentelefonosPK.equals(other.gentelefonosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.general.entity.Gentelefonos[ gentelefonosPK=" + gentelefonosPK + " ]";
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
