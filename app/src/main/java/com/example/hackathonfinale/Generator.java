package com.example.hackathonfinale;

import com.example.hackathonfinale.entities.Problem;
import com.example.hackathonfinale.entities.Question;

import java.util.ArrayList;
import java.util.Random;

public class Generator {

    public static ArrayList<Question> generatorQuestion(int count) {
        ArrayList<Question> questions = new ArrayList<>();
        for (int i = 0; i < count; i++) {

            StringBuilder name = new StringBuilder();
            for (String s : generateRandomWords((int) (1 + (Math.random() * 4)))) {
                name.append(s).append(" ");
            }

            questions.add(new Question(name.toString()));
        }

        return questions;
    }


    public static ArrayList<Problem> generatorProduct(int count) {
        ArrayList<Problem> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {

            StringBuilder name = new StringBuilder();
            for (String s : generateRandomWords((int) (1 + (Math.random() * 4)))) {
                name.append(s).append(" ");
            }

            StringBuilder description = new StringBuilder();
            for (String s : generateRandomWords((int) (10 + (Math.random() * 100)))) {
                description.append(s).append(" ");
            }

            products.add(new Problem(name.toString(), description.toString()));
        }


        return products;
    }

    private static String[] generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                if (j == 0) {
                    word[j] = (char) ('A' + random.nextInt(26));
                } else {
                    word[j] = (char) ('a' + random.nextInt(26));
                }
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }
}
