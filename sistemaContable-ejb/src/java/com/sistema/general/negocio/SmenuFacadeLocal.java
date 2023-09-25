/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.negocio;

import com.sistema.general.entity.Smenu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author UES_BRYAN
 */
@Local
public interface SmenuFacadeLocal {

    void create(Smenu smenu);

    void edit(Smenu smenu);

    void remove(Smenu smenu);

    Smenu find(Object id);

    List<Smenu> findAll();

    List<Smenu> findRange(int[] range);

    int count();
    
}
