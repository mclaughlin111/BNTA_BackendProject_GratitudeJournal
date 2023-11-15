package com.group6.GratitudeJournal.models;

import java.util.ArrayList;
import java.util.Random;

public class Quote {
    private final ArrayList<String> quotes;

    public Quote(){
        quotes = new ArrayList<String>();
        quotes.add("\"You must be the change you wish to see in the world. -Mahatma Gandhi\"");
        quotes.add("\"Spread love everywhere you go. Let no one ever come to you without leaving happier. - Mother Teresa\"");
        quotes.add("\"Ever tried. Ever failed. No matter. Try Again. Fail again. Fail better. Samuel Beckett\"");
        quotes.add("\"You can do anything if you put your mind to it\" - Tom McLaughlin");
    }

    public ArrayList<String> getQuotes() {
        return quotes;
    }
    public String getRandomQuote(){
        Random randomNumber = new Random();
        int low = 0;
        int high = 3;
        int result = randomNumber.nextInt(high-low) + low;
        return this.quotes.get(result);
    }
}
