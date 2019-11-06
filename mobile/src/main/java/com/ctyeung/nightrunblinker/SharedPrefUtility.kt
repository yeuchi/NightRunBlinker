package com.ctyeung.nightrunblinker

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color

object SharedPrefUtility
{
    val mypreference = "mypref"
    val keyColor = "color"
    var keyInterval = "time"

    open fun getInterval(context:Context):Long
    {
        val defaultValue:Long = 1000;
        val sharedPreferences = getSharedPref(context)
        return sharedPreferences.getLong(keyInterval, defaultValue)
    }

    open fun setInterval(context:Context, time:Long)
    {
        val sharedPreferences = getSharedPref(context)
        val editor = sharedPreferences.edit()
        editor.putLong(keyInterval, time)
        editor.commit()
    }

    open fun getColor(context:Context):Int
    {
        val defaultValue = Color.WHITE;
        val sharedPreferences = getSharedPref(context)
        return sharedPreferences.getInt(keyColor, defaultValue)
    }

    open fun setColor(context:Context, color:Int)
    {
        val sharedPreferences = getSharedPref(context)
        val editor = sharedPreferences.edit()
        editor.putInt(keyColor, color)
        editor.commit()
    }

    fun getSharedPref(context:Context):SharedPreferences
    {
        return context.getSharedPreferences(mypreference, Context.MODE_PRIVATE)
    }
}