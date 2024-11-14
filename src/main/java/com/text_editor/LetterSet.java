package com.text_editor;

// This class is created due to the lack of primitive tuples/pairs data structure in java

/**
 * Pairs a Letter and a Font together.
 *
 */
public class LetterSet {
    private final Letter letter;
    private Style style;

    public LetterSet(Letter letter, Style style){
        this.letter = letter;
        this.style = style;
    }

    public Letter getLetter(){
        return letter;
    }

    public Style getStyle(){
        return style;
    }

    public void setFont(Style style){
        this.style = style;
    }
}
