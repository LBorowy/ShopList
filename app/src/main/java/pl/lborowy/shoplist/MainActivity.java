package pl.lborowy.shoplist;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import pl.lborowy.shoplist.fragments.CategoriesFragment;
import pl.lborowy.shoplist.fragments.ProductsFragment;
import pl.lborowy.shoplist.fragments.SettingsFragment;

public class MainActivity extends BaseActivity implements CategoriesFragment.InteractionListener,
        ProductsFragment.InteractionListener {
    private static final int EXTERNAL_STORAGE_REQUEST_CODE = 1500;
    private String currentPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        openProductsFragment();
    }

    private void openProductsFragment() {
        openFragment(new ProductsFragment(), false);
    }

    private void openCategoriesFragment() {
        openFragment(new CategoriesFragment(), false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                openSettingsFragment();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openSettingsFragment() {
        openFragment(new SettingsFragment(), false);
    }

    @Override
    public void doNothing() {

    }

    @Override
    public void addedNewProduct() {

    }
}
