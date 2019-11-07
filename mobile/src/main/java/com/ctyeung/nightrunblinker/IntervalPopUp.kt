package com.ctyeung.nightrunblinker

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.NumberPicker
import androidx.annotation.Nullable
import androidx.fragment.app.DialogFragment

class IntervalPopUp : DialogFragment()
{
    private var valueChangeListener: NumberPicker.OnValueChangeListener? = null
    private var mListener: OnDialogOKListener? = null
    private var numberPicker: NumberPicker? = null

    /*
         * parent call back listener
         */
    interface OnDialogOKListener {
        fun onNumberDialogOKClick(value: Int)
    }

    private fun setNumberValues(value:Int) {
        if (null != numberPicker) {
            numberPicker!!.minValue = SharedPrefUtility.INTERVAL_MIN
            numberPicker!!.maxValue = SharedPrefUtility.INTERVAL_MAX
            numberPicker!!.value = value
        }
    }

    override fun onCreateDialog(@Nullable savedInstanceState: Bundle?): Dialog {
        val activity = getActivity()
        val context = activity?.baseContext

        val ok = context?.getResources()?.getString(R.string.ok)
        val cancel = context?.getResources()?.getString(R.string.btn_cancel)
        val chooseValue = context?.getResources()?.getString(R.string.choose_interval)
        val chooseUnit = context?.getResources()?.getString(R.string.choose_unit)

        numberPicker = NumberPicker(activity)
        setNumberValues(SharedPrefUtility.INTERVAL_DEFAULT)

        val builder = AlertDialog.Builder(activity)
        builder.setTitle(chooseValue)
        builder.setMessage(chooseUnit)

        builder.setPositiveButton(ok, DialogInterface.OnClickListener { dialog, which ->
            val value = numberPicker!!.value
            mListener!!.onNumberDialogOKClick(value)
        })


        builder.setNegativeButton(cancel, DialogInterface.OnClickListener { dialog, which ->
            valueChangeListener!!.onValueChange(
                numberPicker,
                numberPicker!!.value, numberPicker!!.value
            )
        })

        builder.setView(numberPicker)
        return builder.create()
    }

    fun setParams(
        listener: OnDialogOKListener,
        value: Int
    ) {
        this.mListener = listener
        setNumberValues(value)
    }

    fun getValueChangeListener(): NumberPicker.OnValueChangeListener? {
        mListener!!.onNumberDialogOKClick(numberPicker!!.value)
        return valueChangeListener
    }

    fun setValueChangeListener(valueChangeListener: NumberPicker.OnValueChangeListener) {
        this.valueChangeListener = valueChangeListener
    }
}