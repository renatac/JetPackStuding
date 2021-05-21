package com.example.favdash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}