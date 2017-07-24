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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (owner_id != null ? !owner_id.equals(item.owner_id) : item.owner_id != null)
            return false;
        if (title != null ? !title.equals(item.title) : item.title != null) return false;
        if (count != null ? !count.equals(item.count) : item.count != null) return false;
        if (updated_time != null ? !updated_time.equals(item.updated_time) : item.updated_time != null)
            return false;
        return photo != null ? photo.equals(item.photo) : item.photo == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (owner_id != null ? owner_id.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (updated_time != null ? updated_time.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }
}
