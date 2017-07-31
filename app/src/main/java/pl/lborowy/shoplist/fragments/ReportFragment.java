package pl.lborowy.shoplist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.activeandroid.query.Select;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.lborowy.shoplist.R;
import pl.lborowy.shoplist.models.Product;

/**
 * Created by RENT on 2017-07-31.
 */

public class ReportFragment extends Fragment{

    @BindView(R.id.reportFragment_outputText)
    TextView outputText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadReport();
    }

    private void loadReport() {
        int purchasedItems = getPurchasedItemsCount();
        int allItems = getAllItemsCount();

        String purchased = String.format("Progress %d/%d", purchasedItems, allItems);
        outputText.setText(purchased);
    }

    private int getPurchasedItemsCount() {
        return new Select().from(Product.class).where("is_purchased != 0").count();
    }

    private int getAllItemsCount() { // liczba wszystkich elementów
        return new Select().from(Product.class).count();
    }
}
