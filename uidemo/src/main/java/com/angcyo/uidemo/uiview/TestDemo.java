package com.angcyo.uidemo.uiview;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;

import com.angcyo.uidemo.R;
import com.angcyo.uidemo.activity.MemoryTestActivity;
import com.angcyo.uiview.base.UIContentView;
import com.angcyo.uiview.container.ContentLayout;
import com.angcyo.uiview.kotlin.ViewExKt;
import com.angcyo.uiview.model.TitleBarPattern;
import com.wangjie.shadowviewhelper.ShadowProperty;
import com.wangjie.shadowviewhelper.ShadowViewDrawable;

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2016/11/18 14:54
 * 修改人员：Robi
 * 修改时间：2016/11/18 14:54
 * 修改备注：
 * Version: 1.0.0
 */
public class TestDemo extends UIContentView {

    @Override
    protected void inflateContentLayout(ContentLayout baseContentLayout, LayoutInflater inflater) {
        inflate(R.layout.test_layout);
    }

    @Override
    protected TitleBarPattern getTitleBar() {
        return null;
    }

    @Override
    protected void initOnShowContentLayout() {
        super.initOnShowContentLayout();
        click(R.id.restart_button1, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Debug.logTimeStart("_______________start_");
//                for (int i = 0; i < Integer.MAX_VALUE; i++) {
//
//                }
//                Debug.logTimeEnd("_______________end_");

                //startIView(new TestDemo());
                mActivity.startActivity(new Intent(mActivity, MemoryTestActivity.class));
            }
        });
        click(R.id.restart_button2, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIView(new TestDemo());
            }
        });

        click(R.id.close_button, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mParentILayout.finishIView(TestDemo.class, mViewHolder.cV(R.id.keep_last).isChecked());
            }
        });

        View bgView = v(R.id.bg_layout);
        ShadowProperty sp = new ShadowProperty()
                .setShadowColor(0x77000000)
                .setShadowDy((int) (1f * density()))
                .setShadowRadius((int) (6 * density()))
                .setShadowSide(ShadowProperty.ALL);
        ShadowViewDrawable sd = new ShadowViewDrawable(sp, Color.RED, 0, 0);
        ViewCompat.setLayerType(bgView, ViewCompat.LAYER_TYPE_SOFTWARE, null);
        ViewCompat.setBackground(bgView, sd);

        ViewExKt.showShadowViewDrawable(v(R.id.bg_layout2), 6);
    }
}
