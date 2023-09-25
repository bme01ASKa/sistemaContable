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
public enum CodCatalagos {
    CORREOS(10);

    private int value;

    CodCatalagos(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
