package com.appscals.gitcloneapp.presentation.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.appscals.gitcloneapp.presentation.viewmodel.UserInfoViewModel

@Composable
fun UserDetailScreen(
    viewModel: UserInfoViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    state.user?.let { user ->
        val context = LocalContext.current
        val intent = remember { Intent(Intent.ACTION_VIEW, android.net.Uri.parse(user.htmlUrl)) }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    modifier = Modifier
                        .padding(16.dp, 24.dp, 16.dp, 16.dp)
                        .size(200.dp),
                    painter = rememberImagePainter(
                        data = user.avatarUrl,
                        builder = {
                            scale(coil.size.Scale.FILL)
                            placeholder(coil.base.R.drawable.notification_action_background)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = "Test Image",
                )
                Text(text = user.name, fontSize = 22.sp)
                Text(text = user.login)
                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ColInfo(user.followers.toString(), "Followers")
                    ColInfo(user.following.toString(), "Following")
                    ColInfo(user.publicRepos.toString(), "Repositories")
                }
                Spacer(modifier = Modifier.padding(8.dp))
                OutlinedButton(
                    onClick = { context.startActivity(intent) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text(
                        text = "View on Github",
                        color = Color.White,
                        modifier = Modifier.padding(4.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    RowInfo(user.location.toString(), Icons.Rounded.Place)
                    RowInfo(user.email.toString(), Icons.Rounded.Email)
                    RowInfo(
                        "twitter.com/${user.twitterUsername.toString()}",
                        Icons.Rounded.Notifications
                    )
                }
            }
        }
    }
}

@Composable
fun RowInfo(text: String, image: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        Icon(imageVector = image, contentDescription = "")
        Text(text = text, modifier = Modifier.padding(start = 8.dp))
    }
}

@Composable
fun ColInfo(text: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = text, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}