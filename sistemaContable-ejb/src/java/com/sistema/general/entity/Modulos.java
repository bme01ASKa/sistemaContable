/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UES_BRYAN
 */
@Entity
@Table(name = "modulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulos.findAll", query = "SELECT m FROM Modulos m")
    , @NamedQuery(name = "Modulos.findByCodMod", query = "SELECT m FROM Modulos m WHERE m.codMod = :codMod")
    , @NamedQuery(name = "Modulos.findByDescripcion", query = "SELECT m FROM Modulos m WHERE m.descripcion = :descripcion")})
public class Modulos implements Serializable {

    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codMod")
    private Integer codMod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulos")
    private List<Catalogos> catalogosList;

    public Modulos() {
    }

    public Modulos(Integer codMod) {
        this.codMod = codMod;
    }

    public Integer getCodMod() {
        return codMod;
    }

    public void setCodMod(Integer codMod) {
        this.codMod = codMod;
    }


    @XmlTransient
    public List<Catalogos> getCatalogosList() {
        return catalogosList;
    }

    public void setCatalogosList(List<Catalogos> catalogosList) {
        this.catalogosList = catalogosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMod != null ? codMod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulos)) {
            return false;
        }
        Modulos other = (Modulos) object;
        if ((this.codMod == null && other.codMod != null) || (this.codMod != null && !this.codMod.equals(other.codMod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.entity.Modulos[ codMod=" + codMod + " ]";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
