package com.text_editor;

// Concrete Flyweight class
// No setters are allowed inside.
// All intrinsic values here are immutable.
public class Style implements StyleInterface {
    private final String font;
    private final String color;
    private final int size;

    public Style(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    @Override
    public String getFont(){
        return font;
    }

    @Override
    public String getColor(){
        return color;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public String toString(){
        return "Font: " + font + ", Color: " + color + ", Size: " + size + ".";
    }
}
