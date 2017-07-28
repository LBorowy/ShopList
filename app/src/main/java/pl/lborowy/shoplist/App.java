package pl.lborowy.shoplist;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.activeandroid.query.Select;

import pl.lborowy.shoplist.models.Category;
import pl.lborowy.shoplist.models.Product;

/**
 * Created by RENT on 2017-07-27.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(createActiveAndroidConfiguration());
        initCategories();
    }

    private Configuration createActiveAndroidConfiguration() {
        Configuration.Builder configuration = new Configuration.Builder(this);
        configuration.addModelClass(Category.class);
        configuration.addModelClass(Product.class);
        return configuration.create();
    }

    private void initCategories() {
        if (isCategoriesEmpty()) {
            new Category("Owoce").save();
            new Category("Warzywa").save();
            new Category("Rozrywka").save();
            new Category("Chemia").save();
            new Category("Mieso").save();
        }
    }

    private boolean isCategoriesEmpty() {
        return new Select().from(Category.class).count() == 0;
    }
}
