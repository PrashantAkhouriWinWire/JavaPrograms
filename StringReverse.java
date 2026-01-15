import java.util.Scanner;

public class StringReverse 
{
    public String input;

    public String reverseString() {
        return new StringBuilder(input).reverse().toString();
    }

}

