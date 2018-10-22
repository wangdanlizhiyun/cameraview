package lzy.com.camerademo

import android.Manifest
import android.app.Activity
import android.hardware.Camera
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.cameraview.demo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var that: Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        that = this



    }

    override fun onResume() {
        super.onResume()
        EasyPermissions.create(Manifest.permission.CAMERA).callback {
            if (it) {
                camera1.start()

//                val camera = getCameraInstance()
//                camera?.apply {
//                    camera2.openCamera(this)
//                }
            }
        }.request(that)
    }

    override fun onPause() {
        super.onPause()
        camera1.stop()
    }
    fun getCameraInstance(): Camera? {
        return try {
            Camera.open() // attempt to get a Camera instance
        } catch (e: Exception) {
            // Camera is not available (in use or does not exist)
            null // returns null if camera is unavailable
        }
    }
}
