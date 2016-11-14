
package com.dronteam.adm.i_moby.model;

public class Item {

    public Integer id;
    public Integer ownerId;
    public String title;
    public String description;
    public Price price;
    public Category category;
    public Integer date;
    public String thumbPhoto;
    public Integer availability;

    public Item(Integer id) {
        this.setId(id);
    }

    public Integer getId() {
        return id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getDate() {
        return date;
    }

    public String getThumbPhoto() {
        return thumbPhoto;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
