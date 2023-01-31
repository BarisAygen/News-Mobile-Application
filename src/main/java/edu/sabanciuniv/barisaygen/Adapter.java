package edu.sabanciuniv.barisaygen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelCLassArrayList;

    public Adapter(ArrayList<ModelClass> modelCLassArrayList, Context context) {
        this.modelCLassArrayList = modelCLassArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebViewCLass.class);
                intent.putExtra("url", modelCLassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.title.setText(modelCLassArrayList.get(position).getTitle());
        holder.content.setText(modelCLassArrayList.get(position).getDescription());
        holder.time.setText("Published at: " + modelCLassArrayList.get(position).getPublishedAt());
        Glide.with(context).load(modelCLassArrayList.get(position).getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modelCLassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView content, title, time;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardview);
            title = itemView.findViewById(R.id.mainheading);
            content = itemView.findViewById(R.id.content);
            time = itemView.findViewById(R.id.time);
        }
    }
}
