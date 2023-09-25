/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UES_BRYAN
 */
@Entity
@Table(name = "smenu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Smenu.findAll", query = "SELECT s FROM Smenu s")
    , @NamedQuery(name = "Smenu.findByIdsmenu", query = "SELECT s FROM Smenu s WHERE s.smenuPK.idsmenu = :idsmenu")
    , @NamedQuery(name = "Smenu.findByUrl", query = "SELECT s FROM Smenu s WHERE s.url = :url")
    , @NamedQuery(name = "Smenu.findByIdmenu", query = "SELECT s FROM Smenu s WHERE s.smenuPK.idmenu = :idmenu")
    , @NamedQuery(name = "Smenu.findByNombre", query = "SELECT s FROM Smenu s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Smenu.findByInicio", query = "SELECT s FROM Smenu s WHERE s.inicio = :inicio")
    , @NamedQuery(name = "Smenu.findByFinal1", query = "SELECT s FROM Smenu s WHERE s.final1 = :final1")})
public class Smenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SmenuPK smenuPK;
    @Size(max = 100)
    @Column(name = "url")
    private String url;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "inicio")
    private String inicio;
    @Size(max = 45)
    @Column(name = "final")
    private String final1;
    @JoinColumn(name = "idsmenu", referencedColumnName = "idmenu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menu menu;

    public Smenu() {
    }

    public Smenu(SmenuPK smenuPK) {
        this.smenuPK = smenuPK;
    }

    public Smenu(int idsmenu, int idmenu) {
        this.smenuPK = new SmenuPK(idsmenu, idmenu);
    }

    public SmenuPK getSmenuPK() {
        return smenuPK;
    }

    public void setSmenuPK(SmenuPK smenuPK) {
        this.smenuPK = smenuPK;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFinal1() {
        return final1;
    }

    public void setFinal1(String final1) {
        this.final1 = final1;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (smenuPK != null ? smenuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Smenu)) {
            return false;
        }
        Smenu other = (Smenu) object;
        if ((this.smenuPK == null && other.smenuPK != null) || (this.smenuPK != null && !this.smenuPK.equals(other.smenuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.general.entity.Smenu[ smenuPK=" + smenuPK + " ]";
    }
    
}
