package pl.lborowy.shoplist.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.activeandroid.Model;
import com.activeandroid.query.Select;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.lborowy.shoplist.R;
import pl.lborowy.shoplist.adapters.ProductAdapter;
import pl.lborowy.shoplist.models.Product;


public class ProductsFragment extends Fragment {


    private InteractionListener mListener;

    private ProductAdapter productAdapter;
    private List<Product> productList;

    @BindView(R.id.productsFragment_recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.productsFragment_addButton)
    FloatingActionButton addButton;

    public ProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        loadProducts();
    }

    private void loadProducts() {
        productList = new Select().from(Product.class).execute();
        productAdapter = new ProductAdapter(getActivity(), productList);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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
        productAdapter = null;
        productList = null;
    }


    public interface InteractionListener {
        void addNewProduct();
    }
}
