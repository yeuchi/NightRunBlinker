package com.ctyeung.nightrunblinker

import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import com.ctyeung.nightrunblinker.databinding.ActivityMainBinding

/*
 * Night run blinker
 *
 * This is a simple blinking light for runner at night
 *
 * phone
 * 1. blink at configure fixed interval / color
 * 2. blink by accelerometer peak position
 * 3. blink from music ?
 *
 * watch
 * 1. blink at configured fixed interval / color
 * 2. blink by heart-rate
 *    a. if over: red light + vibrate
 *    c. in range: configured color
 *    b. if under: blue light + vibrate
 */
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var color:Int = 0
    lateinit var btnColor:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.listener = this

        setPrefBlinkInterval()
        setPrefBlinkColor()
    }

    fun setPrefBlinkInterval() {
        var numInterval:NumberPicker = findViewById(R.id.numInterval)
        numInterval.minValue = 200
        numInterval.maxValue = 10000
        numInterval.value = 1000
    }

    fun setPrefBlinkColor() {
        color = SharedPrefUtility.getColor(this.applicationContext)
        btnColor = findViewById(R.id.btnColor)
        btnColor?.setBackgroundColor(color)

        btnColor?.setOnClickListener(View.OnClickListener {
            ColorPopup.launch(
                btnColor,
                this.applicationContext,
                SharedPrefUtility.keyColor
            )
        })
    }

    /*
     * navigate to blinkActivity
     * -> Start blinking
     */
    fun onClickStart()
    {
        val intent = Intent(this.applicationContext, BlinkActivity::class.java)
        startActivity(intent)
    }
}
