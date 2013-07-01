/*
 * ===================================================================================================================
 *  Name        : Mark.java
 *  Part of     : Comptel Control and Charge Platform
 *  Description :
 *
 *  Copyright (c) 2012 Comptel Corporation. All rights reserved.
 *
 *  This material, including documentation and any related computer programs, is protected by copyright controlled by
 *  Comptel Corporation. All rights are reserved. Copying, including reproducing, storing, adapting or translating, any
 *  or all of this material requires the prior written consent of Comptel Corporation. This material also contains
 *  confidential information which may not be disclosed to others without the prior written consent of
 *  Comptel Corporation.
 *
 * ====================================================================================================================
 */



public enum Mark {

    EMPTY('*'), CROSS('X'), CIRCLE('O');

    private char symbol;

    private Mark(char symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return Character.toString(symbol);
    }

}
