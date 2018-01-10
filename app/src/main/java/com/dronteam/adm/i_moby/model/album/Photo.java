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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (id != null ? !id.equals(photo.id) : photo.id != null) return false;
        if (album_id != null ? !album_id.equals(photo.album_id) : photo.album_id != null)
            return false;
        if (owner_id != null ? !owner_id.equals(photo.owner_id) : photo.owner_id != null)
            return false;
        if (user_id != null ? !user_id.equals(photo.user_id) : photo.user_id != null) return false;
        if (photo_75 != null ? !photo_75.equals(photo.photo_75) : photo.photo_75 != null)
            return false;
        if (photo_130 != null ? !photo_130.equals(photo.photo_130) : photo.photo_130 != null)
            return false;
        if (photo_604 != null ? !photo_604.equals(photo.photo_604) : photo.photo_604 != null)
            return false;
        if (photo_807 != null ? !photo_807.equals(photo.photo_807) : photo.photo_807 != null)
            return false;
        if (width != null ? !width.equals(photo.width) : photo.width != null) return false;
        if (height != null ? !height.equals(photo.height) : photo.height != null) return false;
        if (text != null ? !text.equals(photo.text) : photo.text != null) return false;
        return date != null ? date.equals(photo.date) : photo.date == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (album_id != null ? album_id.hashCode() : 0);
        result = 31 * result + (owner_id != null ? owner_id.hashCode() : 0);
        result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
        result = 31 * result + (photo_75 != null ? photo_75.hashCode() : 0);
        result = 31 * result + (photo_130 != null ? photo_130.hashCode() : 0);
        result = 31 * result + (photo_604 != null ? photo_604.hashCode() : 0);
        result = 31 * result + (photo_807 != null ? photo_807.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
