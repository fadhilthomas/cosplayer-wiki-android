package com.lappungdev.cosplayerwiki.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.snackbar.Snackbar;
import com.lappungdev.cosplayerwiki.R;
import com.lappungdev.cosplayerwiki.activity.CosplayDetailActivity;
import com.lappungdev.cosplayerwiki.activity.MainActivity;
import com.lappungdev.cosplayerwiki.model.Cosplay;

import java.util.List;


public class RecyclerViewCosplayAdapter extends RecyclerView.Adapter<RecyclerViewCosplayAdapter.ViewHolder> {

    private Context context;
    private List<Cosplay> cosplayList;

    public RecyclerViewCosplayAdapter(Context context, List<Cosplay> TempList) {
        this.cosplayList = TempList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items_cosplay, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Cosplay cosplayInfo = cosplayList.get(position);

        holder.tvCosplayNickname.setText(String.format("Nickname: %s", cosplayInfo.getCosplayNickname()));
        holder.tvCosplayCountry.setText(String.format("Country: %s", cosplayInfo.getCosplayCountry()));
        Glide.with(context).load(cosplayInfo.getCosplayPhoto())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(holder.ivCosplayPhoto);
    }

    @Override
    public int getItemCount() {

        return cosplayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCosplayPhoto;
        TextView tvCosplayNickname, tvCosplayCountry;
        Button btCosplayFavorite, btCosplayShare;

        ViewHolder(final View itemView) {
            super(itemView);

            ivCosplayPhoto = itemView.findViewById(R.id.ivCosplayPhoto);
            tvCosplayNickname = itemView.findViewById(R.id.tvCosplayNickname);
            tvCosplayCountry = itemView.findViewById(R.id.tvCosplayCountry);
            btCosplayFavorite = itemView.findViewById(R.id.btCosplayFavorite);
            btCosplayShare = itemView.findViewById(R.id.btCosplayShare);

            itemView.setOnClickListener(v -> passData(getAdapterPosition()));

            btCosplayShare.setOnClickListener(v -> Snackbar.make(MainActivity.rlMain, String.format("Share: %s", cosplayList.get(getAdapterPosition()).getCosplayNickname()), Snackbar.LENGTH_SHORT).show());
            btCosplayFavorite.setOnClickListener(v -> Snackbar.make(MainActivity.rlMain, String.format("Favorite: %s", cosplayList.get(getAdapterPosition()).getCosplayNickname()), Snackbar.LENGTH_SHORT).show());
        }
    }

    private void passData(int position){
        Intent i = new Intent(context, CosplayDetailActivity.class);
        i.putExtra("cosplayNickname", cosplayList.get(position).getCosplayNickname());
        i.putExtra("cosplayGender", cosplayList.get(position).getCosplayGender());
        i.putExtra("cosplayCountry", cosplayList.get(position).getCosplayCountry());
        i.putExtra("cosplayPhoto", cosplayList.get(position).getCosplayPhoto());
        i.putExtra("cosplayID", cosplayList.get(position).getCosplayID());
        i.putExtra("cosplayBirthday", cosplayList.get(position).getCosplayBirthday());
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
