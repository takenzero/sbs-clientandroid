package com.takenzero.sbs.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.takenzero.sbs.model.DownlineDetail;

import java.util.List;

public class AdapterDownline extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_ITEM = 1;
    private final int VIEW_SECTION = 0;

    private List<DownlineDetail> items;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public AdapterDownline(Context context, List<DownlineDetail> items) {
        this.items = items;
        ctx = context;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, DownlineDetail obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
