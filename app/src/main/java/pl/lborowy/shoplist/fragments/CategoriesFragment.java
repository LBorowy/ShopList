package pl.lborowy.shoplist.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.lborowy.shoplist.R;
import pl.lborowy.shoplist.models.Category;


public class CategoriesFragment extends Fragment {


    private InteractionListener mListener;

    @BindView(R.id.categoriesFragment_categoryName)
    EditText categoryName;

    @BindView(R.id.categoryFragment_addButton)
    Button addCategory;

    @BindView(R.id.categoriesFragment_outputText)
    TextView outputText;

    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshOutput();


    }

    private void refreshOutput() {
        // tworzenie SELECTA
        List<Category> categoriesList = new Select().from(Category.class).execute(); // lista
        StringBuilder builder = new StringBuilder();
        for (Category category : categoriesList) {
            builder.append(category.toString());
            builder.append("\n");
        }

        outputText.setText(builder.toString());
    }

    @OnClick(R.id.categoryFragment_addButton)
    public void clickSaveButton() {
        String newCatName = categoryName.getText().toString();
        List<Category> models = new Select().from(Category.class)
                .where(Category.COLUMN_NAME + " like ?", newCatName)
                .execute();
        int count = models.size();

        if (count == 0) {

            Category category = new Category();
            category.setName(categoryName.getText().toString());
            category.save();
//            categoryName.setText(newCatName);
            categoryName.setText("");
        } else {
            showToast("This category exist!");
        }

        refreshOutput();
    }

    private void showToast(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InteractionListener) {
            mListener = (InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement InteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface InteractionListener {
        void doNothing();
    }
}
