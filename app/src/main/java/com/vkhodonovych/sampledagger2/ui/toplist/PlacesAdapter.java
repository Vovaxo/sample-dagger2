package com.vkhodonovych.sampledagger2.ui.toplist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vkhodonovych.sampledagger2.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemPlaceDetail.setText("Item " + position);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemPlaceImage) ImageView itemPlaceImage;
        @BindView(R.id.itemPlaceDetail) TextView itemPlaceDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
