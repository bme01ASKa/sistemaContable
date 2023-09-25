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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UES_BRYAN
 */
@Entity
@Table(name = "genpersonas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genpersonas.findAll", query = "SELECT g FROM Genpersonas g")
    , @NamedQuery(name = "Genpersonas.findByIdPersonas", query = "SELECT g FROM Genpersonas g WHERE g.idPersonas = :idPersonas")
    , @NamedQuery(name = "Genpersonas.findByPNombre", query = "SELECT g FROM Genpersonas g WHERE g.pNombre = :pNombre")
    , @NamedQuery(name = "Genpersonas.findBySNombre", query = "SELECT g FROM Genpersonas g WHERE g.sNombre = :sNombre")
    , @NamedQuery(name = "Genpersonas.findByPApellido", query = "SELECT g FROM Genpersonas g WHERE g.pApellido = :pApellido")
    , @NamedQuery(name = "Genpersonas.findBySApellido", query = "SELECT g FROM Genpersonas g WHERE g.sApellido = :sApellido")
    , @NamedQuery(name = "Genpersonas.findByFchaNac", query = "SELECT g FROM Genpersonas g WHERE g.fchaNac = :fchaNac")
    , @NamedQuery(name = "Genpersonas.findByFchaCrea", query = "SELECT g FROM Genpersonas g WHERE g.fchaCrea = :fchaCrea")
    , @NamedQuery(name = "Genpersonas.findByUsuariCrea", query = "SELECT g FROM Genpersonas g WHERE g.usuariCrea = :usuariCrea")})
public class Genpersonas implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genpersonas")
    private List<Direcciones> direccionesList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genpersonas")
    private List<Gentelefonos> gentelefonosList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genpersonas")
    private List<Email> emailList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPersonas")
    private Integer idPersonas;
    @Column(name = "pNombre")
    private String pNombre;
    @Column(name = "sNombre")
    private String sNombre;
    @Column(name = "pApellido")
    private String pApellido;
    @Column(name = "sApellido")
    private String sApellido;
    @Column(name = "fchaNac")
    @Temporal(TemporalType.DATE)
    private Date fchaNac;
    @Column(name = "fchaCrea")
    @Temporal(TemporalType.DATE)
    private Date fchaCrea;
    @Column(name = "usuariCrea")
    private String usuariCrea;

    // ...
    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    public Genpersonas() {
    }

    public Genpersonas(Integer idPersonas) {
        this.idPersonas = idPersonas;
    }

    public Integer getIdPersonas() {
        return idPersonas;
    }

    public void setIdPersonas(Integer idPersonas) {
        this.idPersonas = idPersonas;
    }

    public String getPNombre() {
        return pNombre;
    }

    public void setPNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getSNombre() {
        return sNombre;
    }

    public void setSNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getPApellido() {
        return pApellido;
    }

    public void setPApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getSApellido() {
        return sApellido;
    }

    public void setSApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public Date getFchaNac() {
        return fchaNac;
    }

    public void setFchaNac(Date fchaNac) {
        this.fchaNac = fchaNac;
    }

    public Date getFchaCrea() {
        return fchaCrea;
    }

    public void setFchaCrea(Date fchaCrea) {
        this.fchaCrea = fchaCrea;
    }

    public String getUsuariCrea() {
        return usuariCrea;
    }

    public void setUsuariCrea(String usuariCrea) {
        this.usuariCrea = usuariCrea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonas != null ? idPersonas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genpersonas)) {
            return false;
        }
        Genpersonas other = (Genpersonas) object;
        if ((this.idPersonas == null && other.idPersonas != null) || (this.idPersonas != null && !this.idPersonas.equals(other.idPersonas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistema.entity.Genpersonas[ idPersonas=" + idPersonas + " ]";
    }

    @XmlTransient
    public List<Gentelefonos> getGentelefonosList() {
        return gentelefonosList;
    }

    public void setGentelefonosList(List<Gentelefonos> gentelefonosList) {
        this.gentelefonosList = gentelefonosList;
    }

    @XmlTransient
    public List<Direcciones> getDireccionesList() {
        return direccionesList;
    }

    public void setDireccionesList(List<Direcciones> direccionesList) {
        this.direccionesList = direccionesList;
    }

}
