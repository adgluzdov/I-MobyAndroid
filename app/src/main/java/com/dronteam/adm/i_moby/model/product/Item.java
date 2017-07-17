
package com.dronteam.adm.i_moby.model.product;

public class Item {
    public static String MESSEGE_ORDER;

    public Integer id;
    public Integer owner_id;
    public String title;
    public String description;
    public Price price;
    public Category category;
    public Integer date;
    public String thumb_photo;
    public Integer availability;

    public Item(Integer id) {
        this.setId(id);
    }

    public Integer getId() {
        return id;
    }

    public Integer getOwner_id() {
        return owner_id;
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

    public String getThumb_photo() {
        return thumb_photo;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public void setThumb_photo(String thumb_photo) {
        this.thumb_photo = thumb_photo;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }
}
