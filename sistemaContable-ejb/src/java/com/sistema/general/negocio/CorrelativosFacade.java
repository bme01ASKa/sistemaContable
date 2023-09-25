/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.negocio;

import com.sistema.general.entity.Correlativos;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author UES_BRYAN
 */
@Stateless
public class CorrelativosFacade extends general<Correlativos> implements CorrelativosFacadeLocal {

    @PersistenceContext(unitName = "sistemaContable-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CorrelativosFacade() {
        super(Correlativos.class);
    }

    public Correlativos buscarCorrelativos(Map<String, Object> parametros) {
        StringBuilder jpqlBuilder = new StringBuilder("SELECT p FROM Correlativos p WHERE 1 = 1");

        if (parametros.containsKey("modulo") && parametros.get("modulo") != null) {
            jpqlBuilder.append(" AND p.correlativosPK.codMod = :modulo");
        }
        if (parametros.containsKey("catalogo") && parametros.get("catalogo") != null) {
            jpqlBuilder.append(" AND p.correlativosPK.codCat = :catalogo");
        }
        if (parametros.containsKey("correlativo") && parametros.get("correlativo") != null) {
            jpqlBuilder.append(" AND p.correlativosPK.codCor = :correlativo");
        }
        Query query = em.createQuery(jpqlBuilder.toString(), Correlativos.class);

        if (parametros.containsKey("modulo") && parametros.get("modulo") != null) {
            query.setParameter("modulo", parametros.get("modulo"));
        }
        if (parametros.containsKey("catalogo") && parametros.get("catalogo") != null) {
            query.setParameter("catalogo", parametros.get("catalogo"));
        }
        if (parametros.containsKey("correlativo") && parametros.get("correlativo") != null) {
            query.setParameter("correlativo", parametros.get("correlativo"));
        }

        Correlativos correlativos = (Correlativos) query.getSingleResult();
        return correlativos;
    }

    public List<Correlativos> buscarCorrelativosLst(Map<String, Object> parametros) {
        StringBuilder jpqlBuilder = new StringBuilder("SELECT p FROM Correlativos p WHERE 1 = 1");

        if (parametros.containsKey("modulo") && parametros.get("modulo") != null) {
            jpqlBuilder.append(" AND p.correlativosPK.codMod = :modulo");
        }
        if (parametros.containsKey("catalogo") && parametros.get("catalogo") != null) {
            jpqlBuilder.append(" AND p.correlativosPK.codCat = :catalogo");
        }
        Query query = em.createQuery(jpqlBuilder.toString(), Correlativos.class);
        if (parametros.containsKey("modulo") && parametros.get("modulo") != null) {
            query.setParameter("modulo", parametros.get("modulo"));
        }
        if (parametros.containsKey("catalogo") && parametros.get("catalogo") != null) {
            query.setParameter("catalogo", parametros.get("catalogo"));
        }
       

        List<Correlativos> correlativos = query.getResultList();
        return correlativos;
    }

}
