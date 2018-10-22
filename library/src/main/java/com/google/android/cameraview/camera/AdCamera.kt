package com.google.android.cameraview.camera

import android.content.Context
import android.hardware.Camera
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * Created by 李志云 10/20/18 21:18
 */
class AdCamera : FrameLayout {
    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    }

    fun openCamera(camera:Camera){
        camera.setDisplayOrientation(90)
        removeAllViews()
        addView(CameraPreview(context,camera))
    }

}

//inline fun ViewManager.adCamera() = adCamera {}
//
//inline fun ViewManager.adCamera(init: AdCamera.() -> Unit) = ankoView(::AdCamera, 0, init)