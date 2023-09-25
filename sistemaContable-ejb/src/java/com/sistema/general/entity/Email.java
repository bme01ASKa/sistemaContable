/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "email")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e")
    , @NamedQuery(name = "Email.findByIdPersona", query = "SELECT e FROM Email e WHERE e.emailPK.idPersona = :idPersona")
    , @NamedQuery(name = "Email.findByModEmail", query = "SELECT e FROM Email e WHERE e.emailPK.modEmail = :modEmail")
    , @NamedQuery(name = "Email.findByCatEmail", query = "SELECT e FROM Email e WHERE e.emailPK.catEmail = :catEmail")
    , @NamedQuery(name = "Email.findByCorEmail", query = "SELECT e FROM Email e WHERE e.emailPK.corEmail = :corEmail")
    , @NamedQuery(name = "Email.findByEmail", query = "SELECT e FROM Email e WHERE e.email = :email")})
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmailPK emailPK;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersonas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Genpersonas genpersonas;
    @JoinColumns({
        @JoinColumn(name = "modEmail", referencedColumnName = "codMod", insertable = false, updatable = false)
        , @JoinColumn(name = "catEmail", referencedColumnName = "codCat", insertable = false, updatable = false)
        , @JoinColumn(name = "corEmail", referencedColumnName = "codCor", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Correlativos correlativos;

    public Email() {
    }

    public Email(EmailPK emailPK) {
        this.emailPK = emailPK;
    }

    public Email(EmailPK emailPK, String email) {
        this.emailPK = emailPK;
        this.email = email;
    }

    public Email(int idPersona, int modEmail, int catEmail, int corEmail) {
        this.emailPK = new EmailPK(idPersona, modEmail, catEmail, corEmail);
    }

    public EmailPK getEmailPK() {
        return emailPK;
    }

    public void setEmailPK(EmailPK emailPK) {
        this.emailPK = emailPK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Genpersonas getGenpersonas() {
        return genpersonas;
    }

    public void setGenpersonas(Genpersonas genpersonas) {
        this.genpersonas = genpersonas;
    }

    public Correlativos getCorrelativos() {
        return correlativos;
    }

    public void setCorrelativos(Correlativos correlativos) {
        this.correlativos = correlativos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailPK != null ? emailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.emailPK == null && other.emailPK != null) || (this.emailPK != null && !this.emailPK.equals(other.emailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.entity.Email[ emailPK=" + emailPK + " ]";
    }
    
}
