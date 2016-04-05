package com.example.aldairpetronilia.morsecodetranslator;

/**
 * Created by aldairpetronilia on 05/04/2016.
 */
public class Character {
        String character;
        String morseCodeTranslation;

public Character(String character, String morseCodeTranslation) {

        this.character = character;
        this.morseCodeTranslation = morseCodeTranslation;
        }

public String getCharacter() {
        return character;
        }

public void setCharacter(String character) {
        this.character = character;
        }

public String getMorseCodeTranslation() {
        return morseCodeTranslation;
        }

public void setMorseCodeTranslation(String morseCodeTranslation) {
        this.morseCodeTranslation = morseCodeTranslation;
        }
        }