package cl.bootcamp.transaccionesbancarias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.transaccionesbancarias.ui.theme.TransaccionesBancariasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransaccionesBancariasTheme {
                // Llama a la función para mostrar las transacciones
                MostrarCuentas()
            }
        }
    }
}

@Composable
fun MostrarCuentas() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Primera cuenta: Lorena
        val cuenta1 = CuentaBancaria("Lorena", 1000.0)
        cuenta1.deposito(200.0)
        cuenta1.retiro(1200.0)
        cuenta1.deposito(3000.0)
        cuenta1.deposito(500.0)
        cuenta1.retiro(3606.6)

        // Mostrando el historial y saldo de Lorena
        Text(text = "Historial de ${cuenta1.nombreCuenta}:\n" + cuenta1.mostrarHistorial())
        Text(text = "Saldo disponible de ${cuenta1.nombreCuenta}: " + cuenta1.mostrarSaldo())

        // Segunda cuenta: Carlos
        val cuenta2 = CuentaBancaria("Carlos", 500.0)
        cuenta2.deposito(300.0)
        cuenta2.retiro(100.0)
        cuenta2.deposito(600.0)
        cuenta2.retiro(400.0)
        cuenta2.deposito(200.0)

        // Mostrando el historial y saldo de Carlos
        Text(text = "Historial de ${cuenta2.nombreCuenta}:\n" + cuenta2.mostrarHistorial())
        Text(text = "Saldo disponible de ${cuenta2.nombreCuenta}: " + cuenta2.mostrarSaldo())

        // Tercera cuenta: Lucía
        val cuenta3 = CuentaBancaria("Lucía", 2000.0)
        cuenta3.deposito(1500.0)
        cuenta3.retiro(1000.0)
        cuenta3.deposito(800.0)
        cuenta3.retiro(2500.0)  // Retiro fallido si no tiene suficiente saldo
        cuenta3.deposito(1000.0)

        // Mostrando el historial y saldo de Lucía
        Text(text = "Historial de ${cuenta3.nombreCuenta}:\n" + cuenta3.mostrarHistorial())
        Text(text = "Saldo disponible de ${cuenta3.nombreCuenta}: " + cuenta3.mostrarSaldo())
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCuentas() {
    MostrarCuentas()
}
