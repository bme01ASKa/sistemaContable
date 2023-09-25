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
@Table(name = "direcciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direcciones.findAll", query = "SELECT d FROM Direcciones d")
    , @NamedQuery(name = "Direcciones.findByIdPersonas", query = "SELECT d FROM Direcciones d WHERE d.direccionesPK.idPersonas = :idPersonas")
    , @NamedQuery(name = "Direcciones.findByModDirecc", query = "SELECT d FROM Direcciones d WHERE d.direccionesPK.modDirecc = :modDirecc")
    , @NamedQuery(name = "Direcciones.findByCatDirecc", query = "SELECT d FROM Direcciones d WHERE d.direccionesPK.catDirecc = :catDirecc")
    , @NamedQuery(name = "Direcciones.findByCorDirecc", query = "SELECT d FROM Direcciones d WHERE d.direccionesPK.corDirecc = :corDirecc")
    , @NamedQuery(name = "Direcciones.findByDireccion", query = "SELECT d FROM Direcciones d WHERE d.direccion = :direccion")})
public class Direcciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DireccionesPK direccionesPK;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumns({
        @JoinColumn(name = "modDirecc", referencedColumnName = "codMod", insertable = false, updatable = false)
        , @JoinColumn(name = "catDirecc", referencedColumnName = "codCat", insertable = false, updatable = false)
        , @JoinColumn(name = "corDirecc", referencedColumnName = "codCor", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Correlativos correlativos;
    @JoinColumn(name = "idPersonas", referencedColumnName = "idPersonas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Genpersonas genpersonas;

    public Direcciones() {
    }

    public Direcciones(DireccionesPK direccionesPK) {
        this.direccionesPK = direccionesPK;
    }

    public Direcciones(int idPersonas, int modDirecc, int catDirecc, int corDirecc) {
        this.direccionesPK = new DireccionesPK(idPersonas, modDirecc, catDirecc, corDirecc);
    }

    public DireccionesPK getDireccionesPK() {
        return direccionesPK;
    }

    public void setDireccionesPK(DireccionesPK direccionesPK) {
        this.direccionesPK = direccionesPK;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        hash += (direccionesPK != null ? direccionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcciones)) {
            return false;
        }
        Direcciones other = (Direcciones) object;
        if ((this.direccionesPK == null && other.direccionesPK != null) || (this.direccionesPK != null && !this.direccionesPK.equals(other.direccionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.general.entity.Direcciones[ direccionesPK=" + direccionesPK + " ]";
    }
    
}
