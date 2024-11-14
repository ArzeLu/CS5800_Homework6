package com.text_editor;

import java.io.Serializable;
import java.util.ArrayList;

// The class isn't a Singleton because there may be multiple documents.
// The factories will remain singletons since they're native to the individual documents.
// This class combines objects Letter and Font, make them extrinsic objects of each other.
public class Editor implements Serializable{
    private ArrayList<LetterSet> letterSets;
    private LetterFactory letterFactory;
    private StyleFactory styleFactory;

    public Editor(){
        letterSets = new ArrayList<>();
        letterFactory = LetterFactory.getInstance();
        styleFactory = StyleFactory.getInstance();
    }

    /**
     * Type a letter on the document
     * @param character a key of the client's choosing.
     */
    public char type(char character){
        Letter letter = letterFactory.getLetter(character);
        Style style = styleFactory.getStyle();
        LetterSet letterSet = new LetterSet(letter, style);
        letterSets.add(letterSet);

        display(letterSet);

        return character;
    }

    public char type(char character, String font, String color, int size){
        Letter letter = letterFactory.getLetter(character);
        Style style = styleFactory.getStyle(font, color, size);
        LetterSet letterSet = new LetterSet(letter, style);
        letterSets.add(letterSet);

        display(letterSet);

        return character;
    }

    // Simulate typing out the letter in a document.
    private void display(LetterSet letterSet){
        System.out.println(letterSet.getLetter().toString() + "  " + letterSet.getStyle().toString());
    }

    private void displayAll(){
        for(LetterSet letterSet : letterSets)
            display(letterSet);
    }

    /**
     * In a document, a user changes the font of a letter by manual selection.
     * This method changes the document
     * @param index position of the letter to have the font changed.
     * @param range amount of letters to be changed starting from the given index.
     * @param font font
     * @param color color
     * @param size size
     */
    public void changeFont(int index, int range, String font, String color, int size){
        for(int i = index; i < index + range; i++){
            Style style = styleFactory.getStyle();
            LetterSet letterSet = letterSets.get(i);
            letterSet.setFont(style);
            letterSets.set(i, letterSet);
        }

        System.out.println("\nFont changed! Display refreshing...\n");
        displayAll();
    }

    /**
     * Store the metadata of the document.
     */
    public void save(){
        // Perform serialization
    }
}
