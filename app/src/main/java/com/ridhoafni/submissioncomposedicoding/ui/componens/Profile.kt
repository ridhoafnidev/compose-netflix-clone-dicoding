package com.ridhoafni.submissioncomposedicoding.ui.componens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ridhoafni.submissioncomposedicoding.R
import com.ridhoafni.submissioncomposedicoding.ui.theme.NetflixCloneAppDicodingAppsTheme

@Composable
fun Profile() {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.im),
            contentDescription = "Photo Profile",
            modifier = Modifier
                .size(60.dp)
                .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text("Ridho Afni", fontWeight = FontWeight.Bold, color = Color.White)
            Text("ridhoafni.cev@gmail.com", color = Color.LightGray)
        }
    }
}

@Preview
@Composable
fun ProfilePreview() {
    NetflixCloneAppDicodingAppsTheme {
        Profile()
    }
}