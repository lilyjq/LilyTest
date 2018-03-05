package com.example.lily.lilytest.metrial_design.toolbar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lily.lilytest.R;

import java.util.ArrayList;

/**
 * Created by ljq
 * on 2017/12/22.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.myViewholder> {

    private Context context;
    private ArrayList<String> list;

    public TestAdapter(Context context,ArrayList<String> list) {
        this.context = context;
        this.list=list;
    }

    @Override
    public myViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new myViewholder(LayoutInflater.from(context).inflate(R.layout.item_recycler,null));
    }

    @Override
    public void onBindViewHolder(myViewholder holder, int position) {
        if(holder!=null){
            holder.textView.setText(list.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myViewholder extends RecyclerView.ViewHolder{
        TextView textView;

        public myViewholder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.test_text);
        }
    }
}
