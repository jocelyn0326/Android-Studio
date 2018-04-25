package com.example.jocelyn.homework1_2;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.NumberViewHolder> {
    SparseBooleanArray mCheckState = new SparseBooleanArray(); //存(key,value)，key為被勾選的位置，value是被選擇的boolean值
    int mNumberItems;
    List<String> mStringList = new ArrayList<>();//存放被選到的


    public MyAdapter(int numberOfItems) {
        mNumberItems = numberOfItems;
    }
    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //adapter does create ViewHolder objects and inflates item views in its onCreateViewHolder function
//        Context context = parent.getContext();
//        int layoutIDFromXML = R.layout.checkbox_list;
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(layoutIDFromXML, parent, false);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkbox_list,null);

        NumberViewHolder viewHolder = new NumberViewHolder(itemView);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final NumberViewHolder holder, final int position) {
        holder.checkBox.setTag(position); //0~99
        holder.bind(position+1); //checkbox綁定的值是1~100
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = (int) holder.checkBox.getTag();
                if (holder.checkBox.isChecked() == true) {
                    mCheckState.put(pos, true);
                    mStringList.add(holder.checkBox.getText().toString());
                } else {
                    mCheckState.delete(pos);
                    mStringList.remove(holder.checkBox.getText().toString());
                }

            }
        });
        holder.checkBox.setChecked(mCheckState.get(position, false));
        //mCheckState.get(position,不符合傳回false)
        //為什麼要再SetChecked
    }



    public String listArrayToString() {
        String output = "";
        for (String s : mStringList) {
            output += s + ", ";
        }
        output = output.substring(0,output.length()-2);
        return output;
    }


    public String getOutput() {
        return listArrayToString();
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.cb_item); //why add itemview?

        public NumberViewHolder(View itemView) {
            super(itemView); //??
            checkBox.setChecked(false);
        }

        void bind(int listIndex) {
            checkBox.setText("" + String.valueOf(listIndex));
        }
    }


}
