package com.example.projetoapp.ui.theme.telas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun Login(modifier: Modifier = Modifier, onSignInClick: () -> Unit) {

    var login by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var mensagemErro by remember { mutableStateOf<String?>(null) }

    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {


        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = "Login:",
                modifier = Modifier.padding(top = 30.dp),
                fontSize = 22.sp)

            TextField(value = login, onValueChange = {login = it},
                placeholder = {
                    Text(
                        "Digite o login",
                        fontSize = 10.sp) }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = "Senha:",
                modifier = Modifier.padding(top = 30.dp),
                fontSize = 22.sp)

            TextField(value = senha, onValueChange = {senha = it},
                placeholder = {
                    Text("Digite a senha",
                        fontSize = 12.sp)},

                visualTransformation = PasswordVisualTransformation()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        FloatingActionButton(
            onClick = {
                if (login ==  senha) {
                    onSignInClick()
                } else {
                    mensagemErro = "Login ou senha inválidos!"
                }
            },
            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
            shape = RoundedCornerShape(12.dp),
            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            ) {
                // Icon
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Login Icon",
                    tint = Color.Black
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Text
                Text(
                    text = "Entrar",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
        }


        mensagemErro?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 8.dp)
            )
            LaunchedEffect(Unit) {
                delay(3000)
                mensagemErro = null
            }
        }
    }
}