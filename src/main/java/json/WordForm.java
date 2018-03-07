package json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WordForm {

    @JsonProperty("word")
    private String word;
    @JsonProperty("type")
    private String type;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
