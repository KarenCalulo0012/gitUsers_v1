package com.appscals.gitcloneapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.appscals.gitcloneapp.domain.model.Users

@Composable
fun UserListItem(users: Users, onItemClick: (Users) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp, 4.dp)
            .height(110.dp)
            .clickable {
                onItemClick(users)
            },
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Surface() {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
            ) {
                Image(modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxHeight()
                    .weight(0.5f),
                    painter = rememberImagePainter(
                        data = users.avatarUrl,
                        builder = {
                            scale(coil.size.Scale.FILL)
                            placeholder(coil.base.R.drawable.abc_vector_test)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = users.login
                )
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxHeight()
                        .weight(2.0f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = users.login,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = users.type,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )
                    Text(
                        text = users.htmlUrl,
                        style = MaterialTheme.typography.subtitle2,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }

    }
}