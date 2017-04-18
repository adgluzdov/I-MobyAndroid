package com.dronteam.adm.i_moby.model.album;

/**
 * Created by adm on 17.04.2017.
 */
public class Photo {
    public Integer id;
    public Integer album_id;
    public Integer owner_id;
    public Integer user_id;
    public String photo_75;
    public String photo_130;
    public String photo_604;
    public String photo_807;
    public Integer width;
    public Integer height;
    public String text;
    public Integer date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(Integer album_id) {
        this.album_id = album_id;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPhoto_75() {
        return photo_75;
    }

    public void setPhoto_75(String photo_75) {
        this.photo_75 = photo_75;
    }

    public String getPhoto_130() {
        return photo_130;
    }

    public void setPhoto_130(String photo_130) {
        this.photo_130 = photo_130;
    }

    public String getPhoto_604() {
        return photo_604;
    }

    public void setPhoto_604(String photo_604) {
        this.photo_604 = photo_604;
    }

    public String getPhoto_807() {
        return photo_807;
    }

    public void setPhoto_807(String photo_807) {
        this.photo_807 = photo_807;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Photo(Integer id, Integer album_id, Integer owner_id, Integer user_id, String photo_75, String photo_130, String photo_604, String photo_807, Integer width, Integer height, String text, Integer date) {

        this.id = id;
        this.album_id = album_id;
        this.owner_id = owner_id;
        this.user_id = user_id;
        this.photo_75 = photo_75;
        this.photo_130 = photo_130;
        this.photo_604 = photo_604;
        this.photo_807 = photo_807;
        this.width = width;
        this.height = height;
        this.text = text;
        this.date = date;
    }
}
