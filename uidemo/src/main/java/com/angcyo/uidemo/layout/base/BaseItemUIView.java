package com.angcyo.uidemo.layout.base;

import com.angcyo.uiview.base.SingleItem;
import com.angcyo.uiview.base.UIItemUIView;
import com.angcyo.uiview.model.TitleBarPattern;

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/04/24 16:21
 * 修改人员：Robi
 * 修改时间：2017/04/24 16:21
 * 修改备注：
 * Version: 1.0.0
 */
public abstract class BaseItemUIView extends UIItemUIView<SingleItem> {

    @Override
    public TitleBarPattern createTitleBarPattern() {
        return super.createTitleBarPattern().setTitleStringLength(25);
    }

    @Override
    protected TitleBarPattern getTitleBar() {
        return super.getTitleBar().setTitleStringLength(30);
    }

    @Override
    public int getDefaultBackgroundColor() {
        return super.getDefaultBackgroundColor();
    }
}
