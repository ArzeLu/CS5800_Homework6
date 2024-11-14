package com.text_editor;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args){
        Editor document = new Editor();

        document.type('H');
        document.type('e');
        document.type('l', "Calibri", "Red", 14);
        document.type('l');
        document.type('o');
        document.type('W');
        document.type('o');
        document.type('r', "Arial", "Black", 12);
        document.type('l');
        document.type('d', "Verdana", "Blue", 16);
        document.type('C');
        document.type('S');
        document.type('5');
        document.type('8', "Calibri", "Red", 14);
        document.type('0');
        document.type('0');

        document.changeFont(5, 1, "Verdana", "Red", 16);

        document.save();
    }
}
