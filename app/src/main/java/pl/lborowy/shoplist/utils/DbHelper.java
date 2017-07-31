package pl.lborowy.shoplist.utils;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.activeandroid.ActiveAndroid;

/**
 * Created by RENT on 2017-07-31.
 */

public class DbHelper {
    public static double getCostsOfCategory(String categoryName) {
        return DbHelper.getDoubleFromRawQuery(
                "SELECT sum(price * count) AS count from 'products' AS 'p' " +
                "JOIN 'categories' AS 'c' ON c.id == p.category " +
                "WHERE c.cname LIKE \"" + categoryName + "\"");
    }

    public static double getDoubleFromRawQuery(String query) {
        SQLiteDatabase database = ActiveAndroid.getDatabase();
        Cursor cursor = database.rawQuery(query, null);
//        Cursor cursor = database.rawQuery("SELECT count(*) AS count from 'products'", null);
        cursor.moveToFirst();
        return cursor.getDouble(0);
    }
}
