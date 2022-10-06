package com.example.customdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imBtn: ImageButton = findViewById(R.id.im_btn)
        imBtn.setOnClickListener {
            view -> Snackbar.make(view, "You have clicked Image Button", Snackbar.LENGTH_SHORT)
            .show()
        }

        val btnAlert: Button = findViewById(R.id.btn_alert)
        btnAlert.setOnClickListener {
            alertDialogFunction()
        }

        val btnCustom: Button = findViewById(R.id.btn_custom)
        btnCustom.setOnClickListener {
            customDialogFunction()
        }

        val btnProgress: Button = findViewById(R.id.btn_progress)
        btnProgress.setOnClickListener {
            progressDialogFunction()
        }
    }

    private fun alertDialogFunction(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is Alert Dialog!")
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton("Yes"){
            dialogInterface, which -> Toast.makeText(applicationContext, "Clicked yes", Toast.LENGTH_SHORT)
            .show()
            dialogInterface.dismiss()
        }
        builder.setNeutralButton("Cancel"){
                dialogInterface, which -> Toast.makeText(applicationContext, "Clicked cancel\n" +
                "Operation cancelled", Toast.LENGTH_SHORT)
            .show()
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No"){
                dialogInterface, which -> Toast.makeText(applicationContext, "Clicked no", Toast.LENGTH_SHORT)
            .show()
            dialogInterface.dismiss()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false) //by using this, it takes care that by clicking outside the alert box, the dialog doesn't disappear
        alertDialog.show()
    }

    private fun customDialogFunction(){
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.custom_view)
        customDialog.findViewById<TextView>(R.id.text_submit).setOnClickListener {
            Toast.makeText(this, "Clicked on Submit", Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }
        customDialog.findViewById<TextView>(R.id.text_cancel).setOnClickListener {
            Toast.makeText(this, "Clicked on Cancel", Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }
        customDialog.show()
    }

    private fun progressDialogFunction(){
        val progressDialog = Dialog(this)
        progressDialog.setContentView(R.layout.progress_view)
        progressDialog.show()
    }
}