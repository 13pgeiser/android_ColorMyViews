package com.pgeiser.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.pgeiser.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val allViews : List<View> = listOf(binding.boxOneText, binding.boxTwoText,
            binding.boxThreeText, binding.boxFourText, binding.boxFiveText,
            binding.redButton, binding.yellowButton, binding.greenButton,
            binding.constraintLayout)
        for (item in allViews) {
            item.setOnClickListener {  makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.red_button -> binding.boxThreeText.setBackgroundColor(ContextCompat.getColor(this, (R.color.my_red)))
            R.id.yellow_button -> binding.boxFourText.setBackgroundColor(ContextCompat.getColor(this, (R.color.my_yellow)))
            R.id.green_button -> binding.boxFiveText.setBackgroundColor(ContextCompat.getColor(this, (R.color.my_green)))

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}