package com.angcyo.uidemo.layout.demo;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.angcyo.uidemo.R;
import com.angcyo.uidemo.layout.base.BaseItemUIView;
import com.angcyo.uidemo.layout.demo.view.MaskImageView;
import com.angcyo.uidemo.layout.demo.view.MaskLayout;
import com.angcyo.uiview.base.Item;
import com.angcyo.uiview.base.SingleItem;
import com.angcyo.uiview.recycler.RBaseViewHolder;
import com.angcyo.uiview.resources.ResUtil;
import com.angcyo.uiview.skin.SkinHelper;
import com.angcyo.uiview.widget.RImageView;

import java.util.List;

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/04/12 09:08
 * 修改人员：Robi
 * 修改时间：2017/04/12 09:08
 * 修改备注：
 * Version: 1.0.0
 */
public class RippleDrawableDemoUIView extends BaseItemUIView {
    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_ripple_drawable_layout;
    }

    @Override
    protected void createItems(List<SingleItem> items) {
        items.add(new SingleItem() {
            @Override
            public void onBindView(final RBaseViewHolder holder, int posInData, Item dataBean) {
                int mdpi = getDimensionPixelOffset(R.dimen.base_mdpi);
                int roundRadius = getDimensionPixelOffset(R.dimen.base_round_radius);

                ResUtil.setBgDrawable(holder.v(R.id.edit_text), SkinHelper.getThemeRoundBorderSelector());

                ResUtil.setBgDrawable(holder.v(R.id.view1), ResUtil.generateRippleDrawable(Color.RED));
                ResUtil.setBgDrawable(holder.v(R.id.view2), ResUtil.generateRippleMaskDrawable(Color.RED));
                ResUtil.setBgDrawable(holder.v(R.id.view3), ResUtil.generateRippleMaskDrawable(Color.RED, Color.BLUE, Color.GRAY));
                ResUtil.setBgDrawable(holder.v(R.id.view4), ResUtil.generateRippleRoundMaskDrawable(10, Color.RED, Color.BLUE, Color.GRAY));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Drawable content = ResUtil.generateBgDrawable(Color.BLUE, Color.GRAY);
                    RippleDrawable drawable = new RippleDrawable(ColorStateList.valueOf(Color.RED), content, new ColorDrawable(Color.YELLOW));

                    ResUtil.setBgDrawable(holder.v(R.id.view5), drawable);
                }

                postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        final TransitionDrawable td = new TransitionDrawable(new Drawable[]{new ColorDrawable(0xfffcfcfc), getDrawable(R.drawable.image_demo)});
//                        final TransitionDrawable td = new TransitionDrawable(
//                                new Drawable[]{getDrawable(R.drawable.test_image), getDrawable(R.drawable.image_demo)});
//                        Holder.imgV(R.id.view6).setImageBitmap(td);
//                        td.startTransition(3000);

                        RImageView imageView = holder.v(R.id.view6);
//                        imageView.setImageDrawable(new ColorDrawable(0xfffcfcfc), getDrawable(R.drawable.image_demo));
                        imageView.setImageDrawable(getDrawable(R.drawable.test_image), getDrawable(R.drawable.image_demo));
                    }
                }, 500);


                ImageView imageView = holder.v(R.id.view8);
                Drawable drawable = ContextCompat.getDrawable(mActivity, R.drawable.icon_picture_green);
                InsetDrawable insetDrawable = new InsetDrawable(drawable, 0, 10, 0, 0);
                imageView.setImageDrawable(insetDrawable);

                Drawable drawable1 = getDrawable(R.drawable.test_drawable);
                ColorStateList colorStateList = getColorList(R.color.base_white_color_text_selector);

                //Drawable 测试 2017-06-10
                holder.v(R.id.button_1).setBackground(ResUtil.createStrokeDrawable(Color.RED, roundRadius, getDimensionPixelOffset(R.dimen.base_ldpi)));
                holder.v(R.id.button_2).setBackground(ResUtil.createSolidDrawable(Color.RED, 0));
                holder.v(R.id.button_3).setBackground(ResUtil.createStrokeDrawable(Color.RED, 0, getDimensionPixelOffset(R.dimen.base_ldpi)));
                holder.v(R.id.button_4).setBackground(ResUtil.createSolidDrawable(Color.RED, roundRadius));

                //Selector 测试 2017-06-10
                holder.v(R.id.button_1_1).setBackground(
                        ResUtil.selector(
                                ResUtil.createDrawable(Color.BLUE, Color.YELLOW, mdpi, roundRadius),
                                ResUtil.createDrawable(Color.RED, mdpi, roundRadius)));
                holder.v(R.id.button_2_1).setBackground(
                        ResUtil.selector(
                                ResUtil.createDrawable(Color.BLUE, Color.BLUE, 0, mdpi),
                                ResUtil.createDrawable(Color.RED, 0)));
                holder.v(R.id.button_3_1).setBackground(
                        ResUtil.selector(
                                ResUtil.createDrawable(Color.BLUE, Color.MAGENTA, 0, mdpi),
                                ResUtil.createDrawable(Color.RED, mdpi, getDimensionPixelOffset(R.dimen.base_ldpi))));
                holder.v(R.id.button_4_1).setBackground(
                        ResUtil.selector(
                                ResUtil.createDrawable(Color.BLUE, Color.YELLOW, mdpi, roundRadius),
                                ResUtil.createDrawable(Color.RED, roundRadius)));

                //ripple 测试 星期四 2017-8-3
                holder.v(R.id.button2_1).setBackground(
                        ResUtil.ripple(Color.WHITE,
                                ResUtil.selector(
                                        ResUtil.createDrawable(Color.BLUE, 100),
                                        ResUtil.createDrawable(Color.RED, 100)))
                );
                holder.v(R.id.button2_2).setBackground(
                        ResUtil.ripple(Color.RED,
                                ResUtil.selector(
                                        ResUtil.createDrawable(Color.BLUE, Color.WHITE, 2, 1000),
                                        ResUtil.createDrawable(Color.GREEN, Color.WHITE, 4, 1000)))
                );
                holder.v(R.id.button2_3).setBackground(
                        ResUtil.ripple(Color.YELLOW,
                                null)
                );
                holder.v(R.id.button2_4).setBackground(
                        ResUtil.ripple(Color.GREEN,
                                ResUtil.selector(
                                        ResUtil.createDrawable(Color.TRANSPARENT, 0),
                                        ResUtil.createDrawable(Color.RED, roundRadius * 2)))
                );

            }
        });

        items.add(new SingleItem() {
            @Override
            public void onBindView(@NonNull RBaseViewHolder holder, int posInData, Item itemDataBean) {
                final MaskImageView maskImageView1 = holder.v(R.id.mask_image_view1);
                MaskImageView maskImageView2 = holder.v(R.id.mask_image_view2);
                MaskImageView maskImageView3 = holder.v(R.id.mask_image_view3);

                maskImageView1.setMaskDrawable(getDrawable(R.drawable.round_shape));
                maskImageView2.setBackgroundResource(R.drawable.round_shape);
                maskImageView3.setImageResource(R.drawable.round_shape);

                holder.click(maskImageView1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        maskImageView1.setBackgroundColor(Color.TRANSPARENT);
                    }
                });

                MaskLayout maskLayout1 = holder.v(R.id.mask_layout_view1);
                maskLayout1.setMaskDrawable(getDrawable(R.drawable.round_shape));
            }

            @Override
            public int getItemLayoutId() {
                return R.layout.mask_layout_test;
            }
        });
    }
}
