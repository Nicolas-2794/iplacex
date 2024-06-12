package com.sombra.appempleados.klases

abstract class Empleado(protected val sueldoBruto: Double) {
    abstract fun calcularLiquido(): Double
}
