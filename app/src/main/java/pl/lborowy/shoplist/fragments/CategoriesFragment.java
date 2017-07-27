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
        View view =  inflater.inflate(R.layout.fragment_categories, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @OnClick(R.id.categoryFragment_addButton)
    public void clickSaveButton() {
        Category category = new Category();
        category.setName("kategoria");
        category.save();
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
