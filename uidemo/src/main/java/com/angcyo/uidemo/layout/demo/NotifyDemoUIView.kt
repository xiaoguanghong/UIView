package com.angcyo.uidemo.layout.demo

import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.view.Gravity
import com.angcyo.uidemo.R
import com.angcyo.uidemo.layout.LayoutDemoActivity
import com.angcyo.uidemo.layout.base.BaseItemUIView
import com.angcyo.uiview.base.Item
import com.angcyo.uiview.base.SingleItem
import com.angcyo.uiview.dialog.UILoading
import com.angcyo.uiview.kotlin.random
import com.angcyo.uiview.recycler.RBaseViewHolder
import com.angcyo.uiview.utils.*

/**
 * Created by angcyo on 2017-05-28.
 */

class NotifyDemoUIView : BaseItemUIView() {

    private var mIndex: Int = 0
    private var mProgressRunnable: Runnable? = null

    private val pendingIntent: PendingIntent
        get() {
            val intent = Intent(mActivity, LayoutDemoActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            return PendingIntent.getActivity(mActivity, 10000, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        }

    override fun createItems(items: MutableList<SingleItem>) {
        items.add(object : SingleItem() {
            override fun onBindView(holder: RBaseViewHolder, posInData: Int, dataBean: Item) {
                holder.click(R.id.notify_normal_singline) {
                    NotifyUtil(mActivity, 10002).notify_normal_singline(pendingIntent, R.mipmap.demo_logo,
                            "ticker", "title", "notify_normal_singline", true, true, true)
                }
                holder.click(R.id.notify_bigPic) {
                    NotifyUtil(mActivity, 10001).notify_bigPic(pendingIntent, R.mipmap.demo_logo,
                            "ticker", "title", "notify_bigPic", R.mipmap.demo_logo, true, true, true)
                }
                holder.click(R.id.show_notify) { showNotify() }
                holder.click(R.id.show_progress_notify) {
                    mIndex = 0
                    mProgressRunnable = Runnable {
                        ProgressNotify.instance()
                                .setClickActivity(LayoutDemoActivity::class.java)
                                .show("title", R.mipmap.demo_logo, mIndex)
                        mIndex++

                        if (mIndex >= 100) {
                            ProgressNotify.instance()
                                    .setClickActivity(LayoutDemoActivity::class.java)
                                    .show("下载完成", R.mipmap.demo_logo, mIndex)
                        } else {
                            postDelayed(mProgressRunnable, 100)
                        }
                    }
                    post(mProgressRunnable)
                }

                holder.click(R.id.t1_view) { T.show(mActivity, "T Toast Test") }
                holder.click(R.id.t2_view) {
                    T_.info("T_ Toast Test")
                    postDelayed(1000) {
                        T_.error("T_ Toast TestT_ Toast TestT_ Toast TestT_ Toast Test" +
                                "T_ Toast TestT_ Toast TestT_ Toast TestT_ Toast Test" +
                                "T_ Toast TestT_ Toast TestT_ Toast TestT_ Toast Test" +
                                "T_ Toast TestT_ Toast TestT_ Toast TestT_ Toast Test" +
                                "T_ Toast TestT_ Toast TestT_ Toast TestT_ Toast TestT_ Toast Test" +
                                "T_ Toast TestT_ Toast TestT_ Toast TestT_ Toast TestT_ Toast Test", Gravity.LEFT)
                    }
                }
                holder.click(R.id.tip_view) {
                    T_.ok("T_ Toast Test", Gravity.LEFT)
                    Tip.tip("Tip Toast")
                }

                holder.click(R.id.uiload_view) {
                    UILoading.show2(mParentILayout).isDimBehind = random.nextBoolean()
                }

                holder.click(R.id.uiload_view2) {
                    UILoading.progress(mParentILayout).isDimBehind = random.nextBoolean()
                }

                holder.click(R.id.flow_view) {
                    UILoading.flow(mParentILayout).isDimBehind = random.nextBoolean()
                }
            }

            override fun getItemLayoutId(): Int {
                return R.layout.item_notify
            }
        })

    }

    private fun showNotify() {
        val managerCompat = NotificationManagerCompat.from(mActivity)
        val builder = NotificationCompat.Builder(mActivity)

        builder.setContentText("showNotify")
        builder.setContentTitle("title")
        builder.setSmallIcon(R.mipmap.demo_logo)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.demo_logo))//显示在通知内容右边的图片
        builder.setWhen(System.currentTimeMillis())
        builder.setAutoCancel(true)
        builder.priority = NotificationCompat.PRIORITY_MAX

        builder.setContentIntent(pendingIntent)

        builder.setDefaults(NotificationCompat.DEFAULT_SOUND)//如果不设置提示, 横幅通知就不会出现. (横幅需要系统允许)

        //        builder.setTicker("TickerText");

        //        RemoteViews mRemoteViews = new RemoteViews(mActivity.getPackageName(), R.layout.base_progress_notify_layout);
        //        builder.setTicker("TickerText", mRemoteViews);

        managerCompat.notify(System.currentTimeMillis().toInt(), builder.build())
    }
}
