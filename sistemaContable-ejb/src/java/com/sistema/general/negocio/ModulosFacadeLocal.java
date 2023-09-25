/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.negocio;

import com.sistema.general.entity.Modulos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author UES_BRYAN
 */
@Local
public interface ModulosFacadeLocal {

    void create(Modulos modulos);

    void edit(Modulos modulos);

    void remove(Modulos modulos);

    Modulos find(Object id);

    List<Modulos> findAll();

    List<Modulos> findRange(int[] range);

    int count();
    
}
