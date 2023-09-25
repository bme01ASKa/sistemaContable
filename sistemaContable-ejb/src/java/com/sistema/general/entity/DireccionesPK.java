/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author UES_BRYAN
 */
@Embeddable
public class DireccionesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idPersonas")
    private int idPersonas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modDirecc")
    private int modDirecc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "catDirecc")
    private int catDirecc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "corDirecc")
    private int corDirecc;

    public DireccionesPK() {
    }

    public DireccionesPK(int idPersonas, int modDirecc, int catDirecc, int corDirecc) {
        this.idPersonas = idPersonas;
        this.modDirecc = modDirecc;
        this.catDirecc = catDirecc;
        this.corDirecc = corDirecc;
    }

    public int getIdPersonas() {
        return idPersonas;
    }

    public void setIdPersonas(int idPersonas) {
        this.idPersonas = idPersonas;
    }

    public int getModDirecc() {
        return modDirecc;
    }

    public void setModDirecc(int modDirecc) {
        this.modDirecc = modDirecc;
    }

    public int getCatDirecc() {
        return catDirecc;
    }

    public void setCatDirecc(int catDirecc) {
        this.catDirecc = catDirecc;
    }

    public int getCorDirecc() {
        return corDirecc;
    }

    public void setCorDirecc(int corDirecc) {
        this.corDirecc = corDirecc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPersonas;
        hash += (int) modDirecc;
        hash += (int) catDirecc;
        hash += (int) corDirecc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionesPK)) {
            return false;
        }
        DireccionesPK other = (DireccionesPK) object;
        if (this.idPersonas != other.idPersonas) {
            return false;
        }
        if (this.modDirecc != other.modDirecc) {
            return false;
        }
        if (this.catDirecc != other.catDirecc) {
            return false;
        }
        if (this.corDirecc != other.corDirecc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.general.entity.DireccionesPK[ idPersonas=" + idPersonas + ", modDirecc=" + modDirecc + ", catDirecc=" + catDirecc + ", corDirecc=" + corDirecc + " ]";
    }
    
}
