package com.nekodst.majalahsport.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nekodst.majalahsport.R;
import com.nekodst.majalahsport.model.Majalah;
import com.nekodst.majalahsport.ui.DetailActivity;

import java.util.List;

public class MajalahAdapter extends RecyclerView.Adapter<MajalahAdapter.ViewHolder> {
    List<Majalah> majalahs;
    Context context;

    public MajalahAdapter(Context context) {
        this.context = context;
    }

    public void setMajalahs(List<Majalah> majalahs) {
        this.majalahs = majalahs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.majalah_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.judul.setText(majalahs.get(i).getJudul());
        viewHolder.detail.setText(majalahs.get(i).getDetail());
        String name = majalahs.get(i).getFoto();

        if (name.equals("img"+majalahs.get(i).getId())){
            int iImg = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
            Drawable imgs = context.getResources().getDrawable(iImg);

            Glide.with(context)
                    .load(imgs)
                    .fitCenter().centerCrop()
                    .into(viewHolder.foto);
        }
        else {
            String img = majalahs.get(i).getFoto();

            Glide.with(context)
                    .load(img)
                    .fitCenter().centerCrop()
                    .into(viewHolder.foto);
        }
    }

    @Override
    public int getItemCount() {
        return majalahs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul, detail;
        ImageView foto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.judul);
            detail = itemView.findViewById(R.id.detail);
            foto = itemView.findViewById(R.id.foto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = Integer.parseInt(majalahs.get(getAdapterPosition()).getId());

                    Intent intent= new Intent();
                    intent.setClass(v.getContext(), DetailActivity.class);
                    intent.putExtra("id", String.valueOf(id));
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
