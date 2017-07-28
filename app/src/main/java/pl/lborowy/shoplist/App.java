package pl.lborowy.shoplist;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import pl.lborowy.shoplist.models.Category;
import pl.lborowy.shoplist.models.Product;

/**
 * Created by RENT on 2017-07-27.
 */

public class App extends Application { // obiekt App, ktory dziedziczy po Application (name do Manifestu!)

    @Override // to onCreate wywoła się jako pierwsze ze wszystkich innych
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(createActiveAndroidConfiguration());
    }

    private Configuration createActiveAndroidConfiguration() {
        Configuration.Builder configuration = new Configuration.Builder(this);
        configuration.addModelClass(Category.class);
        configuration.addModelClass(Product.class);
        return configuration.create();
    }
}
