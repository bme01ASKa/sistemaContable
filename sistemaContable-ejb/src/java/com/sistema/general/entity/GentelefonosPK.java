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
public class GentelefonosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idPersona")
    private int idPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modTel")
    private int modTel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "catTel")
    private int catTel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "corTel")
    private int corTel;

    public GentelefonosPK() {
    }

    public GentelefonosPK(int idPersona, int modTel, int catTel, int corTel) {
        this.idPersona = idPersona;
        this.modTel = modTel;
        this.catTel = catTel;
        this.corTel = corTel;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getModTel() {
        return modTel;
    }

    public void setModTel(int modTel) {
        this.modTel = modTel;
    }

    public int getCatTel() {
        return catTel;
    }

    public void setCatTel(int catTel) {
        this.catTel = catTel;
    }

    public int getCorTel() {
        return corTel;
    }

    public void setCorTel(int corTel) {
        this.corTel = corTel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPersona;
        hash += (int) modTel;
        hash += (int) catTel;
        hash += (int) corTel;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GentelefonosPK)) {
            return false;
        }
        GentelefonosPK other = (GentelefonosPK) object;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        if (this.modTel != other.modTel) {
            return false;
        }
        if (this.catTel != other.catTel) {
            return false;
        }
        if (this.corTel != other.corTel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.general.entity.GentelefonosPK[ idPersona=" + idPersona + ", modTel=" + modTel + ", catTel=" + catTel + ", corTel=" + corTel + " ]";
    }
    
}
