package com.example.notesapp_235150201111047vincentiamelody

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesapp_235150201111047vincentiamelody.ui.theme.NotesApp_235150201111047VincentiaMelodyTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.example.notesapp_235150201111047vincentiamelody.data.model.Note
import com.example.notesapp_235150201111047vincentiamelody.NoteViewModel
import java.text.SimpleDateFormat
import java.util.Locale

//class MainActivity : ComponentActivity() {
//
//    private val noteViewModel: NoteViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MaterialTheme {
//                NotesScreen(noteViewModel)
//            }
//        }
//        noteViewModel.fetchNotes()
//    }
//}
//
//@Composable
//fun NotesScreen(noteViewModel: NoteViewModel) {
//    val notes by noteViewModel.notes.observeAsState(emptyList())
//    var title by remember { mutableStateOf("") }
//    var content by remember { mutableStateOf("") }
//    var editingNote by remember { mutableStateOf<Note?>(null) }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        Text(
//            text = "Tambah Catatan Baru",
//            style = MaterialTheme.typography.titleLarge
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = title,
//            onValueChange = { title = it },
//            label = { Text("Judul") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = content,
//            onValueChange = { content = it },
//            label = { Text("Isi Catatan") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Button(
//            onClick = {
//                if (title.isNotBlank() && content.isNotBlank()) {
//                    noteViewModel.addNote(Note(title, content))
//                    title = ""
//                    content = ""
//                }
//            }
//        ) {
//            Text("Simpan Catatan")
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = "Daftar Catatan",
//            style = MaterialTheme.typography.titleLarge
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        notes.forEach { note ->
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(4.dp)
//            ) {
//                Column(modifier = Modifier.padding(8.dp)) {
//                    Text(
//                        text = note.title,
//                        style = MaterialTheme.typography.titleMedium
//                    )
//
//                    Text(
//                        text = note.content,
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//                }
//            }
//        }
//    }
//}

class MainActivity : ComponentActivity() {

    private val noteViewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                NotesScreen(noteViewModel)
            }
        }
        noteViewModel.fetchNotes()
    }
}

@Composable
fun NotesScreen(noteViewModel: NoteViewModel) {
    val notes by noteViewModel.notes.observeAsState(emptyList())
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var editingNote by remember { mutableStateOf<Note?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = if (editingNote != null) "Perbarui Catatan" else "Tambah Catatan Baru",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = editingNote?.title ?: title,
            onValueChange = {
                if (editingNote != null) editingNote = editingNote?.copy(title = it)
                else title = it
            },
            label = { Text("Judul") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = editingNote?.content ?: content,
            onValueChange = {
                if (editingNote != null) editingNote = editingNote?.copy(content = it)
                else content = it
            },
            label = { Text("Isi Catatan") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (editingNote != null) {
                    editingNote?.let { noteToUpdate ->
                        if (noteToUpdate.title.isNotBlank() && noteToUpdate.content.isNotBlank()) {
                            noteViewModel.updateNote(noteToUpdate.id, noteToUpdate)
                            editingNote = null
                            title = ""
                            content = ""
                        }
                    }
                } else {
                    if (title.isNotBlank() && content.isNotBlank()) {
                        noteViewModel.addNote(Note(title = title, content = content))
                        title = ""
                        content = ""
                    }
                }
            }
        ) {
            Text(if (editingNote != null) "Perbarui Catatan" else "Simpan Catatan")
        }

        if (editingNote != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                editingNote = null
                title = ""
                content = ""
            }) {
                Text("Batal")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Daftar Catatan",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        notes.forEach { note ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = note.title,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = note.content,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    note.creationTime?.let { time ->
                        val formatter = remember {
                            SimpleDateFormat(
                                "dd MMM yyyy, HH:mm",
                                Locale("in", "ID")
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Dibuat: ${formatter.format(time)}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(onClick = {
                            editingNote = note.copy()
                        }) {
                            Text("Edit")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = {
                            noteViewModel.deleteNote(note.id)
                        }) {
                            Text("Hapus")
                        }
                    }
                }
            }
        }
    }
}