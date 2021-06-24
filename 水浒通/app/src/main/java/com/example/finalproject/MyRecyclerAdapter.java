package com.example.finalproject;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

/**
 *
 */


public class MyRecyclerAdapter extends RecyclerView.Adapter<com.example.finalproject.MyRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Figure> Figures;
    private OnItemClickListener mOnItemClickListener = null;

    public MyRecyclerAdapter(List<Figure> figures, Context context)
    {
        this.Figures = figures;
        this.context = context;
    }

    @Override
    public int getItemCount()
    {
        return Figures.size();
    }

    public interface OnItemClickListener
    {
        void onClick(int position);
        void onLongClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.mOnItemClickListener=onItemClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView pic;
        public TextView name;
        public TextView nickname;

        public ViewHolder(View view)
        {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            nickname = (TextView) view.findViewById(R.id.nickname);
            pic = (ImageView) view.findViewById(R.id.figure_pic);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        holder.name.setText(String.valueOf(Figures.get(position).getName()));
        Typeface type = Typeface.createFromAsset(context.getAssets(), "gufeng.TTF");
        holder.name.setTypeface(type);
        holder.nickname.setText(String.valueOf(Figures.get(position).getNickname()));
        holder.nickname.setTypeface(type);

        if(Figures.get(position).getPicPath()!=null){
            Uri tempUri= Uri.fromFile(new File(Figures.get(position).getPicPath()));
            holder.pic.setImageURI(tempUri);
        } else
           holder.pic.setImageResource(Figures.get(position).getPic());

        if(mOnItemClickListener!=null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    mOnItemClickListener.onClick(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    mOnItemClickListener.onLongClick(position);
                    return false;
                }
            });
        }
    }
}
