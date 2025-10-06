package com.example.notesapp_235150201111047vincentiamelody.data.model

import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

//class Note {
//}

data class Note(
    var id: String = "",
    var title: String = "",
    var content: String = "",

    @ServerTimestamp
    var creationTime: Date? = null
)