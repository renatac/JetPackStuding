package com.example.favdash.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.favdash.R
import com.example.favdash.databinding.ActivityAddUpdateDishBinding

class AddUpdateDishActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityAddUpdateDishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAddUpdateDishBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_add_update_dish)
        setContentView(mBinding.root)
        setupActionBar()

        mBinding.ivAddDishImage.setOnClickListener(this)
    }

    private fun setupActionBar() {
        setSupportActionBar(mBinding.toolbarAddDishActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mBinding.toolbarAddDishActivity.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onClick(v: View?) {
        if(v != null) {
            when(v.id) {
                R.id.iv_add_dish_image -> {
                    Toast.makeText(this, "You have clicked the imageView", Toast.LENGTH_LONG).show()
                    return
                }
            }
        }
    }
}