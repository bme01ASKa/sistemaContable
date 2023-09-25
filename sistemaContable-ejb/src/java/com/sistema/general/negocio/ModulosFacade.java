/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.negocio;

import com.sistema.general.entity.Modulos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author UES_BRYAN
 */
@Stateless
public class ModulosFacade extends AbstractFacade<Modulos> implements ModulosFacadeLocal {

    @PersistenceContext(unitName = "sistemaContable-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModulosFacade() {
        super(Modulos.class);
    }
    
}
