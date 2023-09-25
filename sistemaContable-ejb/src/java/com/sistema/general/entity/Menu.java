/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UES_BRYAN
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findByIdmenu", query = "SELECT m FROM Menu m WHERE m.idmenu = :idmenu")
    , @NamedQuery(name = "Menu.findByNombre", query = "SELECT m FROM Menu m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Menu.findByEstado", query = "SELECT m FROM Menu m WHERE m.estado = :estado")
    , @NamedQuery(name = "Menu.findByUsercrea", query = "SELECT m FROM Menu m WHERE m.usercrea = :usercrea")
    , @NamedQuery(name = "Menu.findByFechacrea", query = "SELECT m FROM Menu m WHERE m.fechacrea = :fechacrea")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmenu")
    private Integer idmenu;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 45)
    @Column(name = "usercrea")
    private String usercrea;
    @Column(name = "fechacrea")
    @Temporal(TemporalType.DATE)
    private Date fechacrea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<Smenu> smenuList;

    public Menu() {
    }

    public Menu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsercrea() {
        return usercrea;
    }

    public void setUsercrea(String usercrea) {
        this.usercrea = usercrea;
    }

    public Date getFechacrea() {
        return fechacrea;
    }

    public void setFechacrea(Date fechacrea) {
        this.fechacrea = fechacrea;
    }

    @XmlTransient
    public List<Smenu> getSmenuList() {
        return smenuList;
    }

    public void setSmenuList(List<Smenu> smenuList) {
        this.smenuList = smenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmenu != null ? idmenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idmenu == null && other.idmenu != null) || (this.idmenu != null && !this.idmenu.equals(other.idmenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.general.entity.Menu[ idmenu=" + idmenu + " ]";
    }
    
}
