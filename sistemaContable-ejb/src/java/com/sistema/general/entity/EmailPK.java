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

/**
 *
 * @author UES_BRYAN
 */
@Embeddable
public class EmailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idPersona")
    private int idPersona;
    @Basic(optional = false)
    @Column(name = "modEmail")
    private int modEmail;
    @Basic(optional = false)
    @Column(name = "catEmail")
    private int catEmail;
    @Basic(optional = false)
    @Column(name = "corEmail")
    private int corEmail;

    public EmailPK() {
    }

    public EmailPK(int idPersona, int modEmail, int catEmail, int corEmail) {
        this.idPersona = idPersona;
        this.modEmail = modEmail;
        this.catEmail = catEmail;
        this.corEmail = corEmail;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getModEmail() {
        return modEmail;
    }

    public void setModEmail(int modEmail) {
        this.modEmail = modEmail;
    }

    public int getCatEmail() {
        return catEmail;
    }

    public void setCatEmail(int catEmail) {
        this.catEmail = catEmail;
    }

    public int getCorEmail() {
        return corEmail;
    }

    public void setCorEmail(int corEmail) {
        this.corEmail = corEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPersona;
        hash += (int) modEmail;
        hash += (int) catEmail;
        hash += (int) corEmail;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailPK)) {
            return false;
        }
        EmailPK other = (EmailPK) object;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        if (this.modEmail != other.modEmail) {
            return false;
        }
        if (this.catEmail != other.catEmail) {
            return false;
        }
        if (this.corEmail != other.corEmail) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.entity.EmailPK[ idPersona=" + idPersona + ", modEmail=" + modEmail + ", catEmail=" + catEmail + ", corEmail=" + corEmail + " ]";
    }
    
}
