package pl.lborowy.shoplist.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.lborowy.shoplist.R;

/**
 * Created by RENT on 2017-07-27.
 */

public class ProductViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.productItem_details)
    public TextView details;

    @BindView(R.id.productItem_checkBox)
    public CheckBox checkBox;

    public ProductViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}