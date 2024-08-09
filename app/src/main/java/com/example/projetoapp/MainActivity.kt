package com.example.projetoapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projetoapp.ui.theme.theme.ProjetoappTheme
import com.example.projetoapp.ui.theme.telas.Login
import com.example.projetoapp.ui.theme.telas.Principal
import com.example.projetoapp.ui.theme.telas.Cadastro

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjetoappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            Login(
                                modifier = Modifier.padding(innerPadding),
                                onSignInClick = {
                                    navController.navigate("principal")
                                },
                                onCadastroClick = {
                                    navController.navigate("cadastro")
                                }
                            )
                        }
                        composable("principal") {
                            Principal(
                                modifier = Modifier.padding(innerPadding),
                                onLogoffClick = {
                                    navController.navigate("login")
                                }
                            )
                        }

                        composable("cadastro") {
                            Cadastro(
                                modifier = Modifier.padding(innerPadding),
                                onSignInClick = {
                                    navController.navigate("cadastro")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // Use Greeting as a placeholder or for actual implementation
    Login(
        modifier = modifier,
        onSignInClick = {},
        onCadastroClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjetoappTheme {
        Greeting(name = "Preview")
    }
}
