package com.example.uy_bazarligi.customDialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.example.jerglikOnim.data.model.Product
import com.example.uy_bazarligi.MainActivity
import com.example.uy_bazarligi.R
import kotlinx.android.synthetic.main.dialog_custom.*

class CustomDialog(context: Context, private val activity: MainActivity): Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)
        btnPositive.setOnClickListener {
             when {
                 etAti.text.toString() == "" -> {
                     Toast.makeText(context, "al toltirmasan bolmaydi", Toast.LENGTH_SHORT).show()
                 }
                 etSI.text.toString() == "" -> {
                     Toast.makeText(context, "al toltirmasan bolmaydi", Toast.LENGTH_SHORT).show()
                 }
                 etSumma.text.toString() == "" -> {
                     Toast.makeText(context, "al toltirmasan bolmaydi", Toast.LENGTH_SHORT).show()
                 }
                 else -> {
                     activity.addProduct(
                         Product(
                             nameQq = etAti.text.toString(),
                             olshemBirlik = etSI.text.toString(),
                             summa = etSumma.text.toString()
                         )
                     )
                     dismiss()
                 }
             }
            btnNegative.setOnClickListener {
                dismiss()
            }
        }
    }
}
