/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.negocio;

import com.sistema.general.entity.Catalogos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author UES_BRYAN
 */
@Stateless
public class CatalogosFacade extends general<Catalogos> implements CatalogosFacadeLocal {

    @PersistenceContext(unitName = "sistemaContable-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogosFacade() {
        super(Catalogos.class);
    }
    
}
