package basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegularExpressions
 */
public class RegularExpressions {

    public static void main(String[] args) {
        String multilineText = "на самом деле регулярное выражение\n" + "это шаблон для поиска строки в\n" + "тексте \n"
                + "В Java исходным представлением этого\n" + " шаблона";

        // слова с буквы "с"
        // Pattern pattern = Pattern.compile("\\b[с]{1}\\S+");

        // строки, которые начинаются с предлогов
        // Pattern pattern = Pattern.compile("^\\S{1,2}\\s+.*$", Pattern.MULTILINE);

        // строки из одного слова (и любого количества пробельных символов)
        Pattern pattern = Pattern.compile("^\\s*\\S*\\s*$", Pattern.MULTILINE);
        
        Matcher matcher = pattern.matcher(multilineText);
        while (matcher.find()) {
            System.out.println(multilineText.substring(matcher.start(), matcher.end()));
        }
    }
}