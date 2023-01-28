
import java.util.*;

public class SimpleWordDictionary {
    private Map<Character, ArrayList<String>> dictionary = new HashMap<>();

    // To Validate the Word before adding it to the Dictionary
    private boolean validateWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Implement the add method
    public void add(String word) {
        if (validateWord(word)) {
            char firstChar = Character.toLowerCase(word.charAt(0));
            if (dictionary.get(firstChar) == null) {
                ArrayList<String> wordsList = new ArrayList<>();
                wordsList.add(word);
                Collections.sort(wordsList);
                dictionary.put(firstChar, wordsList);
            } else {
                ArrayList<String> wordsList = dictionary.get(firstChar);
                wordsList.add(word);
                Collections.sort(wordsList);
            }

        } else {
            System.out.println("Word " + word + " is not valid");
        }
    }

    // Implement the printAll method
    public void printAll() {
        Iterator<Map.Entry<Character, ArrayList<String>>> iterator = dictionary.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, ArrayList<String>> wordsSet = iterator.next();
            System.out.println(wordsSet.getKey() + " = " + wordsSet.getValue());
        }
    }

    // Implement the printByChar method
    public void printByChar(Character character) {
        ArrayList<String> wordsSet = dictionary.get(character);
        System.out.println(character + " = " + wordsSet);
    }

    public static void main(String[] args) {
        SimpleWordDictionary wordsDictionary = new SimpleWordDictionary();
        wordsDictionary.add("Ahmed");
        wordsDictionary.add("ali");
        wordsDictionary.add("zaid");
        wordsDictionary.add("sami");
        wordsDictionary.add("mohammed");
        wordsDictionary.add("hossam");
        wordsDictionary.add("Nader");
        wordsDictionary.add("Shaar");
        wordsDictionary.add("ramy");
        wordsDictionary.add("mohamed");
        wordsDictionary.add("mahmoud");
        wordsDictionary.add("peter");
        wordsDictionary.add("paul");

        // Print all Records
        wordsDictionary.printAll();

        System.out.println("__________________##___________________");

        // Print Records by Character
        wordsDictionary.printByChar('a');
        wordsDictionary.printByChar('m');

    }
}