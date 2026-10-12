package com.example.addtonum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(v: View) {
        val etA = findViewById<EditText>(R.id.numA)
        val etB = findViewById<EditText>(R.id.numB)
        val tvSum = findViewById<TextView>(R.id.sum)

        val a = parse(etA)
        val b = parse(etB)
        if (a == null || b == null) {
            tvSum.text = ""
            return
        }

        tvSum.text = (a + b).stripTrailingZeros().toPlainString()
    }

    private fun parse(field: EditText): BigDecimal? {
        val text = field.text.toString().trim().replace(',', '.')
        if (text.isEmpty()) {
            field.error = "Введите число"
            return null
        }
        return try {
            BigDecimal(text)
        } catch (e: NumberFormatException) {
            field.error = "Некорректное число"
            null
        }
    }
}