
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (owner_id != null ? !owner_id.equals(item.owner_id) : item.owner_id != null)
            return false;
        if (title != null ? !title.equals(item.title) : item.title != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null)
            return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        if (category != null ? !category.equals(item.category) : item.category != null)
            return false;
        if (date != null ? !date.equals(item.date) : item.date != null) return false;
        if (thumb_photo != null ? !thumb_photo.equals(item.thumb_photo) : item.thumb_photo != null)
            return false;
        return availability != null ? availability.equals(item.availability) : item.availability == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (owner_id != null ? owner_id.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (thumb_photo != null ? thumb_photo.hashCode() : 0);
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        return result;
    }
}
