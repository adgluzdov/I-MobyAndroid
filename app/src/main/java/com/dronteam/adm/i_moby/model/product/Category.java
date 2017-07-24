
package com.dronteam.adm.i_moby.model.product;

public class Category {

    public Integer id;
    public String name;
    public Section section;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Section getSection() {
        return section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        return section != null ? section.equals(category.section) : category.section == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (section != null ? section.hashCode() : 0);
        return result;
    }
}
