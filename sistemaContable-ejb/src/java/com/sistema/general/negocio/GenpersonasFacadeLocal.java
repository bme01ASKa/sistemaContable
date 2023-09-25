/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.negocio;

import com.sistema.general.entity.Genpersonas;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author UES_BRYAN
 */
@Local
public interface GenpersonasFacadeLocal {

    void create(Genpersonas genpersonas);

    void edit(Genpersonas genpersonas);

    void remove(Genpersonas genpersonas);

    Genpersonas find(Object id);

    List<Genpersonas> findAll();

    List<Genpersonas> findRange(int[] range);

    int count();

    List<Genpersonas> getAllGenpersonas() throws Exception;
    
    public void agregarpersona(Genpersonas genpersonas) throws Exception;

     public List<Genpersonas> buscarPersonasPorParametros(Map<String, Object> parametros) throws Exception;
}
