package pl.lborowy.shoplist.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pl.lborowy.shoplist.R;
import pl.lborowy.shoplist.models.Product;
import pl.lborowy.shoplist.viewHolders.ProductViewHolder;

/**
 * Created by RENT on 2017-07-28.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private final LayoutInflater inflater;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.productList = productList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.checkBox.setChecked(product.getPurchased());
        //// TODO: 2017-07-28 more details
        holder.details.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
