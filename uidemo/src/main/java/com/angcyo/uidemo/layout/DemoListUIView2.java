package com.angcyo.uidemo.layout;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.angcyo.uidemo.NavUIView;
import com.angcyo.uidemo.R;
import com.angcyo.uidemo.layout.demo.AnimatorDemoUIView;
import com.angcyo.uidemo.layout.demo.BehaviorStickDemoUIView;
import com.angcyo.uidemo.layout.demo.CenterRadioButtonUIView;
import com.angcyo.uidemo.layout.demo.EmojiUIView;
import com.angcyo.uidemo.layout.demo.ExEmojiUIView;
import com.angcyo.uidemo.layout.demo.GameCircleLayoutUIView;
import com.angcyo.uidemo.layout.demo.GithubDemoUIView;
import com.angcyo.uidemo.layout.demo.LoopRecyclerViewUIView;
import com.angcyo.uidemo.layout.demo.MentionDemoUIView;
import com.angcyo.uidemo.layout.demo.RTLUIView;
import com.angcyo.uidemo.layout.demo.RippleDrawableDemoUIView;
import com.angcyo.uidemo.layout.demo.StickLayoutDemo2UIView;
import com.angcyo.uidemo.layout.demo.StickLayoutDemoUIView;
import com.angcyo.uidemo.layout.demo.StickLayoutManagerUIView;
import com.angcyo.uidemo.layout.demo.SwipeRecyclerViewUIView;
import com.angcyo.uidemo.layout.demo.TouchEventDemoUIView;
import com.angcyo.uidemo.refresh.RefreshLayoutDemo;
import com.angcyo.uidemo.uiview.ScrollerIView;
import com.angcyo.uidemo.uiview.TestDemo;
import com.angcyo.uiview.base.Item;
import com.angcyo.uiview.base.SingleItem;
import com.angcyo.uiview.base.UIItemUIView;
import com.angcyo.uiview.model.TitleBarPattern;
import com.angcyo.uiview.recycler.RBaseViewHolder;
import com.angcyo.uiview.widget.ItemInfoLayout;

import java.util.List;

/**
 * Created by angcyo on 2017-03-13.
 */
public class DemoListUIView2 extends UIItemUIView<SingleItem> {

    @Override
    protected TitleBarPattern getTitleBar() {
        return super.getTitleBar().setShowBackImageView(false);
    }

    @Override
    public void onViewShowFirst(Bundle bundle) {
        super.onViewShowFirst(bundle);
        //mRootView.setEnabled(false);
        //showLoadView();
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_demo_list_layout;
    }

    @Override
    protected void createItems(List<SingleItem> items) {
        items.add(new SingleItem(SingleItem.Type.TOP) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "1.Scroller IView", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new ScrollerIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "2.Refresh Layout Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new RefreshLayoutDemo());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "3.Test Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new TestDemo());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "4.RTL Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new RTLUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "5.Emoji Layout Demo (Android5.+)", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new EmojiUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "6.ExEmoji Layout Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new ExEmojiUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "7.Swipe RecyclerUIView Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new SwipeRecyclerViewUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "8.Link Url Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new NavUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "9.Center Button Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new CenterRadioButtonUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "10.Animator Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new AnimatorDemoUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "11.Loop RecyclerUIView Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new LoopRecyclerViewUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "12.@ Mention Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new MentionDemoUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "13.Stick Layout Demo (Beta)", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new StickLayoutDemoUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "14.Stick Layout Demo2 (Beta)", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new StickLayoutDemo2UIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "15.Behavior Stick Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new BehaviorStickDemoUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "16.Stick LayoutManager Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new StickLayoutManagerUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "17.GitHub Project Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new GithubDemoUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "18.Game CircleLayout Demo (Beta)", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new GameCircleLayoutUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "19.Touch Event Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new TouchEventDemoUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void setItemOffsets(Rect rect) {
                super.setItemOffsets(rect);
                rect.bottom = getDimensionPixelOffset(R.dimen.base_xhdpi);
            }

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, "20.Ripple Drawable Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new RippleDrawableDemoUIView());
                    }
                });
            }
        });
    }

    void initItem(RBaseViewHolder holder, String itemText, View.OnClickListener onClickListener) {
        ItemInfoLayout infoLayout = holder.v(R.id.item_info_layout);
        infoLayout.setItemText(itemText);
        infoLayout.setOnClickListener(onClickListener);
    }

}
