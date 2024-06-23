package com.seoleo.friendsapptdd.signup

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seoleo.friendsapptdd.R

@Composable
@Preview(device = Devices.PIXEL_4)
fun SignUp() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var timeline by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            ScreenTitle(R.string.createAnAccount)
            Spacer(modifier = Modifier.height(16.dp))
            EmailField(
                value = email,
                onValueChange = {
                    email = it
                }
            )
            PasswordField(
                value = password,
                onValueChange = {
                    password = it
                }
            )

            TimelineField(
                value = timeline,
                onValueChange = {
                    timeline = it
                }
            )
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.signUp))
            }
        }
    }
}

@Composable
private fun TimelineField(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        label = {
            Text(text = stringResource(R.string.timeline))
        },
        onValueChange = onValueChange
    )
}

@Composable
private fun EmailField(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        label = {
            Text(text = stringResource(R.string.email))
        },
        onValueChange = onValueChange
    )
}

@Composable
private fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit
) {
    val isVisible = remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(stringResource(id = R.string.password)),
        value = value,
        trailingIcon = {
            IconButton(
                onClick = {
                    isVisible.value = !isVisible.value
                }
            ) {
                val resource = if(isVisible.value) R.drawable.ic_visibility else R.drawable.ic_invisible
                Image(
                    painter = painterResource(id = resource),
                    contentDescription = stringResource(R.string.passwordTogleVisibility)
                )
            }
        },
        visualTransformation =
        if (isVisible.value) VisualTransformation.None
        else PasswordVisualTransformation(),
        label = {
            Text(text = stringResource(R.string.password))
        },

        onValueChange = onValueChange
    )
}

@Composable
private fun ScreenTitle(@StringRes resource: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(resource),
            style = typography.h4
        )
    }
}