package com.example.shoppinglistapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {


    Context mContext ;
    ArrayList<Items> items = new ArrayList<>();



    @Override
    public int getCount() {
        return items.size();
    }

    public CustomAdapter(Context context, ArrayList<Items> items){
        mContext = context;

        this.items = items;

    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){

            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_item,parent ,false);


            Items tempItem = (Items) getItem(position);

            TextView tvName = (TextView)convertView.findViewById(R.id.tvName);
            TextView tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);


            tvName.setText(tempItem.getName());
            tvPrice.setText("€" + "" + tempItem.getPrice());


        }
        return convertView;
    }
}
