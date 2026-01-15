import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MatcherExample {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("geeks");
        Matcher m = p.matcher("geeksforgeeks.org");

        while (m.find()) {
            System.out.println("Pattern found from " + m.start() + " to " + (m.end() - 1));
        }
    }
}

import java.util.regex.Pattern;

class CharClassExample {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("[a-z]", "g"));      // true
        System.out.println(Pattern.matches("[a-zA-Z]", "Gfg")); // false

        System.out.println(Pattern.matches("\\d{4}", "1234")); // true
System.out.println(Pattern.matches("\\d{4}", "123"));  // false
System.out.println(Pattern.matches("[a-z]+", "hello")); // true
System.out.println(Pattern.matches("[a-z]+", ""));      // false
System.out.println(Pattern.matches("a*", "aaaa"));      // true


// . : Any character
// \d : Digit [0-9]
// \D : Non-digit
// \s : Whitespace
// \S : Non-whitespace
// \w : Word character [a-zA-Z0-9_]
// \W : Non-word character
// \b : Word boundary
    }
}

