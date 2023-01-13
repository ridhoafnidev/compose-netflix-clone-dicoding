package com.ridhoafni.submissioncomposedicoding.ui.componens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ridhoafni.submissioncomposedicoding.ui.theme.NetflixCloneAppDicodingAppsTheme

@ExperimentalMaterial3Api
@Composable
fun MovieSearchField(
    searchValue: String = "",
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchValue,
        onValueChange = {
            onTextChange.invoke(it)
        },
        modifier = modifier,
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null, tint = Color.Gray)
        },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Gray,
            focusedIndicatorColor = MaterialTheme.colorScheme.onSurface,
            containerColor = MaterialTheme.colorScheme.surface
        )
    )
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun MovieSearchFieldPreview() {
    var text by remember {
        mutableStateOf("")
    }

    NetflixCloneAppDicodingAppsTheme {
        MovieSearchField(
            text,
            onTextChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}