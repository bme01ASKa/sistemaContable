/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UES_BRYAN
 */
@Entity
@Table(name = "correlativos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correlativos.findAll", query = "SELECT c FROM Correlativos c")
    , @NamedQuery(name = "Correlativos.findByCodMod", query = "SELECT c FROM Correlativos c WHERE c.correlativosPK.codMod = :codMod")
    , @NamedQuery(name = "Correlativos.findByCodCat", query = "SELECT c FROM Correlativos c WHERE c.correlativosPK.codCat = :codCat")
    , @NamedQuery(name = "Correlativos.findByCodCor", query = "SELECT c FROM Correlativos c WHERE c.correlativosPK.codCor = :codCor")
    , @NamedQuery(name = "Correlativos.findByDescripcion", query = "SELECT c FROM Correlativos c WHERE c.descripcion = :descripcion")})
public class Correlativos implements Serializable {

    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativos")
    private List<Direcciones> direccionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativos")
    private List<Gentelefonos> gentelefonosList;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CorrelativosPK correlativosPK;
    @JoinColumns({
        @JoinColumn(name = "codMod", referencedColumnName = "codMod", insertable = false, updatable = false)
        , @JoinColumn(name = "codCat", referencedColumnName = "codCat", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogos catalogos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativos")
    private List<Email> emailList;

    public Correlativos() {
    }

    public Correlativos(CorrelativosPK correlativosPK) {
        this.correlativosPK = correlativosPK;
    }

    public Correlativos(int codMod, int codCat, int codCor) {
        this.correlativosPK = new CorrelativosPK(codMod, codCat, codCor);
    }

    public CorrelativosPK getCorrelativosPK() {
        return correlativosPK;
    }

    public void setCorrelativosPK(CorrelativosPK correlativosPK) {
        this.correlativosPK = correlativosPK;
    }


    public Catalogos getCatalogos() {
        return catalogos;
    }

    public void setCatalogos(Catalogos catalogos) {
        this.catalogos = catalogos;
    }

    @XmlTransient
    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correlativosPK != null ? correlativosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correlativos)) {
            return false;
        }
        Correlativos other = (Correlativos) object;
        if ((this.correlativosPK == null && other.correlativosPK != null) || (this.correlativosPK != null && !this.correlativosPK.equals(other.correlativosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.entity.Correlativos[ correlativosPK=" + correlativosPK + " ]";
    }


    @XmlTransient
    public List<Gentelefonos> getGentelefonosList() {
        return gentelefonosList;
    }

    public void setGentelefonosList(List<Gentelefonos> gentelefonosList) {
        this.gentelefonosList = gentelefonosList;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Direcciones> getDireccionesList() {
        return direccionesList;
    }

    public void setDireccionesList(List<Direcciones> direccionesList) {
        this.direccionesList = direccionesList;
    }
    
}
