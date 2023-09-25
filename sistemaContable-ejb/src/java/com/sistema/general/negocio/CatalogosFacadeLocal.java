/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general.negocio;

import com.sistema.general.entity.Catalogos;
import com.sistema.general.entity.Correlativos;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author UES_BRYAN
 */
@Local
public interface CatalogosFacadeLocal {

    void create(Catalogos catalogos);

    void edit(Catalogos catalogos);

    void remove(Catalogos catalogos);

    Catalogos find(Object id);

    List<Catalogos> findAll();

    List<Catalogos> findRange(int[] range);

    int count();


}
