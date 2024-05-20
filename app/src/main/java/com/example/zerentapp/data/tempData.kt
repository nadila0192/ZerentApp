package com.example.zerentapp.data

import com.example.zerentapp.R
import com.example.zerentapp.model.ChatList

object tempData {
    val chatList = listOf(
        ChatList(
            id = 1,
            user = "Hendra",
            role = "sender",
            textchat = "lorem ipsum dolor sit amet",
            photo = R.drawable.profil
        ),
        ChatList(
            id = 2,
            user = "Hendra",
            role = "sender",
            textchat = "lorem ipsum dolor sit amet",
            photo = R.drawable.profil
        )
    )
}