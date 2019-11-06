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
    val BLACK_COLOR:Int = 0
    var colorSelect:Int = 0
    val timer = Timer()

    lateinit var binding: ActivityBlinkBinding
    lateinit var background:View
    var color:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blink)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_blink)
        binding?.listener = this

        colorSelect = SharedPrefUtility.getColor(this.applicationContext)
        background = findViewById(R.id.layoutBlink)
        startTimer()
    }

    fun startTimer()
    {
        var period:Long = SharedPrefUtility.getInterval(this.applicationContext)
        //Set the schedule function
        timer.scheduleAtFixedRate(
            object : TimerTask() {

                override fun run() {
                    blink()
                }
            },
            0, period
        )   // 1000 Millisecond  = 1 second
    }

    /*
     * blink by color and interval from SharedPreference
     * !! Assumes user did not pick black !!
     */
    fun blink()
    {
        if (color == colorSelect)
            color = BLACK_COLOR
        else
            color = colorSelect

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
