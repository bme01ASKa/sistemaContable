/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.negocio;

import com.sistema.general.entity.Gencorr;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;

/**
 *
 * @author UES_BRYAN
 */
@Stateless
public class GencorrFacade extends general<Gencorr> implements GencorrFacadeLocal {

    @PersistenceContext(unitName = "sistemaContable-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GencorrFacade() {
        super(Gencorr.class);
    }

    @Transactional
    public int getNextCorrValue(String nombre) {
        Gencorr genCorr = em.find(Gencorr.class, nombre, LockModeType.PESSIMISTIC_WRITE);
        int currentCorrValue = genCorr.getCorr();
        genCorr.setCorr(currentCorrValue + 1);
        em.persist(genCorr);
        return currentCorrValue;
    }

}
