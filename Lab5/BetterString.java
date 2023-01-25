import java.util.function.BiPredicate;

class BetterStringMethod {
    public static String betterString(String str1, String str2, BiPredicate<String, String> biPredicate) {
        if (biPredicate.test(str1, str2)) {
            return str1;
        } else {
            return str2;
        }
    }
}

public class BetterString {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = "Welcome";
        String longerString = BetterStringMethod.betterString(str1, str2, (s1, s2) -> s1.length() > s2.length());
        System.out.println("The Longest String is " + longerString);
        String firstString = BetterStringMethod.betterString(str1, str2, (s1, s2) -> true);
        System.out.println("The First String is " + firstString);

    }

}
