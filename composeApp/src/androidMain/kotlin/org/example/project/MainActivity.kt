package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


//main entry for acitivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CalcView()
        }
    }
}

@Preview
@Composable
fun CalcView() {
    //inside of the CalcView function create the following state variables using rememberSaveable.

    var leftNumber by rememberSaveable { mutableStateOf(0) }
    var rightNumber by rememberSaveable { mutableStateOf(0) }
    var operation by rememberSaveable { mutableStateOf("") }
    var complete by rememberSaveable { mutableStateOf(false) }
    var displayText by rememberSaveable { mutableStateOf("0") }

    //result is assigned to displayText with specific operation
    if (complete && operation.isNotEmpty()) {
        var answer = 0
        when (operation) {
            "+" -> answer = leftNumber + rightNumber
            "-" -> answer = leftNumber - rightNumber
            "*" -> answer = leftNumber * rightNumber
            "/" -> if (rightNumber != 0) answer = leftNumber / rightNumber
        }
        displayText = answer.toString()
    } else if (operation.isNotEmpty() && !complete) {
        displayText = rightNumber.toString()
    } else {
        displayText = leftNumber.toString()
    }
    // function to handle number button press
    fun numberPress(btnNum: Int) {
        if (complete) {
            leftNumber = 0
            rightNumber = 0
            operation = ""
            complete = false
        }

        if (operation.isNotBlank() && !complete) {
            rightNumber = rightNumber * 10 + btnNum
        } else if (operation.isBlank() && !complete) {
            leftNumber = leftNumber * 10 + btnNum
        }
    }
    //method implemented after the button is pressed
    fun operationPress(op: String) {
        if (!complete) {
            operation = op
        }
    }
    //method implemented when equal button is pressed
    fun equalsPress() {
        complete = true
    }

    //code for interface
    Column(modifier = Modifier.background(Color.LightGray)) {
        Row {
            CalcDisplay( displayText)
        }
        Row {
            Column {
                for (i in 7 downTo 1 step 3) {
                    CalcRow(onPress = { number -> numberPress(number) }, startNum = i, numButtons = 3)
                }
                Row {
                    CalcNumericButton(onPress = { number -> numberPress(number) }, number = 0)
                    CalcEqualsButton(onPress = { equalsPress() })
                }
            }
            Column {
                CalcOperationButton(onPress = { op -> operationPress(op) }, operation = "+")
                CalcOperationButton(onPress = { op -> operationPress(op) }, operation = "-")
                CalcOperationButton(onPress = { op -> operationPress(op) }, operation = "*")
                CalcOperationButton(onPress = { op -> operationPress(op) }, operation = "/")
            }
        }
    }
}
//Generates a row of number buttons for the calculator
@Composable
fun CalcRow(onPress: (number: Int) -> Unit, startNum: Int, numButtons: Int) {
    val endNum = startNum + numButtons
    Row(modifier = Modifier.padding(0.dp)) {
        for (i in startNum until endNum) {
            CalcNumericButton(onPress = onPress, number = i)
        }
    }
}
// it displays the character in the top display section
@Composable
fun CalcDisplay(display: String) {
    Text(
        text = display,
        modifier = Modifier
            .height(50.dp)
            .padding(5.dp)
            .fillMaxWidth()
    )
}

// handles when the numeric buttons are clicked
@Composable
fun CalcNumericButton(onPress: (number: Int) -> Unit, number: Int) {
    Button(
        onClick = { onPress(number) },
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text = number.toString())
    }
}


// logic when operations button are pressed
@Composable
fun CalcOperationButton(onPress: (operation: String) -> Unit, operation: String) {
    Button(
        onClick = { onPress(operation) },
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text = operation)
    }
}

//logic when equal button is pressed
@Composable
fun CalcEqualsButton(onPress: () -> Unit) {
    Button(
        onClick = { onPress() },
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text = "=")
    }
}