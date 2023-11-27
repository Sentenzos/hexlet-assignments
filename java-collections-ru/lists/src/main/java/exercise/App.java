package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        if (symbols.length() < word.length()) {
            return false;
        }

        String[] symbolsSplit = symbols.toLowerCase().split("");
        String[] wordSplit = word.toLowerCase().split("");
        List<String> symbolsList = new ArrayList<>(List.of(symbolsSplit));
        List<String> wordList = new ArrayList<>(List.of(wordSplit));

        for (String letter : wordList) {
            var index = symbolsList.indexOf(letter);
            if (index == -1) {
                return false;
            } else {
                symbolsList.remove(index);
            }
        }

        return true;
    }
}
//END
