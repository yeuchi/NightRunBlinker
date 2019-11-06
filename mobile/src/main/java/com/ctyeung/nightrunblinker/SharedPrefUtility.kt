package com.ctyeung.nightrunblinker

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color

object SharedPrefUtility
{
    val mypreference = "mypref"
    val keyColor1 = "color1"
    val keyColor2 = "color2"
    var keyInterval = "time"
    val INTERVAL_MIN:Int = 200
    val INTERVAL_MAX:Int = 5000
    val INTERVAL_DEFAULT:Int = 1000

    open fun getInterval(context:Context):Long
    {
        val sharedPreferences = getSharedPref(context)
        return sharedPreferences.getLong(keyInterval, INTERVAL_DEFAULT.toLong())
    }

    open fun setInterval(context:Context, time:Long)
    {
        val sharedPreferences = getSharedPref(context)
        val editor = sharedPreferences.edit()
        editor.putLong(keyInterval, time)
        editor.commit()
    }

    open fun getColor(context:Context, colorName:String):Int
    {
        var defaultValue = Color.WHITE;
        if(colorName == keyColor2)
            defaultValue = Color.GREEN;

        val sharedPreferences = getSharedPref(context)
        return sharedPreferences.getInt(colorName, defaultValue)
    }

    open fun setColor(context:Context, colorName:String, color:Int)
    {
        val sharedPreferences = getSharedPref(context)
        val editor = sharedPreferences.edit()
        editor.putInt(colorName, color)
        editor.commit()
    }

    fun getSharedPref(context:Context):SharedPreferences
    {
        return context.getSharedPreferences(mypreference, Context.MODE_PRIVATE)
    }
}