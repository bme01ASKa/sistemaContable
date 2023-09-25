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
public class CorrelativosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codMod")
    private int codMod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codCat")
    private int codCat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codCor")
    private int codCor;

    public CorrelativosPK() {
    }

    public CorrelativosPK(int codMod, int codCat, int codCor) {
        this.codMod = codMod;
        this.codCat = codCat;
        this.codCor = codCor;
    }

    public int getCodMod() {
        return codMod;
    }

    public void setCodMod(int codMod) {
        this.codMod = codMod;
    }

    public int getCodCat() {
        return codCat;
    }

    public void setCodCat(int codCat) {
        this.codCat = codCat;
    }

    public int getCodCor() {
        return codCor;
    }

    public void setCodCor(int codCor) {
        this.codCor = codCor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codMod;
        hash += (int) codCat;
        hash += (int) codCor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CorrelativosPK)) {
            return false;
        }
        CorrelativosPK other = (CorrelativosPK) object;
        if (this.codMod != other.codMod) {
            return false;
        }
        if (this.codCat != other.codCat) {
            return false;
        }
        if (this.codCor != other.codCor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.entity.CorrelativosPK[ codMod=" + codMod + ", codCat=" + codCat + ", codCor=" + codCor + " ]";
    }
    
}
