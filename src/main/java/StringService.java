

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringService {

    public static String[] split(String regex, String string) {
        Pattern p = Pattern.compile(regex);

        return p.split(string);
    }

    public static String toTitleCase(String string) {
        char[] charArray = string.toCharArray();

        for (int i = 1; i<string.length(); i++) {
            if (charArray[i] >= 65 && charArray[i] <= 90) { //it's capital
                charArray[i] += 32;
            }
        }
        if (charArray[0] >= 97 && charArray[0] <= 122) { //it's lowercase
            charArray[0] -= 32;
        }
        return new String(charArray);
    }
}
