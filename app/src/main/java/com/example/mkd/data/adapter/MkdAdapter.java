package com.example.mkd.data.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mkd.R;
import com.example.mkd.data.model.AddressDTO;
import com.example.mkd.data.model.ObjectMkd;
import com.example.mkd.ui.main.MainActivity;

import java.util.List;

public class MkdAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private List<ObjectMkd> mkdList;
    private Context context;

    public MkdAdapter(Context context, List<ObjectMkd> bookList) {

        this.inflater = LayoutInflater.from(context);
        this.mkdList = bookList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvAddress,
                tvHouse,
                tvBlock;
        private final LinearLayout ll_item;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            ll_item = itemView.findViewById(R.id.ll_item);
            tvAddress = itemView.findViewById(R.id.tv_name);
            tvHouse = itemView.findViewById(R.id.tv_author);
            tvBlock = itemView.findViewById(R.id.tv_genre);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_book_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecyclerView.ViewHolder holder,
            @SuppressLint("RecyclerView") final int position
    ) {

        ObjectMkd mkd = mkdList.get(position);

        AddressDTO a = mkd.getAddress();
        if (a == null) {
            a = new AddressDTO();
            a.setLocality("без адреса");
        }
        ((MyViewHolder) holder).tvAddress.setText(a.getLocality() + ", " + a.getStreet());
        ((MyViewHolder) holder).tvHouse.setText(mkd.getHouseNumber());
        ((MyViewHolder) holder).tvBlock.setText(mkd.getHouseBlock());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) context).openEditFragment(mkdList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {

        return mkdList.size();
    }
    public ObjectMkd getItem(int pos) {

        return mkdList.get(pos);
    }
}
