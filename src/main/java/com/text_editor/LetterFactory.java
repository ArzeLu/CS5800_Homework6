package com.text_editor;

import java.util.HashMap;

// Concrete flyweight factory that produces characters.
// Doesn't derive from other classes.

/** Only produce the Letter object,
 * No accompanying font, that is dealt with by the Font object.
  */
public class LetterFactory {
    private static LetterFactory letterFactory;
    final private HashMap<Character, Letter> letters;

    private LetterFactory() {
        letters = new HashMap<>();
    }

    public static LetterFactory getInstance() {
        if(letterFactory == null){
            letterFactory =  new LetterFactory();
        }
        return letterFactory;
    }

    /**
     * Give a Letter object to the editor class.
     *
     * @param character char
     * @return Letter
     */
    public Letter getLetter(char character) {
        if(letters.containsKey(character))
            return letters.get(character);

        Letter letter = new Letter(character);
        letters.put(character, letter);
        return letter;
    }
}
