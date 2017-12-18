package com.angcyo.uidemo.layout.demo.game

import android.graphics.Canvas
import android.graphics.Point
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import com.angcyo.uidemo.R
import com.angcyo.uiview.game.GameRenderView
import com.angcyo.uiview.game.layer.*
import com.angcyo.uiview.game.spirit.FrameBean
import com.angcyo.uiview.game.spirit.FrameBgBean
import com.angcyo.uiview.game.spirit.MoveBean
import com.angcyo.uiview.game.spirit.ScaleRandomPointBean
import com.angcyo.uiview.utils.ScreenUtil
import com.angcyo.uiview.utils.ScreenUtil.density
import java.util.*

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/12/18 08:58
 * 修改人员：Robi
 * 修改时间：2017/12/18 08:58
 * 修改备注：
 * Version: 1.0.0
 */
class RainRenderHelper(private val gameView: GameRenderView) {

    private val packetLayer = PacketLayer()
    private val effectLayer = BaseFrameLayer()
    private val scoreLayer = BaseFrameLayer()

    /**会按顺序绘制*/
    fun addLayer(layer: BaseLayer) {
        gameView.layerList.add(layer)
    }

    fun getDrawable(id: Int): Drawable = ContextCompat.getDrawable(gameView.context, id)

    var useBezier = true
    var randomStep = true

    private val random: Random by lazy {
        Random(System.nanoTime())
    }

    fun initGame() {
        resetPacketLayer()

        val baseFrameLayer = BaseFrameLayer()
//                val baseMoveLayer = BaseMoveLayer()
//                val frameArray = arrayOf(getDrawable(R.drawable.home_48_color),
//                        getDrawable(R.drawable.me_48_color),
//                        getDrawable(R.drawable.live_48_color),
//                        getDrawable(R.drawable.message_48_color),
//                        getDrawable(R.drawable.shop_48_color))
//
//                gameRenderHelper.addLayer(RainBgLayer(getDrawable(R.drawable.hongbaoyu_bg)))
//                gameRenderHelper.addLayer(RainLayer(R.drawable.hot_package).apply {
//                    randomStep = mViewHolder.cV(R.id.step_box).isChecked
//                    useBezier = mViewHolder.cV(R.id.bezier_box).isChecked
//                    onClickRainListener = object : OnClickRainListener {
//                        override fun onClickRain(rainLayout: RainLayer, bean: RainBean) {
//                            rainLayout.removeRain(bean)
//
//                            baseFrameLayer.addFrameBean(FrameBean(frameArray, Point(bean.getRect().centerX(), bean.getRect().centerY())).apply {
//                                loopDrawFrame = random.nextBoolean()
//                            })
//
//                            baseMoveLayer.addFrameBean(MoveBean(
//                                    frameArray,
//                                    Point(bean.getRect().centerX(), bean.getRect().centerY()),
//                                    Point(ScreenUtil.screenWidth, 0)
//                            ).apply {
//                                frameDrawIntervalTime = (16 + random.nextInt(10) * 10).toLong()
//                                maxMoveTime = (1 + random.nextInt(4)) * 1000
//                            })
//                        }
//
//                    }
//                })
//                gameRenderHelper.addLayer(baseMoveLayer)

        addBgLayer(baseFrameLayer)
        addLineLayer(baseFrameLayer)
        addMarkLayer(baseFrameLayer)
        addXingLayer(baseFrameLayer)

        addLayer(baseFrameLayer)
        addLayer(packetLayer)//红包
        addLayer(GoldCoinLayer())//金币
        addLayer(effectLayer)//红包炸开效果
        addLayer(scoreLayer)//分数漂移
    }

    fun resetPacketLayer() {
        packetLayer.apply {
            reset()
            randomStep = this@RainRenderHelper.randomStep
            useBezier = this@RainRenderHelper.useBezier

            onClickSpiritListener = object : OnClickSpiritListener {
                override fun onClickSpirit(baseTouchLayer: BaseTouchLayer, spiritBean: TouchSpiritBean, x: Int, y: Int) {
                    effectLayer.addFrameBean(FrameBean(arrayOf(
                            getDrawable(R.drawable.hongbao_g_00000),
                            getDrawable(R.drawable.hongbao_g_00001),
                            getDrawable(R.drawable.hongbao_g_00002),
                            getDrawable(R.drawable.hongbao_g_00003),
                            getDrawable(R.drawable.hongbao_g_00004),
                            getDrawable(R.drawable.hongbao_g_00005),
                            getDrawable(R.drawable.hongbao_g_00006),
                            getDrawable(R.drawable.hongbao_g_00007),
                            getDrawable(R.drawable.hongbao_g_00008),
                            getDrawable(R.drawable.hongbao_g_00009),
                            getDrawable(R.drawable.score_1)
                    ), Point(spiritBean.getRect().centerX(), spiritBean.getRect().centerY())).apply {
                        frameDrawIntervalTime = 60L
                        loopDrawFrame = false
                        onDrawEndFun = { drawPoint ->
                            scoreLayer.addFrameBean(
                                    MoveBean(arrayOf(getDrawable(R.drawable.score_1)),
                                            drawPoint,
                                            Point(gameView.measuredWidth, 0)))
                        }
                    })
                }
            }
        }
    }


    /**背景*/
    private fun addBgLayer(hotRainLayer: BaseFrameLayer) {
        hotRainLayer.addFrameBean(FrameBgBean(getDrawable(R.drawable.rain_game_bg)))
    }

    /**流星*/
    private fun addLineLayer(hotRainLayer: BaseFrameLayer) {
        val dp20: Int = (20 * density()).toInt()
        val dp10: Int = (10 * density()).toInt()
        val sw = ScreenUtil.screenWidth
        val sh = ScreenUtil.screenHeight

        /*流星的角度*/
        val degrees = 40f

        /*根据开始点和角度, 求出结束点*/
        fun endPoint(startPoint: Point, degrees: Float): Point {
            val endPoint = Point().apply {
                set(((ScreenUtil.screenHeight - startPoint.y - 300) * Math.tan(Math.toRadians(degrees.toDouble()))).toInt(), ScreenUtil.screenHeight - 300)
            }
            return endPoint
        }

        fun delayDrawTime(f: Int = 6) = (random.nextInt(f) * 1000).toLong()
        fun maxMoveTime(f: Int = 3) = (5 + random.nextInt(f)) * 1000

        fun createMBean(id: Int, startPoint: Point, degrees: Float): MoveBean {
            val drawable = getDrawable(id)
            return MoveBean(
                    arrayOf(drawable),
                    startPoint,
                    endPoint(startPoint, degrees)).apply {
                delayDrawTime = delayDrawTime()
                maxMoveTime = maxMoveTime()
                rotateDegrees = -degrees
                isLoopMove = true
                constantSpeed = random.nextBoolean()
            }
        }

        val mb1 = createMBean(R.drawable.liuxing01, Point(0, sh * 1 / 3), degrees)
        val mb2s = Point(0, dp20 * 6)
        val mb2 = object : MoveBean(
                arrayOf(getDrawable(R.drawable.liuxing02)),
                mb2s,
                endPoint(mb2s, degrees)) {
            init {
                maxMoveTime = maxMoveTime(7)
                rotateDegrees = -degrees
                constantSpeed = false
                isLoopMove = true
                scaleX = 0.6f
                scaleY = 0.6f
            }
        }
        val mb3 = createMBean(R.drawable.liuxing01, Point(0, sh * 1 / 7), degrees)
//                object : MoveBean(
//                arrayOf(getDrawable(R.drawable.liuxing01)),
//                Point(dp20, dp20),
//                Point(sw, sh - dp20)) {
//            init {
//                maxMoveTime = 5000
//                rotateDegrees = -30f
//                isLoopMove = true
//            }
//        }

        val mb4s = Point(0, dp20 * 8)
        val mb4 = object : MoveBean(
                arrayOf(getDrawable(R.drawable.liuxing02)),
                mb4s,
                endPoint(mb4s, degrees)) {
            init {
                maxMoveTime = maxMoveTime(8)
                rotateDegrees = -degrees
                constantSpeed = false
                isLoopMove = true
                scaleX = 0.4f
                scaleY = 0.4f
            }
        }

        val mb5 = createMBean(R.drawable.liuxing01, Point(sw / 3, 0), degrees)
//                object : MoveBean(
//                arrayOf(getDrawable(R.drawable.liuxing01)),
//                Point(0, dp20 * 3),
//                Point(sw - dp20 * 3, sh)) {
//            init {
//                maxMoveTime = 5000
//                rotateDegrees = -30f
//                isLoopMove = true
//            }
//        }

        val mb6s = Point(-dp20 * 4, dp20 * 10)
        val mb6 = object : MoveBean(
                arrayOf(getDrawable(R.drawable.liuxing02)),
                mb6s,
                endPoint(mb6s, degrees)) {
            init {
                maxMoveTime = maxMoveTime(9)
                rotateDegrees = -degrees
                constantSpeed = random.nextBoolean()
                isLoopMove = true
            }
        }

        val mb7s = Point(sw / 2, 0)
        val mb7 = object : MoveBean(
                arrayOf(getDrawable(R.drawable.liuxing02)),
                mb7s,
                endPoint(mb7s, degrees)) {
            init {
                delayDrawTime = delayDrawTime()
                maxMoveTime = maxMoveTime(7)
                rotateDegrees = -degrees
                constantSpeed = false
                isLoopMove = true
            }
        }

        val mb8s = Point(sw / 3, 0)
        val mb8 = object : MoveBean(
                arrayOf(getDrawable(R.drawable.liuxing02)),
                mb8s,
                endPoint(mb8s, degrees)) {
            init {
                delayDrawTime = delayDrawTime()
                maxMoveTime = maxMoveTime(7)
                rotateDegrees = -degrees
                constantSpeed = random.nextBoolean()
                isLoopMove = true
                scaleX = 0.6f
                scaleY = 0.6f
            }
        }

        hotRainLayer.addFrameBean(mb1)
        hotRainLayer.addFrameBean(mb2)
        hotRainLayer.addFrameBean(mb3)
        hotRainLayer.addFrameBean(mb4)
        hotRainLayer.addFrameBean(mb5)
        hotRainLayer.addFrameBean(mb6)
        hotRainLayer.addFrameBean(mb7)
        hotRainLayer.addFrameBean(mb8)

    }

    /**山*/
    private fun addMarkLayer(hotRainLayer: BaseFrameLayer) {
        hotRainLayer.addFrameBean(object : FrameBgBean(getDrawable(R.drawable.shan_bg)) {
            override fun draw(canvas: Canvas, gameStartTime: Long, lastRenderTime: Long, nowRenderTime: Long, onDrawEnd: (() -> Unit)?) {
                bgDrawable.let {
                    it.bounds.set(parentRect.left, parentRect.bottom - bgDrawable.intrinsicHeight, parentRect.right, parentRect.bottom)
                    it.draw(canvas)
                }
            }
        })
    }

    /**星星*/
    private fun addXingLayer(hotRainLayer: BaseFrameLayer) {
        val scale1 = arrayOf(0.2f, 0.4f, 0.6f, 0.8f, 1f, 1.2f, 1f, 0.8f, 0.6f, 0.4f, 0.2f, 0f)
        val scale2 = arrayOf(0.2f, 0.4f, 0.6f, 0.8f, 0.8f, 0.6f, 0.4f, 0.2f, 0f)
        val scale3 = arrayOf(0.2f, 0.4f, 0.6f, 0.8f, 1f, 1.2f, 1f, 1f, 1.2f, 1f, 0.8f, 0.6f, 0.4f, 0.2f, 0f)
        val scale4 = arrayOf(0.2f, 0.4f, 0.6f, 0.8f, 1f, 1.2f, 1.4f, 1.4f, 1.2f, 1f, 0.8f, 0.6f, 0.4f, 0.2f, 0f)
        val scale5 = arrayOf(0.2f, 0.6f, 1.2f, 1.8f, 2.5f, 3f, 2.5f, 1.8f, 1.2f, 0.6f, 0.2f)
        val scale6 = arrayOf(0.2f, 0.6f, 1.2f, 1.6f, 2f, 2.5f, 2f, 1.6f, 1.2f, 0.6f, 0.2f)

        hotRainLayer.addFrameBean(ScaleRandomPointBean(scale1, getDrawable(R.drawable.xing01)))
        hotRainLayer.addFrameBean(ScaleRandomPointBean(scale2, getDrawable(R.drawable.xing02)))

        hotRainLayer.addFrameBean(ScaleRandomPointBean(scale3, getDrawable(R.drawable.xing01)))
        hotRainLayer.addFrameBean(ScaleRandomPointBean(scale1, getDrawable(R.drawable.xing02)))

        hotRainLayer.addFrameBean(ScaleRandomPointBean(scale4, getDrawable(R.drawable.xing01)))
        hotRainLayer.addFrameBean(ScaleRandomPointBean(scale3, getDrawable(R.drawable.xing02)))

        hotRainLayer.addFrameBean(ScaleRandomPointBean(scale4, getDrawable(R.drawable.xing01)))
        hotRainLayer.addFrameBean(ScaleRandomPointBean(scale2, getDrawable(R.drawable.xing02)))

        hotRainLayer.addFrameBean(ScaleRandomPointBean(scale5, getDrawable(R.drawable.xing01)))
        hotRainLayer.addFrameBean(ScaleRandomPointBean(scale5, getDrawable(R.drawable.xing01)))

        hotRainLayer.addFrameBean(ScaleRandomPointBean(scale6, getDrawable(R.drawable.xing02)))
        hotRainLayer.addFrameBean(ScaleRandomPointBean(scale6, getDrawable(R.drawable.xing02)))
    }
}