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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sombra.appempleados.ui.theme.AppEmpleadosv1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppEmpleadosv1Theme {
                MainScreen()
            } } } }
@Preview
@Composable
fun MainScreen() {
        val contexto = LocalContext.current
        Column(
            modifier = Modifier.fillMaxSize().background(Color.DarkGray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                val intent = Intent(contexto, HonorariosActivity::class.java)
                    contexto.startActivity( intent )
            },
                modifier = Modifier.size(width = 330.dp, height = 80.dp)
            ) {
                Text("Calcular Empleado Honorarios", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = {
                val intent = Intent(contexto, RegularActivity::class.java)
                contexto.startActivity( intent )
            },
                modifier = Modifier.size(width = 330.dp, height = 80.dp)
                ) {
                Text("Calcular Empleado Regular", fontSize = 20.sp)
            }
        }
    }


