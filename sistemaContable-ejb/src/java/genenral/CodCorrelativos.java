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
public enum CodCorrelativos {
    PERSONAL1(10),
    PERSONAL2(20),
    LABORAL1(30),
    LABORAL2(40);

    private int value;

    CodCorrelativos(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
