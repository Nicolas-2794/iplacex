package com.sombra.appempleados

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sombra.appempleados.klases.EmpleadoHonorarios
import com.sombra.appempleados.ui.theme.AppEmpleadosv1Theme

class HonorariosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppEmpleadosv1Theme {
                    HonorariosScreen()
            }
        }
    }
}
    @Preview
    @Composable
    fun HonorariosScreen() {
        val contexto = LocalContext.current
        var sueldoBruto by remember { mutableStateOf("") }
        var sueldoLiquido by remember { mutableStateOf<Double?>(null) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Text(
                text = "Empleado Contrato Honorarios",
                style = TextStyle(
                    fontSize = 22.sp,
                    color = Color.White,
                    textDecoration = TextDecoration.Underline
                    )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Ingresar Sueldo Bruto",
                style = TextStyle(fontSize = 20.sp, color = Color.White)
            )
            TextField(value = sueldoBruto, onValueChange = { sueldoBruto = it })
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                val empleado = EmpleadoHonorarios(sueldoBruto.toDouble())
                sueldoLiquido = empleado.calcularLiquido()
            }) {
                Text("Calcular Sueldo Liquido")
            }
            sueldoLiquido?.let {
                Text("Sueldo Líquido: $it", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                val intent = Intent(contexto, MainActivity::class.java)
                contexto.startActivity( intent )
            }) {
                Text("Regresar al Inicio")
            }
        }
    }