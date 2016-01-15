package com.leadertun.android.jsonparsingmysqldb.adapter;

/**
 * Created by adnen on 15/01/16.
 */
public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
