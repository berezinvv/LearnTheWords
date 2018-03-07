package json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Translate {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("is_user")
    private  int is_user;
    @JsonProperty("value")
    private String value;
    @JsonProperty("votes")
    private Integer votes;
    @JsonProperty("pic_url")
    private String picUrl;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIs_user() {
        return is_user;
    }

    public void setIs_user(int is_user) {
        this.is_user = is_user;
    }
}
