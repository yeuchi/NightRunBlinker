package com.ctyeung.nightrunblinker


import android.content.Context
import android.graphics.Color
import android.widget.Button
import top.defaults.colorpicker.ColorPickerPopup

/*
 * Color Popup by duanhong
 *
 * https://github.com/duanhong169/ColorPicker/releases?utm_source=android-arsenal.com&utm_medium=referral&utm_campaign=7068
 */
object ColorPopup {
    /*
     * popup for dot color selection
     */
    fun launch(
        button: Button,
        context: Context,
        key: String
    ) {
        val choose = context.resources.getString(R.string.choose)
        val cancel = context.resources.getString(R.string.btn_cancel)

        ColorPickerPopup.Builder(context)
            .initialColor(Color.RED) // Set initial color
            .enableAlpha(true) // Enable alpha slider or not
            .okTitle(choose)
            .cancelTitle(cancel)
            .showIndicator(true)
            .showValue(true)
            .build()
            .show(button, object : ColorPickerPopup.ColorPickerObserver {
                override fun onColorPicked(color: Int) {
                    button.setBackgroundColor(color)
                    SharedPrefUtility.setColor(
                        context,
                        color
                    )    // store in sharedPreference
                }

                override fun onColor(color: Int, fromUser: Boolean) {

                }
            })
    }
}