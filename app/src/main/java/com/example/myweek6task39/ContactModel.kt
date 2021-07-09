package com.example.myweek6task39

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactModel (

    val contactName: String,
    val phoneNumber: String,

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    )