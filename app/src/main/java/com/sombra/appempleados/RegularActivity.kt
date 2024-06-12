package com.sombra.appempleados

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sombra.appempleados.klases.EmpleadoRegular

class RegularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_regular)

        val sueldoBrutoEditText: EditText = findViewById(R.id.sueldoBrutoEditText)
        val calcularButton: Button = findViewById(R.id.calcularButton)
        val resultadoTextView: TextView = findViewById(R.id.resultadoTextView)
        val volverButton: Button = findViewById(R.id.volverButton)

        calcularButton.setOnClickListener {
            val sueldoBruto = sueldoBrutoEditText.text.toString().toDoubleOrNull()
            if (sueldoBruto != null) {
                val empleado = EmpleadoRegular(sueldoBruto)
                val sueldoLiquido = empleado.calcularLiquido()
                resultadoTextView.text = "Sueldo Líquido: $sueldoLiquido"
            } else {
                resultadoTextView.text = "Por favor, ingresa un sueldo válido"
            }
        }

        volverButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity( intent )
            finish()
        }
    }
}