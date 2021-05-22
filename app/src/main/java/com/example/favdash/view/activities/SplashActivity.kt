package com.example.favdash.view.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.favdash.R
import com.example.favdash.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Isso:
        //setContentView(R.layout.activity_splash)
        //Se torna isso:
        val splashBinding: ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

       // splashBinding.tvAppName.text = "Hello world"

        //For the screen to fill all screen above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
            )
        }

        val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_splash)
        //For active my animation (I created at R.anim.anim_splash)
        splashBinding.tvAppName.animation = splashAnimation

        //Animation listener for animation
        splashAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
              //
            }

            override fun onAnimationEnd(animation: Animation?) {
                //Realize this after 1 second after the of animation
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }, 1000)
            }

            override fun onAnimationRepeat(animation: Animation?) {
                TODO("Not yet implemented")
            }

        })
    }
}