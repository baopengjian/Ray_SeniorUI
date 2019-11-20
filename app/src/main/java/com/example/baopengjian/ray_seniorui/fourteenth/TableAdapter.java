package com.example.baopengjian.ray_seniorui.fourteenth;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ray on 2019-11-15.
 */
public interface TableAdapter {

    public final static int IGNORE_ITEM_VIEW_TYPE = -1;

    /**
     * Register an observer that is called when changes happen to the data used
     * by this adapter.
     *
     * @param observer
     *            the object that gets notified when the data set changes.
     */
    void registerDataSetObserver(DataSetObserver observer);

    /**
     * Unregister an observer that has previously been registered with this
     * adapter via {@link #registerDataSetObserver}.
     *
     * @param observer
     *            the object to unregister.
     */
    void unregisterDataSetObserver(DataSetObserver observer);
    public int getRowCount();

    public int getColumnCount();

    public View getView(int row, int column, View convertView, ViewGroup parent);

    public int getWidth(int column);

    public int getHeight(int row);

    public int getItemViewType(int row, int column);

    public int getViewTypeCount();
}
