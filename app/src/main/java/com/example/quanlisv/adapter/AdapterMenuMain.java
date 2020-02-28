package com.example.quanlisv.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlisv.R;
import com.example.quanlisv.activity.HocPhanActivity;
import com.example.quanlisv.model.MenuMain;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterMenuMain extends RecyclerView.Adapter<AdapterMenuMain.ItemHolder>  {

    ArrayList<MenuMain> arrMenu;
    Context context;

    public AdapterMenuMain(ArrayList<MenuMain> arrMenu, Context context) {
        this.arrMenu = arrMenu;
        this.context = context;
    }
//    public AdapterMenuMain(Context context, ArrayList<MenuMain> arrMenu) {
//        this.context = context;
//        this.arrMenu = arrMenu;
//    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_menu_main,null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder holder, final int position) {
        MenuMain menuMain = arrMenu.get(position);
        holder.txttenmenu.setText(menuMain.getTenmenu());
        Picasso.with(context).load(menuMain.getAnhmenu())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imghinhmenu);

        holder.dongMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    switch (position){
                        case 0:
                            Intent intent = new Intent(context ,HocPhanActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                            break;
                    }

            }
        });


    }

    @Override
    public int getItemCount() {
        return arrMenu.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imghinhmenu;
        public TextView txttenmenu;
        public LinearLayout dongMenu;




        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imghinhmenu = (ImageView) itemView.findViewById(R.id.img_menu_main);
            txttenmenu = (TextView) itemView.findViewById(R.id.txt_ten_menu_main);
            dongMenu = (LinearLayout) itemView.findViewById(R.id.dong_menu_main);
        }


    }

}
