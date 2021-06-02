package com.example.hw1kotlin1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val resultCall = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result?.resultCode == Activity.RESULT_OK && result.data != null) {
            val text = result.data!!.getStringExtra("data2")
            edtText.setText(text)

        }else{
            Toast.makeText(this,"Ошибка", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend.setOnClickListener(View.OnClickListener {
            if (edtText.text.isNotEmpty()) {
                val intent = Intent(this, ResultActivity::class.java)
                val text = edtText.text.toString()
                intent.putExtra("data", text)
                resultCall.launch(intent)
            } else {
                Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
            }


        })
    }
}