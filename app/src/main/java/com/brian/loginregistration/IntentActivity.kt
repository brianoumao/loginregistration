package com.brian.loginregistration

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import com.brian.loginregistration.ui.theme.LoginregistrationTheme

class IntentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginregistrationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Greeting("Android")
                    Intentscreen()
                }
            }
        }
    }
}

@Composable
fun Intentscreen() {
    val context= LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 15.dp)
    ) {
        Text(text = "Intent App",
             color = Color.Red,
             fontFamily = FontFamily.Cursive,
             fontSize = 35.sp
        )
    Spacer(modifier = Modifier.height(20.dp))
    OutlinedButton(
        onClick = {
              val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

              startActivityForResult(context as Activity,takePictureIntent,1,null)

        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.Cyan)
    ) {
        Text(
            text = "Camera",
            fontSize = 15.sp) }
    Spacer(modifier = Modifier.height(20.dp))
    OutlinedButton(
        onClick = {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254743553390"))

            if(ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
                ){
                  ActivityCompat.requestPermissions(
                      context as Activity,
                      arrayOf(android.Manifest.permission.CALL_PHONE),
                      1
                  )
            } else{
                context.startActivity(intent)
            }
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.Cyan)
    ) {
        Text(
            text = "Call",
            fontSize = 15.sp) }
    Spacer(modifier = Modifier.height(20.dp))
    OutlinedButton(
        onClick = {
            val phone = "0743553390"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            context.startActivity(intent)
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.Cyan)
    ) {
        Text(
            text = "Dial",
            fontSize = 15.sp) }
    Spacer(modifier = Modifier.height(20.dp))
    OutlinedButton(
        onClick = {
                  val uri = Uri.parse("smsto:0789564462")

                  val intent = Intent(Intent.ACTION_SENDTO, uri)

                  intent.putExtra("Hello", "How is todays weather")

                  context.startActivity(intent)
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.Cyan)
    ) {
        Text(
            text = "Sms",
            fontSize = 15.sp) }
    Spacer(modifier = Modifier.height(20.dp))
    OutlinedButton(
        onClick = {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            context.startActivity(shareIntent)
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.Cyan)
    ) {
        Text(
            text = "Share",
            fontSize = 15.sp) }
    Spacer(modifier = Modifier.height(20.dp))
    OutlinedButton(
        onClick = {
            val simToolKitLaunchIntent =
                context.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { context.startActivity(it) }
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.Cyan)
    ) {
        Text(
            text = "Mpesa",
            fontSize = 15.sp) }
    Spacer(modifier = Modifier.height(20.dp))
    OutlinedButton(onClick = { val emailIntent =
        Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

        context.startActivity(Intent.createChooser(emailIntent, "Send email...")) },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.Cyan)
    ) {
        Text(text = "Email",
            fontSize = 15.sp) }
}
    }
@Preview
@Composable
private fun Intentprev(){
    Intentscreen()

}









