package ug.kinan.bogortourism.pojo;

/**
 * Created by farhan on 6/22/17.
 */

public class Twitter {

    private String id, text, username, image;

    public Twitter(){

    }

    public Twitter(String id, String text, String username, String image){
        this.id = id;
        this.text = text;
        this.username = username;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
