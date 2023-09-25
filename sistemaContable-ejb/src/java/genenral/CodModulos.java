/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genenral;

/**
 *
 * @author UES_BRYAN
 */
public enum CodModulos {

    GENERAL(10),
    VEINTE(20),
    TREINTA(30);
    
    private int value;

    CodModulos(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
