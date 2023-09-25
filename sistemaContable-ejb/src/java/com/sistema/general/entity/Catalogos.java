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
@Table(name = "catalogos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogos.findAll", query = "SELECT c FROM Catalogos c")
    , @NamedQuery(name = "Catalogos.findByCodMod", query = "SELECT c FROM Catalogos c WHERE c.catalogosPK.codMod = :codMod")
    , @NamedQuery(name = "Catalogos.findByCodCat", query = "SELECT c FROM Catalogos c WHERE c.catalogosPK.codCat = :codCat")
    , @NamedQuery(name = "Catalogos.findByDescripcion", query = "SELECT c FROM Catalogos c WHERE c.descripcion = :descripcion")})
public class Catalogos implements Serializable {

    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CatalogosPK catalogosPK;
    @JoinColumn(name = "codMod", referencedColumnName = "codMod", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modulos modulos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogos")
    private List<Correlativos> correlativosList;

    public Catalogos() {
    }

    public Catalogos(CatalogosPK catalogosPK) {
        this.catalogosPK = catalogosPK;
    }

    public Catalogos(int codMod, int codCat) {
        this.catalogosPK = new CatalogosPK(codMod, codCat);
    }

    public CatalogosPK getCatalogosPK() {
        return catalogosPK;
    }

    public void setCatalogosPK(CatalogosPK catalogosPK) {
        this.catalogosPK = catalogosPK;
    }


    public Modulos getModulos() {
        return modulos;
    }

    public void setModulos(Modulos modulos) {
        this.modulos = modulos;
    }

    @XmlTransient
    public List<Correlativos> getCorrelativosList() {
        return correlativosList;
    }

    public void setCorrelativosList(List<Correlativos> correlativosList) {
        this.correlativosList = correlativosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catalogosPK != null ? catalogosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogos)) {
            return false;
        }
        Catalogos other = (Catalogos) object;
        if ((this.catalogosPK == null && other.catalogosPK != null) || (this.catalogosPK != null && !this.catalogosPK.equals(other.catalogosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.entity.Catalogos[ catalogosPK=" + catalogosPK + " ]";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
