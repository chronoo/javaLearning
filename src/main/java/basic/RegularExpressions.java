package basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegularExpressions
 */
public class RegularExpressions {

    public static void main(String[] args) {
        String multilineText =  "на самом деле регулярное выражение\n" + 
                                "это шаблон для поиска строки в\n" + 
                                "тексте \n" + 
                                "В Java исходным представлением этого\n" + 
                                " шаблона" +
                                "всегда является строка";

        // слова с буквы "с"
        // Pattern pattern = Pattern.compile("\\b[с]{1}\\S+");

        // строки, которые начинаются с предлогов
        // Pattern pattern = Pattern.compile("^\\S{1,2}\\s+.*$", Pattern.MULTILINE);

        // строки из одного слова (и любого количества пробельных символов)
        //Pattern pattern = Pattern.compile("^\\s*\\S*\\s*$", Pattern.MULTILINE);
        
        // строки, которые включают символы и на кириллице, и на латинице
        //Pattern pattern = Pattern.compile("^.*([a-zA-Z]++.*[а-яА-Я]++|[а-яА-Я]++.*[a-zA-Z]++).*$", Pattern.MULTILINE);

        // строки с прописной буквы
        //Pattern pattern = Pattern.compile("^[А-ЯA-Z].*$", Pattern.MULTILINE);

        // слова, которые оканчиваются на "ка"
        Pattern pattern = Pattern.compile("\\b\\S*ка\\b");

        Matcher matcher = pattern.matcher(multilineText);
        while (matcher.find()) {
            System.out.println(multilineText.substring(matcher.start(), matcher.end()));
        }
    }
}