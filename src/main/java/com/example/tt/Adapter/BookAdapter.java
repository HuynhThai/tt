package com.example.tt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tt.R;
import com.example.tt.model.Book;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {
    Context context;
    ArrayList<Book> arraybook;

    public BookAdapter(Context context, ArrayList<Book> arraybook) {
        this.context = context;
        this.arraybook = arraybook;
    }

    @Override
    public int getCount() {
        return arraybook.size();
    }

    @Override
    public Object getItem(int i) {
        return arraybook.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder {
        public TextView txtten,txtgia;
        public ImageView imghinhanh;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_book,null);
            viewHolder.txtten= convertView.findViewById(R.id.textviewbook);
            viewHolder.txtgia = convertView.findViewById(R.id.textviewgiabook);
            viewHolder.imghinhanh = convertView.findViewById(R.id.imageviewbook);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Book book = (Book) getItem(position);
        viewHolder.txtten.setText("Tên sản phẩm : " + (book.getTensanpham()));
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgia.setText("Giá : " + decimalFormat.format(book.getGiasanpham()) + "Đ");
        Picasso.with(context).load(book.getHinhanhsanpham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imghinhanh);
        return convertView;
    }
}
