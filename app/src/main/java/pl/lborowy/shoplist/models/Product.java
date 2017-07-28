package pl.lborowy.shoplist.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by RENT on 2017-07-28.
 */

public class Product extends Model {

    @Column(name = "name", notNull = true)
    private String name;

    @Column(name = "category", notNull = true)
    private Category category;

    @Column(name = "count", notNull = true)
    private Double count;

    @Column(name = "price", notNull = true)
    private Double price;

    @Column(name = "is_purchased", notNull = true)
    private Integer isPurchased;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIsPurchased() {
        return isPurchased;
    }

    public void setIsPurchased(Integer isPurchased) {
        this.isPurchased = isPurchased;
    }
/*
    public boolean getPurchased() {
        return isPurchased!= null && isPurchased != 0;
    }
    public void setPurchased(boolean isPurchased) {
        if(isPurchased)
            this.isPurchased = 1;
        else
            this.isPurchased = 0;
    }*/

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", count=" + count +
                ", price=" + price +
                ", isPurchased=" + isPurchased +
                '}';
    }

    public String getDetails() {
        return String.format("%s x%s %s$ (%s)",name, count, price, category.getName());
    }
}
