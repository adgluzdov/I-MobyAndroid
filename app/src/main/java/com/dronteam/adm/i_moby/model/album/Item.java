package com.dronteam.adm.i_moby.model.album;

/**
 * Created by adm on 17.04.2017.
 */
public class Item {
    public Integer id;
    public Integer ownerId;
    public String title;
    public Integer count;
    public Integer updatedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Integer updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Item(Integer id, Integer ownerId, String title, Integer count, Integer updatedTime, Photo photo) {

        this.id = id;
        this.ownerId = ownerId;
        this.title = title;
        this.count = count;
        this.updatedTime = updatedTime;
        this.photo = photo;
    }

    public Photo photo;
}
