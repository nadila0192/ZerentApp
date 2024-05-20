package com.example.zerentapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.zerentapp.component.ChatlistItem
import com.example.zerentapp.data.tempData
import com.example.zerentapp.model.ChatList

@Composable
fun ChatListScreen(
    modifier: Modifier = Modifier,
    chatlists: List<ChatList> = tempData.chatList,
) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            items(chatlists, key = { it.id }) {
                ChatlistItem(ChatList = it)
            }
        }
        Text(
            text = "Copyright by Ambhilasa Pattimura",
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF043C5B),
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)

        )
    }
}