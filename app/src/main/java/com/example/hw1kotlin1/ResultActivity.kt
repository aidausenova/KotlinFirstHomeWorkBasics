package com.example.hw1kotlin1

import android.app.Activity
import android.app.Instrumentation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        getData()
        btnBack.setOnClickListener(View.OnClickListener {
            if (secondET.text.isNotEmpty()){
                intent.putExtra("data2", secondET.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }else{
                Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
            }

        })
    }
    fun getData(){
        var data = intent.getStringExtra("data")
        txtView.setText(data)
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}