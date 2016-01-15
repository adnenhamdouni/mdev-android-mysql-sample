package com.leadertun.android.jsonparsingmysqldb.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leadertun.android.jsonparsingmysqldb.R;
import com.leadertun.android.jsonparsingmysqldb.wrapper.UserWrapper;

import java.util.ArrayList;

/**
 * Created by adnen on 15/01/16.
 */
public class UserAdapter extends
        RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private ArrayList<UserWrapper> mObjectsList = new ArrayList<UserWrapper>();

    public UserAdapter(ArrayList<UserWrapper> itemsList) {

        mObjectsList = itemsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_layout, parent, false);

        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mItemName.setText(mObjectsList.get(position).getNom());
        holder.mItemAge.setText(Integer.toString(mObjectsList.get(position).getmAge()));

        holder.mItemPhoto.setImageResource(R.drawable.user_profile);
//        holder.mItemPhoto.setImageResource(Integer.parseInt(mObjectsList.get(position)
//                .getImage()));
    }

    @Override
    public int getItemCount() {
        return mObjectsList.size();
    }

    public void add(int position, UserWrapper user) {
        mObjectsList.add(position, user);
        notifyItemInserted(position);
    }

    public void remove(UserWrapper user) {
        int position = mObjectsList.indexOf(user);
        mObjectsList.remove(position);
        notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mItemName;
        public TextView mItemAge;
        public ImageView mItemPhoto;

        public ViewHolder(View view) {
            super(view);
            mItemName = (TextView) view.findViewById(R.id.textview_user_name);
            mItemAge = (TextView) view.findViewById(R.id.textview_user_age);
            mItemPhoto = (ImageView) view.findViewById(R.id.imageview_user);

        }
    }
}
