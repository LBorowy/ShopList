package pl.lborowy.shoplist.dialogs;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.activeandroid.Model;
import com.activeandroid.query.Select;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.lborowy.shoplist.R;
import pl.lborowy.shoplist.adapters.CategorySpinnerAdapter;
import pl.lborowy.shoplist.models.Category;
import pl.lborowy.shoplist.models.Product;

public class AddProductDialog extends DialogFragment {

    @BindView(R.id.addProductDialog_nameText)
    EditText nameText;

    @BindView(R.id.addProductDialog_categorySpinner)
    Spinner categorySpinner;

    @BindView(R.id.addProductDialog_count)
    EditText count;

    @BindView(R.id.addProductDialog_price)
    EditText price;

    @BindView(R.id.addProductDialog_addButton)
    Button addButton;

    private List<Category> categories;
    private CategorySpinnerAdapter spinnerAdapter;
    private OnProductAdded listener;

    public void setListener(OnProductAdded listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_product, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categories = new Select().from(Category.class).execute();
        spinnerAdapter = new CategorySpinnerAdapter(getActivity(), categories);
        categorySpinner.setAdapter(spinnerAdapter);
    }

    @OnClick(R.id.addProductDialog_addButton)
    public void addProductDialog() {
        long selectedItemId = categorySpinner.getSelectedItemId();
        Category category = categories.get((int) selectedItemId);

        Product product = new Product();
        product.setCategory(category);
        product.setName(getName());
        product.setCount(getCount());
        product.setPrice(getPrice());
        product.setIsPurchased(0);
        product.save();
        dismiss();
        listener.onProductAdded();
    }

    private Double getPrice() {
        return Double.parseDouble(price.getText().toString().trim());
    }

    private double getCount() {
        return Double.parseDouble(count.getText().toString().trim());
    }

    private String getName() {
        return nameText.getText().toString().trim();
    }

    public interface OnProductAdded {
        void onProductAdded();
    }
}
