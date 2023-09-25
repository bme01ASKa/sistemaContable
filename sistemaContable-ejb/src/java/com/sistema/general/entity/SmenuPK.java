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
public class SmenuPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idsmenu")
    private int idsmenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmenu")
    private int idmenu;

    public SmenuPK() {
    }

    public SmenuPK(int idsmenu, int idmenu) {
        this.idsmenu = idsmenu;
        this.idmenu = idmenu;
    }

    public int getIdsmenu() {
        return idsmenu;
    }

    public void setIdsmenu(int idsmenu) {
        this.idsmenu = idsmenu;
    }

    public int getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idsmenu;
        hash += (int) idmenu;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmenuPK)) {
            return false;
        }
        SmenuPK other = (SmenuPK) object;
        if (this.idsmenu != other.idsmenu) {
            return false;
        }
        if (this.idmenu != other.idmenu) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.general.entity.SmenuPK[ idsmenu=" + idsmenu + ", idmenu=" + idmenu + " ]";
    }
    
}
