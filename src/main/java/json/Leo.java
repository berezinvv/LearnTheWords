package json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Leo {

    @JsonProperty("error_msg")
    private String error_msg;
    @JsonProperty("translate_source")
    private String translate_source;
    @JsonProperty("word_forms")
    private List<WordForm> word_forms = null;
    @JsonProperty("pic_url")
    private String pic_url;
    @JsonProperty("translate")
    private List<Translate> translate = null;
    @JsonProperty("transcription")
    private String transcription;
    @JsonProperty("word_top")
    private Integer word_top;
    @JsonProperty("word_id")
    private Integer word_id;
    @JsonProperty("sound_url")
    private String sound_url;
    @JsonProperty("is_user")
    private  int is_user;

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getTranslate_source() {
        return translate_source;
    }

    public void setTranslate_source(String translate_source) {
        this.translate_source = translate_source;
    }

    public List<WordForm> getWord_forms() {
        return word_forms;
    }

    public void setWord_forms(List<WordForm> word_forms) {
        this.word_forms = word_forms;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public List<Translate> getTranslate() {
        return translate;
    }

    public void setTranslate(List<Translate> translate) {
        this.translate = translate;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public Integer getWord_top() {
        return word_top;
    }

    public void setWord_top(Integer word_top) {
        this.word_top = word_top;
    }

    public String getSound_url() {
        return sound_url;
    }

    public void setSound_url(String sound_url) {
        this.sound_url = sound_url;
    }

    public int getIs_user() {
        return is_user;
    }

    public void setIs_user(int is_user) {
        this.is_user = is_user;
    }

    public Integer getWord_id() {
        return word_id;
    }

    public void setWord_id(Integer word_id) {
        this.word_id = word_id;
    }
}
