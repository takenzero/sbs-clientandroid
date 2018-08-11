package com.takenzero.sbs.data;

import android.content.Context;
import android.content.res.TypedArray;

import com.takenzero.sbs.R;
import com.takenzero.sbs.model.DashboardCategory;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    public static List<DashboardCategory> getDashboardCategory(Context ctx){
        List<DashboardCategory> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.dashboard_category_icon);
        String title_arr[] = ctx.getResources().getStringArray(R.array.dashboard_category_title);
        for (int i = 0; i < drw_arr.length(); i++) {
            DashboardCategory obj = new DashboardCategory();
            obj.image = drw_arr.getResourceId(i, -1);
            obj.title = title_arr[i];
            obj.imageDrw = ctx.getResources().getDrawable(obj.image);
            items.add(obj);
        }
        return items;
    }
}
