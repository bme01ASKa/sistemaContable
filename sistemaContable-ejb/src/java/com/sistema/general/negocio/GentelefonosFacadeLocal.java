/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.negocio;

import com.sistema.general.entity.Gentelefonos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author UES_BRYAN
 */
@Local
public interface GentelefonosFacadeLocal {

    void create(Gentelefonos gentelefonos);

    void edit(Gentelefonos gentelefonos);

    void remove(Gentelefonos gentelefonos);

    Gentelefonos find(Object id);

    List<Gentelefonos> findAll();

    List<Gentelefonos> findRange(int[] range);

    int count();
    
}
