package basic.filter;

/**
 * KeywordAnalyzer
 */
public abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        String[] keywords = getKeywords();
        Label wrongLabel = getLabel();

        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return wrongLabel;
            }
        }
        
        return Label.OK;
    }
}