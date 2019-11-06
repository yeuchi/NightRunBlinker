package com.ctyeung.nightrunblinker

import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
class MainActivity : AppCompatActivity(), IntervalPopUp.OnDialogOKListener {
    lateinit var binding: ActivityMainBinding
    lateinit var intervalListener:IntervalPopUp.OnDialogOKListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.listener = this
        intervalListener = this

        setPrefInterval()
        setPrefBlinkColor(R.id.btnColor1, SharedPrefUtility.keyColor1)
        setPrefBlinkColor(R.id.btnColor2, SharedPrefUtility.keyColor2)
    }

    fun setPrefInterval() {
        val milliseconds = SharedPrefUtility.getInterval(this.applicationContext)
        val btnInterval:Button = findViewById(R.id.btnInterval)
        btnInterval?.text = resources.getString(R.string.interval) + milliseconds
    }

    fun setPrefBlinkColor(id:Int, colorName:String) {
        val color:Int = SharedPrefUtility.getColor(this.applicationContext, colorName)
        val btnColor:Button = findViewById(id)
        btnColor?.setBackgroundColor(color)
    }

    // Callback handler
    override fun onNumberDialogOKClick(value:Int)
    {
        SharedPrefUtility.setInterval(this.applicationContext, value.toLong())
        setPrefInterval()
    }

    fun onClickInterval()
    {
        val numPicker = resources.getString(R.string.intervalpicker)
        val dlg = IntervalPopUp()
        val interval:Long = SharedPrefUtility.getInterval(this.applicationContext)
        dlg.setParams(intervalListener, interval)
        dlg.show(supportFragmentManager, numPicker)
    }

    // Button handler
    fun onClickColor1()
    {
        launchColorPopup(R.id.btnColor1, SharedPrefUtility.keyColor1)
    }

    // Button handler
    fun onClickColor2()
    {
        launchColorPopup(R.id.btnColor2, SharedPrefUtility.keyColor2)
    }

    fun launchColorPopup(id:Int, colorName:String)
    {
        val btnColor:Button = findViewById(id)
        ColorPopup.launch(
            btnColor,
            this.applicationContext,
            colorName
        )
    }

    // Button handler
    fun onClickStart()
    {
        // -> Start blinking
        val intent = Intent(this.applicationContext, BlinkActivity::class.java)
        startActivity(intent)
    }
}
