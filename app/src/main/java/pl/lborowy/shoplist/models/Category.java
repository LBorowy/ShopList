package pl.lborowy.shoplist.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by RENT on 2017-07-27.
 */

//@Table(name = "Categories")
public class Category extends Model {
    public static final String COLUMN_NAME = "cname";

    @Column(name = COLUMN_NAME, notNull = true)
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}