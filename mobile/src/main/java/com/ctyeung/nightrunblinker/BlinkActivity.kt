package com.ctyeung.nightrunblinker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_blink.*
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
//import sun.jvm.hotspot.utilities.IntArray
import java.util.*

import androidx.databinding.DataBindingUtil
import com.ctyeung.nightrunblinker.databinding.ActivityBlinkBinding


class BlinkActivity : AppCompatActivity() {
    var color1:Int = 0
    var color2:Int = 0
    val timer = Timer()

    lateinit var binding: ActivityBlinkBinding
    lateinit var background:View
    var color:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blink)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_blink)
        binding?.listener = this

        color1 = SharedPrefUtility.getColor(this.applicationContext, SharedPrefUtility.keyColor1)
        color2 = SharedPrefUtility.getColor(this.applicationContext, SharedPrefUtility.keyColor2)
        background = findViewById(R.id.layoutBlink)
        startTimer()
    }

    fun startTimer()
    {
        var milliseconds:Int = SharedPrefUtility.INTERVAL_MULTIPLY * SharedPrefUtility.getInterval(this.applicationContext)
        milliseconds /= 2

        //Set the schedule function
        timer.scheduleAtFixedRate(
            object : TimerTask() {

                override fun run() {
                    blink()
                }
            },
            0, milliseconds.toLong()
        )   // 1000 Millisecond  = 1 second
    }

    /*
     * blink by color and interval from SharedPreference
     * !! Assumes user did not pick black !!
     */
    fun blink()
    {
        if (color == color1)
            color = color2
        else
            color = color1

        background?.setBackgroundColor(color)
    }

    /*
     * Go back to Main
     * -> stop blinking
     */
    fun onClickStop()
    {
        timer?.cancel()
        val intent = Intent(this.applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}
