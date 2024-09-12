package cl.bootcamp.transaccionesbancarias

class CuentaBancaria(val nombreCuenta: String, var saldoDisponible: Double) {
    private val historial = mutableListOf<String>()

    // Función para realizar un depósito
    fun deposito(cantidad: Double) {
        saldoDisponible += cantidad
        historial.add("$nombreCuenta depositó $$cantidad")
    }

    // Función para realizar un retiro
    fun retiro(cantidad: Double) {
        if (cantidad <= saldoDisponible) {
            saldoDisponible -= cantidad
            historial.add("$nombreCuenta retiró $$cantidad")
        } else {
            historial.add("$nombreCuenta intentó retirar $$cantidad, pero no tenía suficiente saldo.")
        }
    }

    // Función para mostrar el saldo disponible, retornando un String
    fun mostrarSaldo(): String {
        return "El saldo disponible de $nombreCuenta es: $$saldoDisponible"
    }

    // Función para mostrar el historial de transacciones, retornando un String
    fun mostrarHistorial(): String {
        return historial.joinToString("\n")
    }
}
