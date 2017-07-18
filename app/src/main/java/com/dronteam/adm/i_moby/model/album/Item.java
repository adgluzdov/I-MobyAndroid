package com.dronteam.adm.i_moby.model.album;

/**
 * Created by adm on 17.04.2017.
 */
public class Item {
    public Integer id;
    public Integer owner_id;
    public String title;
    public Integer count;
    public Integer updated_time;
    public Photo photo;
    public static Item ALL_GOODS = new Item(0,null,"Все товары",null,null,null);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
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

    public Integer getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(Integer updated_time) {
        this.updated_time = updated_time;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Item(Integer id, Integer owner_id, String title, Integer count, Integer updated_time, Photo photo) {

        this.id = id;
        this.owner_id = owner_id;
        this.title = title;
        this.count = count;
        this.updated_time = updated_time;
        this.photo = photo;
    }

}
