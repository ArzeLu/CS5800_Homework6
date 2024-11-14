package com.text_editor;

// Concrete Flyweight class
// No setters are allowed inside.
// All intrinsic values here are immutable.
public class Letter implements LetterInterface{
    private final char letter;

    public Letter(char letter) {
        this.letter = letter;
    }

    @Override
    public char getLetter(){
        return letter;
    }

    @Override
    public String toString(){
        return "Letter: " + letter;
    }
}
