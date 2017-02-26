package com.angcyo.uiview.recycler;

import android.content.Context;

import java.util.List;

/**
 * Created by angcyo on 2017-1-14.
 */
public abstract class RMaxAdapter<T> extends RBaseAdapter<T> {

    private int max_count = 1;

    public RMaxAdapter(Context context) {
        super(context);
    }

    public RMaxAdapter(Context context, List<T> datas) {
        super(context, datas);
    }

    /**
     * 设置显示的最大的数量
     */
    public void setMaxcount(int max_count) {
        this.max_count = max_count;
    }

    @Override
    public void setEnableLoadMore(boolean enableLoadMore) {
        //不支持加载更多模式
    }

    @Override
    public int getItemCount() {
        return Math.min(max_count, super.getItemCount());
    }

    /**
     * 真实Item的数量
     */
    public int getItemRawCount() {
        if (mAllDatas == null) {
            return 0;
        }
        return mAllDatas.size();
    }
}
