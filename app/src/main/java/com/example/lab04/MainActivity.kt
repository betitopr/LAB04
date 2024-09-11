package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.lab04.ui.theme.LAB04Theme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.input.key.Key.Companion.Four
import androidx.compose.ui.input.key.Key.Companion.One
import androidx.compose.ui.input.key.Key.Companion.Three
import androidx.compose.ui.input.key.Key.Companion.Two


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LAB04Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color=MaterialTheme.colorScheme.background

                ){

                }
                /*Primer Componente*/
                AlertDialogExample(
                    onDismissRequest = { /*TODO*/ },
                    onConfirmation = { /*TODO*/ },
                    dialogTitle = "Podemos hackearte",
                    dialogText = "Necesitamos el control de tu dispositivo por el cual pedimos tu acceso",
                    icon = painterResource(id = R.drawable.ic_launcher_foreground)
                )
                /*Segundo Componente*/
//                DialogWithImage(
//                    onDismissRequest = { /*TODO*/ },
//                    onConfirmation = { /*TODO*/ },
//                    painter = painterResource(id = R.drawable.lavanda),
//                    imageDescription ="Paisaje"
//                )
                /*Tercer Componente*/
//                LinearDeterminateIndicator()
                DropdownMenuExample()


            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: Painter,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirmar")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Disminuir")
            }
        },
        containerColor = Color(0xFFB0E0E6),

        modifier = Modifier
            .background(color = Color(0xFFB0E0E6),)
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun Preview_AlertDialog(){
    LAB04Theme {
        AlertDialogExample(
            onDismissRequest = { /*TODO*/ },
            onConfirmation = { /*TODO*/ },
            dialogTitle = "Podemos hackearte?",
            dialogText = "Necesitamos el control de tu dispositivo por el cual pedimos tu acceso",
            icon = painterResource(id = R.drawable.hacker)
        )
    }
}
// Implementacion de dialog mas complejo

@Composable
fun DialogWithImage(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    painter: Painter,
    imageDescription: String,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        // Draw a rectangle shape with rounded corners inside the dialog
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),


        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painter,
                    contentDescription = imageDescription,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(160.dp)
                )
                Text(
                    text = "This is a dialog with buttons and an image.",
                    modifier = Modifier
                        .padding(16.dp),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Dismiss")
                    }
                    TextButton(
                        onClick = { onConfirmation() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Confirm")
                    }
                }
            }
        }
    }
}
//@Preview
@Composable
fun Dialogo2(){
    DialogWithImage(
        onDismissRequest = { /*TODO*/ },
        onConfirmation = { /*TODO*/ },
        painter = painterResource(id = R.drawable.lavanda),
        imageDescription = "Paisaje"
    )
}

//Componente de Linea de Progreso

@Composable
fun LinearDeterminateIndicator() {
    var currentProgress by remember { mutableStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope() // Create a coroutine scope

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            loading = true
            scope.launch {
                loadProgress { progress ->
                    currentProgress = progress
                }
                loading = false // Reset loading when the coroutine finishes
            }
        }, enabled = !loading) {
            Text("Start loading")
        }

        if (loading) {
            CircularProgressIndicator(
                progress = { currentProgress },
                trackColor = Color(0xFFB0E0E6),
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

/** Iterate the progress value */
suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}
@Composable
@Preview
fun vistaProgreso(){
    LinearDeterminateIndicator()
}

//Ejemplo de DropDownMenu


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuExample(){
    val list = listOf("One","Two","Three","Four")
    var selectedText by remember {
        mutableStateOf(list[0])
    }
    var isExpanded by remember {
        mutableStateOf(false)

    }
    Column(modifier= Modifier
        .fillMaxWidth()
        .padding(
            top=50.dp
        )
        .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange ={isExpanded=!isExpanded} ,
            )
        {
            TextField(
                modifier = Modifier.menuAnchor(),
                value = selectedText,
                onValueChange = { },
                readOnly=true,
                trailingIcon = @androidx.compose.runtime.Composable {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)}

                    )
            ExposedDropdownMenu(
                expanded =isExpanded ,
                onDismissRequest = { isExpanded = false}) {
                list.forEachIndexed { index,text ->
                    DropdownMenuItem(
                    text = { Text (text=text)},
                    onClick = { selectedText=list[index]
                    isExpanded=false
                    },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Favorite,
                                contentDescription = null,
                                tint = androidx.compose.ui.graphics.Color.Red
                            )
                        },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
                }


        }
        Text(text = "Currenly selected:$selectedText")

    }

}
@Preview(showBackground = true)
@Composable
fun DropPreview(){
    LAB04Theme {
        DropdownMenuExample()
    }
}