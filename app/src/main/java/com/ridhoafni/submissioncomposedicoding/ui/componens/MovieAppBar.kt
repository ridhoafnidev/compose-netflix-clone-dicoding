package com.ridhoafni.submissioncomposedicoding.ui.componens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.GridView
import androidx.compose.material.icons.rounded.ViewList
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ridhoafni.submissioncomposedicoding.R
import com.ridhoafni.submissioncomposedicoding.ui.theme.NetflixCloneAppDicodingAppsTheme

@ExperimentalMaterial3Api
@Composable
fun MovieAppBar(
    modifier: Modifier = Modifier,
    imageResourceId: Int = R.drawable.ic_netflix,
    isTransparent: Boolean? = false,
    customText: String? = null,
    onBack: (() -> Unit)? = null,
    onViewChange: ((isGrid: Boolean) -> Unit)? = null
) {
    var isGrid by remember { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = if (isTransparent == true) Color.Transparent else Color.Black
        ),
        title = {
            if (customText == null) {
                Image(
                    painter = painterResource(id = imageResourceId),
                    contentDescription = stringResource(R.string.app_bar_image),
                    modifier = Modifier.height(35.dp),
                    contentScale = ContentScale.FillHeight
                )
            }
            else {
                Text(
                    text = customText,
                    fontWeight = FontWeight.Bold,
                    color = if (isTransparent == true) Color.White else Color.Black
                )
            }
        },
        navigationIcon = {
            if (onBack != null) IconButton(onClick = { onBack() }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "",
                    tint = if (isTransparent == true) Color.White else Color.Black
                )
            }
        },
        actions = {
            if (onViewChange != null) IconButton(onClick = {
                isGrid = !isGrid
                onViewChange(isGrid)
            }) {
                Icon(
                    imageVector = if (isGrid) Icons.Rounded.GridView else Icons.Rounded.ViewList,
                    contentDescription = "",
                    tint = if (isTransparent == true) Color.White else Color.Black
                )
            }
        }
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun MovieAppBarPreview() {
    NetflixCloneAppDicodingAppsTheme() {
        MovieAppBar()
    }
}