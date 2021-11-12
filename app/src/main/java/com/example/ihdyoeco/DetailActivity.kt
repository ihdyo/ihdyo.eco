package com.example.ihdyoeco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();

        setContentView(R.layout.activity_detail)

        val NAME = intent.getStringExtra("EXTRA_NAME")
        val name = findViewById<TextView>(R.id.name)
        name.text = NAME

        val ADDRESS = intent.getStringExtra("EXTRA_ADDRESS")
        val address = findViewById<TextView>(R.id.address)
        address.text = ADDRESS

        val VARIETY = intent.getStringExtra("EXTRA_VARIETY")
        val variety = findViewById<TextView>(R.id.variety)
        variety.text = VARIETY

        val QUANTITY = intent.getStringExtra("EXTRA_QUANTITY")
        val quantity = findViewById<TextView>(R.id.quantity)
        quantity.text = QUANTITY

        val SERVICE = intent.getStringExtra("EXTRA_SERVICE")
        val service = findViewById<TextView>(R.id.service)
        service.text = SERVICE

        val ADDITION = intent.getStringExtra("EXTRA_ADDITION")
        val addition = findViewById<TextView>(R.id.addition)
        addition.text = ADDITION
    }
}