package com.text_editor;

import java.util.ArrayList;

public class StyleFactory {
    private static StyleFactory styleFactory;
    private ArrayList<Style> styles;

    private StyleFactory(){
        styles = new ArrayList<>();
        styles.add(new Style("Calibri", "Black", 12)); // Saves a default Font
    }

    public static StyleFactory getInstance(){
        if(styleFactory == null){
            styleFactory = new StyleFactory();
        }
        return styleFactory;
    }

    public Style getStyle(){
        return styles.getLast();
    }

    /**
     * Overloaded method.
     * If client wants to use another set of fonts,
     * then use this method.
     * Otherwise, use the default/previous one,
     * which is the same method without arguments.
     * @param font font
     * @param color color
     * @param size size
     * @return Font
     */
    public Style getStyle(String font, String color, int size){
        for(Style f : styles){
            if(f.getFont().equals(font) && f.getColor().equals(color) && f.getSize() == size)
                return f;
        }

        Style f = new Style(font, color, size);
        styles.add(f);
        return new Style(font, color, size);
    }
}
