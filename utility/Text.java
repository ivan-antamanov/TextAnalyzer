package TextAnalyzer.Application.utility;

/**
 * Created by iantaman on 08.10.2015.
 */
public class Text {

    private String inputText;

    public Text() {
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    @Override
    public String toString() {
        return inputText;
    }
}
