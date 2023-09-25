/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.negocio;

import com.sistema.general.entity.Correlativos;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author UES_BRYAN
 */
@Local
public interface CorrelativosFacadeLocal {

    void create(Correlativos correlativos);

    void edit(Correlativos correlativos);

    void remove(Correlativos correlativos);

    Correlativos find(Object id);

    List<Correlativos> findAll();

    List<Correlativos> findRange(int[] range);

    int count();

    public Correlativos buscarCorrelativos(Map<String, Object> parametros);

    public List<Correlativos> buscarCorrelativosLst(Map<String, Object> parametros);
}
