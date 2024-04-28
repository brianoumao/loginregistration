package com.brian.loginregistration

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brian.loginregistration.ui.theme.LoginregistrationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginregistrationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  //  Greeting("Android")
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 15.dp)
    ) {
        Text(
            text = "eMobilis Login",
            color = Color.Black,
            fontSize = 28.sp


        )
        Icon(imageVector = Icons.Default.Person, contentDescription = "person")
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email,
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email") },
            onValueChange = { email = it },
            label = {
                Text(
                    text = "Enter email",
                    color = Color.Black,
                    fontSize = 20.sp


                )


            },

            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "pass") },
            label = {
                Text(
                    text = "Enter Pass",
                    fontSize = 20.sp

                )
            },
            modifier = Modifier.fillMaxWidth()


        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Cyan)

        ) {
            Text(
                text = "Log in",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(context, RegisterActivity::class.java)
                context.startActivity(intent)

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Cyan)

        ) {
            Text(
                text = "Register",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(context, IntentActivity::class.java)
                context.startActivity(intent)

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Cyan)

        ) {
            Text(
                text = "Intent",
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(context, CalculatorActivity::class.java)
                context.startActivity(intent)

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Cyan)

        ) {
            Text(
                text = "Calculator",
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(context, RecyclerviewActivity::class.java)
                context.startActivity(intent)

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Cyan)

        ) {
            Text(
                text = "Recycler",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(context, SimpleListActivity::class.java)
                context.startActivity(intent)

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Cyan)

        ) {
            Text(
                text = "Simple",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(context, CustomListActivity::class.java)
                context.startActivity(intent)

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Cyan)

        ) {
            Text(
                text = "Custom",
                fontSize = 20.sp
            )
        }
    }
}
@Preview
@Composable
private fun Loginpre(){
    Login()
}

