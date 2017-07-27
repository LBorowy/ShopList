package pl.lborowy.shoplist.models;

import com.activeandroid.Model;

/**
 * Created by RENT on 2017-07-27.
 */

public class Category extends Model {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
