package com.example.tt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tt.R;
import com.example.tt.model.ItemType;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemTypeAdapter extends BaseAdapter {
    ArrayList<ItemType> arrayListitemtype;
    Context context;

    @Override
    public int getCount() {
        return arrayListitemtype.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListitemtype.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder{
        TextView txttypename;
        ImageView imgtype;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if ( view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.items, null);
            viewHolder.txttypename = (TextView) view.findViewById(R.id.type_item);
            viewHolder.imgtype = (ImageView) view.findViewById(R.id.image_item);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
            ItemType itemType = (ItemType) getItem(i);
            viewHolder.txttypename.setText(itemType.getItemtypename());
            Picasso.with(context).load(itemType.getItemtypeimage()).placeholder(R.drawable.loading).error(R.drawable.error).into(viewHolder.imgtype);
        }
        return view;
    }
}
