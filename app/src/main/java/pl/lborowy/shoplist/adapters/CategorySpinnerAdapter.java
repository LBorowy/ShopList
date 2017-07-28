package pl.lborowy.shoplist.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

import pl.lborowy.shoplist.models.Category;

/**
 * Created by RENT on 2017-07-28.
 */

public class CategorySpinnerAdapter extends ArrayAdapter<Category> {
    private final LayoutInflater inflater;
    private Context applicationContext;
    private List<Category> categories;

    public CategorySpinnerAdapter(Context applicationContext, List<Category> categories) {
        super(applicationContext, android.R.layout.simple_list_item_1);
        this.applicationContext = applicationContext;
        this.categories = categories;
        inflater = (LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        TextView text = (TextView) view.findViewById(android.R.id.text1);

        Category item = getItem(position);
        text.setText(item.getName());

        return view;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Category getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getDropDownView(position, convertView, parent);
    }

    @Override
    public boolean isEmpty() {
        return categories.isEmpty();
    }
}
