/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.negocio;

import com.sistema.general.entity.Genpersonas;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author UES_BRYAN
 */
@Stateless
public class GenpersonasFacade extends general<Genpersonas> implements GenpersonasFacadeLocal {

    @PersistenceContext(unitName = "sistemaContable-ejbPU")
    private EntityManager em;
   

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenpersonasFacade() {
        super(Genpersonas.class);
    }
    
    @Override
   public List<Genpersonas> getAllGenpersonas() throws Exception{
        String jpql = "SELECT g FROM Genpersonas g"; // JPQL query
        TypedQuery<Genpersonas> query = em.createQuery(jpql, Genpersonas.class);
        return query.getResultList();
    }

    @Override
    public void agregarpersona( Genpersonas genpersonas) throws Exception {
        em.merge(genpersonas);
    }
   
    @Override
   public List<Genpersonas> buscarPersonasPorParametros(Map<String, Object> parametros) throws Exception{
        StringBuilder jpqlBuilder = new StringBuilder("SELECT p FROM Genpersonas p WHERE 1 = 1");

        if (parametros.containsKey("pNombre") && parametros.get("pNombre") != null) {
            jpqlBuilder.append(" AND p.pNombre LIKE :pNombre");
        }
        if (parametros.containsKey("sNombre") && parametros.get("sNombre") != null) {
            jpqlBuilder.append(" AND p.sNombre LIKE :sNombre");
        }
        if (parametros.containsKey("pApellido") && parametros.get("pApellido") != null) {
            jpqlBuilder.append(" AND p.pApellido LIKE :pApellido");
        }
        if (parametros.containsKey("sApellido") && parametros.get("sApellido") != null) {
            jpqlBuilder.append(" AND p.sApellido LIKE :sApellido");
        }
        if (parametros.containsKey("fchaNac") && parametros.get("fchaNac") != null) {
            jpqlBuilder.append(" AND p.fchaNac = :fchaNac");
        }

        Query query = em.createQuery(jpqlBuilder.toString(), Genpersonas.class);

        if (parametros.containsKey("pNombre") && parametros.get("pNombre") != null) {
            query.setParameter("pNombre", "%" + parametros.get("pNombre") + "%");
        }
        if (parametros.containsKey("sNombre") && parametros.get("sNombre") != null) {
            query.setParameter("sNombre", "%" + parametros.get("sNombre") + "%");
        }
        if (parametros.containsKey("pApellido") && parametros.get("pApellido") != null) {
            query.setParameter("pApellido", "%" + parametros.get("pApellido") + "%");
        }
        if (parametros.containsKey("sApellido") && parametros.get("sApellido") != null) {
            query.setParameter("sApellido", "%" + parametros.get("sApellido") + "%");
        }
        if (parametros.containsKey("fchaNac") && parametros.get("fchaNac") != null) {
            query.setParameter("fchaNac", parametros.get("fchaNac"));
        }

        List<Genpersonas> personas = query.getResultList();
        return personas;
    }
}
