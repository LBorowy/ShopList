package pl.lborowy.shoplist.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by RENT on 2017-07-27.
 */

public class Category extends Model {


    @Column(name = "cname", notNull = true) // cname - kolumna w naszej tabeli, a name w apce/kod/
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category " + name;
    }
}
