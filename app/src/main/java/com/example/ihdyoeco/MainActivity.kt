package com.example.ihdyoeco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var address: EditText
    lateinit var variety: Spinner
    lateinit var quantity: TextView
    lateinit var plus: Button
    lateinit var minus: Button
    lateinit var shipping: RadioGroup
    lateinit var npk: CheckBox
    lateinit var compost: CheckBox
    lateinit var vitamin: CheckBox
    lateinit var order: Button

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

        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        address = findViewById(R.id.address)
        variety = findViewById(R.id.variety)
        quantity = findViewById(R.id.quantity)
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        shipping = findViewById(R.id.shipping)
        npk = findViewById(R.id.npk)
        compost = findViewById(R.id.compost)
        vitamin = findViewById(R.id.vitamin)
        order = findViewById(R.id.order)

        var count = 0
        plus.setOnClickListener{
            count += 1
            quantity.text = count.toString()
        }
        minus.setOnClickListener{
            count -= 1
            quantity.text = count.toString()
        }
        order.setOnClickListener {

            val name = name.text.toString()
            val address = address.text.toString()
            val variety = variety.selectedItem.toString()

            val qty = quantity.text.toString()

            val SelectedShippingService: Int = shipping.checkedRadioButtonId
            val rbService = findViewById<RadioButton>(SelectedShippingService)
            val service = rbService.text.toString()

            var addition = ""
            if (npk.isChecked) {
                addition += ("\n" + npk.text)
            }
            if (compost.isChecked) {
                addition += ("\n" + compost.text)
            }
            if (vitamin.isChecked) {
                addition += ("\n" + vitamin.text)
            }

            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("EXTRA_NAME", name)
            intent.putExtra("EXTRA_ADDRESS", address)
            intent.putExtra("EXTRA_VARIETY", variety)
            intent.putExtra("EXTRA_QUANTITY", qty)
            intent.putExtra("EXTRA_SERVICE", service)
            intent.putExtra("EXTRA_ADDITION", addition)
            startActivity(intent)
        }
    }
}