
import java.util.*;

public class SimpleWordDictionary {
    private Map<Integer, ArrayList<String>> dictionary;

    // assign the characters ascii code as key and an empty arraylist as value
    public SimpleWordDictionary() {
        dictionary = new HashMap<>();
        for (int i = 97; i <= 122; i++) {
            dictionary.put(i, new ArrayList<String>());
        }
    }

    // To Validate the Word before adding it to the Dictionary
    public boolean validateWord(String word) {
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
            int firstChar = Character.toLowerCase(word.charAt(0));
            ArrayList<String> charList = dictionary.get(firstChar);
            charList.add(word);
            Collections.sort(charList);
            dictionary.put(firstChar, charList);
        } else {
            System.out.println("Word " + word + " is not valid");
        }
    }

    // Implement the printAll method using iterator
    public void printAll() {
        Iterator<Map.Entry<Integer, ArrayList<String>>> iterator = dictionary.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, ArrayList<String>> charSet = iterator.next();
            char asciiToChar = (char) charSet.getKey().intValue();
            System.out.println(asciiToChar + " = " + charSet.getValue());
        }
    }

    // Implement the printByChar method
    public void printByChar(Character character) {
        int charKey = Character.toLowerCase(character);
        ArrayList<String> charList = dictionary.get(charKey);
        char asciiToChar = (char) character;
        System.out.println(asciiToChar + " = " + charList);
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

        // Accept Arguments from User to add
        if (args.length > 0) {
            for (String arg : args) {
                wordsDictionary.add(arg);
            }
        }

        // Print all Records
        wordsDictionary.printAll();

        System.out.println("__________________##______________");

        // Print Records by Character
        wordsDictionary.printByChar('a');
        wordsDictionary.printByChar('m');

    }
}