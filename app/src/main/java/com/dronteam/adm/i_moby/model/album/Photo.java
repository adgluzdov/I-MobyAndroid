package com.dronteam.adm.i_moby.model.album;

/**
 * Created by adm on 17.04.2017.
 */
public class Photo {
    public Integer id;
    public Integer albumId;
    public Integer ownerId;
    public Integer userId;
    public String photo75;
    public String photo130;
    public String photo604;
    public String photo807;
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

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhoto75() {
        return photo75;
    }

    public void setPhoto75(String photo75) {
        this.photo75 = photo75;
    }

    public String getPhoto130() {
        return photo130;
    }

    public void setPhoto130(String photo130) {
        this.photo130 = photo130;
    }

    public String getPhoto604() {
        return photo604;
    }

    public void setPhoto604(String photo604) {
        this.photo604 = photo604;
    }

    public String getPhoto807() {
        return photo807;
    }

    public void setPhoto807(String photo807) {
        this.photo807 = photo807;
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

    public Photo(Integer id, Integer albumId, Integer ownerId, Integer userId, String photo75, String photo130, String photo604, String photo807, Integer width, Integer height, String text, Integer date) {

        this.id = id;
        this.albumId = albumId;
        this.ownerId = ownerId;
        this.userId = userId;
        this.photo75 = photo75;
        this.photo130 = photo130;
        this.photo604 = photo604;
        this.photo807 = photo807;
        this.width = width;
        this.height = height;
        this.text = text;
        this.date = date;
    }
}
