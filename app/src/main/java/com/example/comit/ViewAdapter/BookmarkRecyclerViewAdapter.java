package com.example.comit.ViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comit.R;

import java.util.ArrayList;

public class BookmarkRecyclerViewAdapter extends RecyclerView.Adapter<BookmarkRecyclerViewAdapter.ViewHolder> {
    private ArrayList<RecyclerViewItem> mData = null;

    public BookmarkRecyclerViewAdapter(FragmentActivity activity, ArrayList<RecyclerViewItem> data){
        mData = data;
    }

    @NonNull
    @Override
    public BookmarkRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.recycler_bookmark,parent,false);
        BookmarkRecyclerViewAdapter.ViewHolder viewHolder = new BookmarkRecyclerViewAdapter.ViewHolder(v);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull BookmarkRecyclerViewAdapter.ViewHolder holder, int position) {
        RecyclerViewItem item = mData.get(position);

        holder.textview1.setText(item.getMainTitle());
        holder.textview2.setText(item.getSubTitle());
    }

    public void addItem(RecyclerViewItem data){
        mData.add(data);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textview1;
        TextView textview2;

        ViewHolder(View itemView){
            super(itemView);

            textview1 = itemView.findViewById(R.id.bookmark_recycler_tv1);
            textview2 = itemView.findViewById(R.id.bookmark_recycler_tv2);
        }
        void onBind(RecyclerViewItem data){
            textview1.setText(data.getMainTitle());
            textview2.setText(data.getSubTitle());
        }
    }
}
