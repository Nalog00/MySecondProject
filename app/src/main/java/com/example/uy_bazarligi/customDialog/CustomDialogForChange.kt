package com.example.uy_bazarligi.customDialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.jerglikOnim.data.EmptyDatabase
import com.example.jerglikOnim.data.dao.EmptyDao
import com.example.jerglikOnim.data.model.Product
import com.example.uy_bazarligi.MainActivity
import com.example.uy_bazarligi.R
import kotlinx.android.synthetic.main.dialog_custom.*
import kotlinx.android.synthetic.main.dialog_custom.etAti
import kotlinx.android.synthetic.main.dialog_custom.etSI
import kotlinx.android.synthetic.main.dialog_custom.etSumma
import kotlinx.android.synthetic.main.update_dialog.*
import java.net.IDN

class CustomDialogForChange(private val activity: MainActivity,private val id: Int): Dialog(activity) {

    lateinit var dao: EmptyDao
    lateinit var product: Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_dialog)
        dao = EmptyDatabase.getInstance(activity).dao()
        dao.getProductById(0)

        btnPos.setOnClickListener {
            dismiss()
        }
        btnNeg.setOnClickListener {
            dismiss()
        }
    }
}