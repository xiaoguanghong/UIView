package com.angcyo.uidemo.layout;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.angcyo.library.utils.L;
import com.angcyo.uidemo.NavUIView;
import com.angcyo.uidemo.R;
import com.angcyo.uidemo.kotlin.cls.SingleClass2;
import com.angcyo.uidemo.layout.base.BaseItemUIView;
import com.angcyo.uidemo.layout.demo.AnimatorDemoUIView;
import com.angcyo.uidemo.layout.demo.AppInfoDemoUIView;
import com.angcyo.uidemo.layout.demo.BehaviorStickDemoUIView;
import com.angcyo.uidemo.layout.demo.BehaviorStickDemoUIView2;
import com.angcyo.uidemo.layout.demo.CenterRadioButtonUIView;
import com.angcyo.uidemo.layout.demo.ConstraintLayoutUIView;
import com.angcyo.uidemo.layout.demo.ContentStateUIView;
import com.angcyo.uidemo.layout.demo.CursorLoaderUIView;
import com.angcyo.uidemo.layout.demo.CustomViewUIView;
import com.angcyo.uidemo.layout.demo.CustomViewUIView2;
import com.angcyo.uidemo.layout.demo.DYRecordLayoutUIView;
import com.angcyo.uidemo.layout.demo.DiceCardUIView;
import com.angcyo.uidemo.layout.demo.EmojiUIView;
import com.angcyo.uidemo.layout.demo.ExEmojiUIView;
import com.angcyo.uidemo.layout.demo.ExpandRecordLayoutUIView;
import com.angcyo.uidemo.layout.demo.FileObserverUIView;
import com.angcyo.uidemo.layout.demo.FingerPrinterUIDemo;
import com.angcyo.uidemo.layout.demo.GalleryLayoutUIView;
import com.angcyo.uidemo.layout.demo.GameCircleLayoutUIView;
import com.angcyo.uidemo.layout.demo.GithubDemoUIView;
import com.angcyo.uidemo.layout.demo.GroupItemDecorationUIView;
import com.angcyo.uidemo.layout.demo.GuideLayoutUIView;
import com.angcyo.uidemo.layout.demo.InputTextUIDemo;
import com.angcyo.uidemo.layout.demo.LoopRecyclerViewUIView;
import com.angcyo.uidemo.layout.demo.MathPathUIView;
import com.angcyo.uidemo.layout.demo.MentionDemoUIView;
import com.angcyo.uidemo.layout.demo.Mp3PlayUIDemo;
import com.angcyo.uidemo.layout.demo.MyScanUIView;
import com.angcyo.uidemo.layout.demo.MyScanUIView2;
import com.angcyo.uidemo.layout.demo.NotifyDemoUIView;
import com.angcyo.uidemo.layout.demo.PasswordInputUIView;
import com.angcyo.uidemo.layout.demo.PopupWindowUIView;
import com.angcyo.uidemo.layout.demo.QQNavigationUIView;
import com.angcyo.uidemo.layout.demo.RGroupAdapterUIView;
import com.angcyo.uidemo.layout.demo.RRecyclerViewDemoUIView;
import com.angcyo.uidemo.layout.demo.RRecyclerViewDemoUIView2;
import com.angcyo.uidemo.layout.demo.RRecyclerViewDemoUIView3;
import com.angcyo.uidemo.layout.demo.RSwipeRecyclerUIView;
import com.angcyo.uidemo.layout.demo.RTLUIView;
import com.angcyo.uidemo.layout.demo.RVLayoutManagerUIView;
import com.angcyo.uidemo.layout.demo.RegularTestUIDemo;
import com.angcyo.uidemo.layout.demo.RippleDrawableDemoUIView;
import com.angcyo.uidemo.layout.demo.RippleViewUIDemo;
import com.angcyo.uidemo.layout.demo.SliderLayoutUIDemo;
import com.angcyo.uidemo.layout.demo.SpanUIView;
import com.angcyo.uidemo.layout.demo.StickLayoutDemo2UIView;
import com.angcyo.uidemo.layout.demo.StickLayoutDemoUIView;
import com.angcyo.uidemo.layout.demo.StickLayoutManagerUIView;
import com.angcyo.uidemo.layout.demo.StickTopLayoutUIDemo;
import com.angcyo.uidemo.layout.demo.SwipeRecyclerViewUIView;
import com.angcyo.uidemo.layout.demo.TouchBackUIDemo;
import com.angcyo.uidemo.layout.demo.TouchEventDemoUIView;
import com.angcyo.uidemo.layout.demo.TouchLayoutUIDemo;
import com.angcyo.uidemo.layout.demo.UIChatDemo;
import com.angcyo.uidemo.layout.demo.UIChatViewPagerDemo;
import com.angcyo.uidemo.layout.demo.WebsocketUIView;
import com.angcyo.uidemo.layout.demo.X5WebViewUIDemo;
import com.angcyo.uidemo.layout.qq.QQGuideAnimationUIDemo;
import com.angcyo.uidemo.refresh.RefreshLayoutDemo;
import com.angcyo.uidemo.uiview.ScrollerIView;
import com.angcyo.uidemo.uiview.TestDemo;
import com.angcyo.uiview.Root;
import com.angcyo.uiview.base.Item;
import com.angcyo.uiview.base.SingleItem;
import com.angcyo.uiview.base.UIIDialogImpl;
import com.angcyo.uiview.dialog.UIProgressDialog;
import com.angcyo.uiview.kotlin.ViewExKt;
import com.angcyo.uiview.model.TitleBarPattern;
import com.angcyo.uiview.net.Rx;
import com.angcyo.uiview.recycler.RBaseViewHolder;
import com.angcyo.uiview.utils.RUtils;
import com.angcyo.uiview.utils.T_;
import com.angcyo.uiview.utils.Tip;
import com.angcyo.uiview.view.IView;
import com.angcyo.uiview.view.IViewAnimationType;
import com.angcyo.uiview.view.OnUIViewListener;
import com.angcyo.uiview.widget.ItemInfoLayout;
import com.angcyo.uiview.widget.RTextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by angcyo on 2017-03-13.
 */
public class DemoListUIView2 extends BaseItemUIView {

    int progress = 0, clickCount = 0;
    private Subscription mSubscribe;
    private UIProgressDialog mProgressDialog;

    @Override
    protected TitleBarPattern getTitleBar() {
        return super.getTitleBar()
                .setShowBackImageView(false)
                .setShowTitleBarBottomShadow(true);
    }

//    @Override
//    public int getDefaultBackgroundColor() {
//        return Color.GREEN;
//    }


    @Override
    protected String getTitleString() {
        return String.valueOf(mActivity.getTitle());
    }

    @Override
    public boolean enableTouchBack() {
        return false;
    }

    @Override
    public void onViewShowFirst(Bundle bundle) {
        super.onViewShowFirst(bundle);
        //mRootView.setEnabled(false);
        //showLoadView();

        //魅族自动识别状态栏颜色的BUG
        lightStatusBar(false);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        if (isLast(viewType)) {
            return R.layout.item_version_layout;
        }
        return R.layout.item_demo_list_layout;
    }


    void initItem(RBaseViewHolder holder, String itemText, View.OnClickListener onClickListener) {
        initItem(holder, itemText, false, onClickListener);
    }

    void initItem(RBaseViewHolder holder, String itemText, boolean isDeprecated, View.OnClickListener onClickListener) {
        ItemInfoLayout infoLayout = holder.v(R.id.item_info_layout);
        infoLayout.setItemText(itemText);

        RTextView textView = infoLayout.getTextView();
        textView.setDeleteLine(isDeprecated);
        holder.click(infoLayout, onClickListener);
    }

    void onKotlinDemoClick() {
        lightStatusBar(false);
        if (Build.MODEL.contains("OPPO") || Build.MODEL.contains("ONEPLUS")) {
            T_.info("友情提示\n请关闭 '三指截屏'");
            Tip.tip("友情提示\n请关闭 '三指截屏'");
        }

        for (int a = 0; a < 10; a++) {
            L.e((a << 3) + " -> " + (a * 8));
        }

        String s1 = "我";
        String s2 = new String("我");
        L.e("in java-> " + ("我" == "我") + (s1 == s2) + (s1 == "我") + (s2 == "我"));

        onSynchronizedDemo(true, "");
    }

    void onSynchronizedDemo(boolean runThread, String tag) {
        L.e("call: onSynchronizedDemo([])-> synchronized start " + tag);

        if (runThread) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    onSynchronizedDemo(false, " thread");
                }
            }).start();
        }

        synchronized (this) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        L.e("call: onSynchronizedDemo([])-> synchronized end " + tag);
    }

    @Override
    protected void createItems(List<SingleItem> items) {
        items.add(new SingleItem(SingleItem.Type.TOP) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Scroller IView", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Refresh Layout Demo", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Test Demo", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".RTL Demo", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Emoji Layout Demo (Android5.+)", true, new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".ExEmoji Layout Demo", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Swipe RecyclerUIView Demo", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Link Url And LaunchMode Demo", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Center Button Demo + Video", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Animator Demo + Math", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Loop RecyclerUIView Demo", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".@ Mention Demo", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Stick Layout Demo (Beta)", true, new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Stick Layout Demo2", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Behavior Stick Demo", true, new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Behavior Stick Demo2 (Deprecated)", true, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new BehaviorStickDemoUIView2());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Stick LayoutManager Demo", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".GitHub Project Demo", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Game CircleLayout Demo (Beta)", new View.OnClickListener() {

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
                initItem(holder, posInData + 1 + ".Touch Event Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new TouchEventDemoUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Ripple Drawable Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new RippleDrawableDemoUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".RRecyclerView Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        int value = clickCount % 3;
                        if (value == 0) {
                            startIView(new RRecyclerViewDemoUIView3());
                        } else if (value == 1) {
                            startIView(new RRecyclerViewDemoUIView());
                        } else if (value == 2) {
                            startIView(new RRecyclerViewDemoUIView2());
                        }
                        clickCount++;
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Math Path And Paint Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new MathPathUIView());
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Span Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new SpanUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Custom View Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new CustomViewUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Custom View Demo2", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new CustomViewUIView2().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".RSwipeRecycler View Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new RSwipeRecyclerUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(final RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Kotlin 1.1 Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        onKotlinDemoClick();

                        KtDemo.INSTANCE.main();

                        shakeView();

                        //Tip.show("测试文本", R.drawable.hot_package_1);

                        //new ktclass().test();
                        //KtinterfaceKt.ktinterface_fun();
                        //KtfileKt.getN();
                        //KtinterfaceKt.fun_test(DemoListUIView2.this);

//                        new ktclass.ktsubclass();

//                        int num = SingleClass.Holder.getInstance().getNum();
//                        SingleClass.Holder.getInstance().setNum(2);
//                        num = SingleClass.Holder.getInstance().getNum();
//                        num = SingleClass.Holder.getInstance().getNum();
//
//                        SingleClass.Holder.getIns().getNum();

                        //int num = SingleClass.Companion.getInstance().getNum();
                        //SingleClass2.INSTANCE.getInstance()

//                        String num = SingleClass2.INSTANCE.getInstance().getNum();
//                        SingleClass2.INSTANCE.getInstance().setNum("1");
//                        num = SingleClass2.INSTANCE.getInstance().getNum();
//
//                        SingleClass2.INSTANCE.getInstance().setNum("122222");
//                        num = SingleClass2.INSTANCE.getInstance().getNum();

                        int num = SingleClass2.INSTANCE.getNum();
                        L.e("call: onClick([v])-> " + num);
                        SingleClass2.INSTANCE.setNum(2);
                        num = SingleClass2.INSTANCE.getNum();
                        L.e("call: onClick([v])-> " + num);

                        String test = "http://www.baidu.com/1.jpg?param=a?http://www.jd.com/ui.mp4";
                        try {
                            String substring = test.substring(test.lastIndexOf('?'), test.length());
                            String substring1 = test.substring(0, test.lastIndexOf('?'));

                            L.e("call: onClick([v])-> " + substring + " " + substring1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        long numTest = 12347980981235L;
                        L.e(numTest + " : 缩短后-> " + RUtils.getShortString(numTest));
                        numTest = 78983L;
                        L.e(numTest + " : 缩短后-> " + RUtils.getShortString(numTest));
                        numTest = 87654321L;
                        L.e(numTest + " : 缩短后-> " + RUtils.getShortString(numTest));
                        numTest = 4300L;
                        L.e(numTest + " : 缩短后-> " + RUtils.getShortString(numTest));

                        View view = new View(mActivity);
                        View v1 = ViewExKt.v(view, R.id.text_view);

                        L.e("call: onClick([v])-> " + v1);

//                        ResUtil.setGreyscale(getILayout(), true);
//                        postDelayed(2000, new Runnable() {
//                            @Override
//                            public void run() {
//                                ResUtil.setGreyscale(getILayout(), false);
//                            }
//                        });
//
//                        //xingqiuqp://null/null?GameID=null&RoomID=860101
//                        //String url = "xingqiuqp://null/null?GameID=null&RoomID=860101";
//                        //RUtils.openAppFromUrl(mActivity, url);
//
//                        AppUtils.installApp(RApplication.getApp(), new File("/sdcard/DValley/apk/2.2.3003.apk"));
//
//                        L.e("call: onClick([v])-> 1::" + RUtils.decimal(2f / 3f, 2, false));
//                        L.e("call: onClick([v])-> 2::" + RUtils.decimal(2f / 3f, 2, true));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Notify Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new NotifyDemoUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Finger Printer Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new FingerPrinterUIDemo().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".QQ  Navigation Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new QQNavigationUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Group ItemDecoration Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new GroupItemDecorationUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".ExpandRecordLayout Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new ExpandRecordLayoutUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".DYRecordView Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new DYRecordLayoutUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".CursorLoader Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new CursorLoaderUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".PopupWindow Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new PopupWindowUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".PasswordInput Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new PasswordInputUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".ProgressDialog Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        mProgressDialog = UIProgressDialog.build();
                        mProgressDialog.setDimBehind(false).addDismissListener(new UIIDialogImpl.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                progress = 0;
                                mSubscribe.unsubscribe();
                                mProgressDialog = null;
                            }
                        }).showDialog(mParentILayout);

                        mSubscribe = Rx.interval(300, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                                .subscribe(new Action1<Long>() {
                                    @Override
                                    public void call(Long aLong) {
                                        L.e("call: call([aLong])-> " + aLong);
                                        mProgressDialog.setProgress(progress);

                                        progress++;
                                        if (progress > 100) {
                                            mSubscribe.unsubscribe();
                                        } else if (progress > 80) {
                                            mProgressDialog.setTipText("");
                                        } else if (progress > 50) {
                                            mProgressDialog.setTipText("视频处理中");
                                        }
                                    }
                                });
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".ContentState Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new ContentStateUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Dice Card Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new DiceCardUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".ConstraintLayout Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new ConstraintLayoutUIView()
                                .setEnableClipMode(ClipMode.CLIP_BOTH, v)
                                .setOnUIViewListener(new OnUIViewListener() {
                                    @Override
                                    public void onViewUnload(IView uiview) {
                                        super.onViewUnload(uiview);
                                        L.e("call: onViewUnload([uiview])-> ConstraintLayoutUIView...");
                                    }
                                }));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".StickTopLayout Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new StickTopLayoutUIDemo()
                                .setEnableClipMode(ClipMode.CLIP_BOTH, v)
                                .setOnUIViewListener(new OnUIViewListener() {
                                    @Override
                                    public void onViewUnload(IView uiview) {
                                        super.onViewUnload(uiview);
                                        L.e("call: onViewUnload([uiview])-> ConstraintLayoutUIView...");
                                    }
                                }));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".SliderLayout Demo", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new SliderLayoutUIDemo().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".TouchStickLayout_d Demo", true, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new TouchLayoutUIDemo().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".TouchBackLayout Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new TouchBackUIDemo().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".RippleView Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new RippleViewUIDemo().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Mp3Play Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new Mp3PlayUIDemo().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".X5WebView Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new X5WebViewUIDemo().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".InputText Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new InputTextUIDemo().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Regular Test Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new RegularTestUIDemo().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".RGroupAdapter Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new RGroupAdapterUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".Guide Layout Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new GuideLayoutUIView(v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".WebSocket Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new WebsocketUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".FileObserver Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new FileObserverUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".GalleryLayout Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new GalleryLayoutUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".App Info Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new AppInfoDemoUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".RV LayoutManager Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new RVLayoutManagerUIView().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });

        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".ZxingZbar Scan Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new MyScanUIView2(new Action1<String>() {
                            @Override
                            public void call(String s) {
                                startIView(new ScanResultUIView(s));
                            }
                        })/*.setEnableClipMode(ClipMode.CLIP_BOTH, v)*/);
                    }
                });
            }
        });

        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".UIChat Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new UIChatDemo().setAnimationType(IViewAnimationType.ALPHA));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".UIChat With ViewPager Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new UIChatViewPagerDemo().setAnimationType(IViewAnimationType.TRANSLATE_VERTICAL));
                    }
                });
            }
        });
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                initItem(holder, posInData + 1 + ".QQ Guide Animation Demo", false, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startIView(new QQGuideAnimationUIDemo().setEnableClipMode(ClipMode.CLIP_BOTH, v));
                    }
                });
            }
        });

        //版本 编译时间
        items.add(new SingleItem(SingleItem.Type.LINE) {

            @Override
            public void setItemOffsets(Rect rect) {
                super.setItemOffsets(rect);
                rect.bottom = getDimensionPixelOffset(R.dimen.base_xhdpi);
            }

            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                holder.tv(R.id.text_view).setText(Root.device_info(mActivity));

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startIView(new MyScanUIView(new Action1<String>() {
                            @Override
                            public void call(String s) {
                                //T_.info("扫码结果:" + s);
                                startIView(new ScanResultUIView(s));
                            }
                        }));
                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Tip.tip("正在模拟Crash");
                        int i = 1 / 0;
                        return false;
                    }
                });
            }
        });

//        Rx.interval(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
//                .map(new Func1<Long, String>() {
//                    @Override
//                    public String call(Long s) {
//                        L.e("call: call([s])-> " + s);
//                        return "";
//                    }
//                })
//                .subscribe(new RSubscriber<String>() {
//                    @Overrides
//                    public void onSucceed(String bean) {
//                        super.onSucceed(bean);
//                    }
//                });
    }
}
