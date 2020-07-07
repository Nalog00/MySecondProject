package com.example.uy_bazarligi.customDialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.jerglikOnim.data.model.Product
import com.example.uy_bazarligi.MainActivity
import com.example.uy_bazarligi.R
import kotlinx.android.synthetic.main.dialog_custom.*
import kotlinx.android.synthetic.main.dialog_custom.etAti
import kotlinx.android.synthetic.main.dialog_custom.etSI
import kotlinx.android.synthetic.main.dialog_custom.etSumma
import kotlinx.android.synthetic.main.update_dialog.*

class CustomDialogForChange(context: Context, private val activity: MainActivity): Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_dialog)
        btnPos.setOnClickListener {
            activity.updateProduct(Product(etAti.text.toString(), etSI.text.toString(), etSumma.text.toString()))
            activity.changeProduct(id=0)
            dismiss()
        }
        btnNeg.setOnClickListener {
            dismiss()
        }
    }
}