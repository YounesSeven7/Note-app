package com.example.noteapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.noteapp.feature_note.domain.util.NoteOrder
import com.example.noteapp.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            NoteOrderRadioButtonGroup(noteOrder = noteOrder, onOrderChange = onOrderChange)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            OrderTypeRadioButtonGroup(noteOrder = noteOrder, onOrderChange = onOrderChange)
        }
    }

}

@Composable
fun NoteOrderRadioButtonGroup(
    noteOrder: NoteOrder,
    onOrderChange: (NoteOrder) -> Unit) {
    DefaultRadioButton(
        text = "Title",
        selected = noteOrder is NoteOrder.Title,
        onClick = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) }
    )
    Spacer(modifier = Modifier.width(8.dp))
    DefaultRadioButton(
        text = "Date",
        selected = noteOrder is NoteOrder.Date,
        onClick = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) }
    )
    Spacer(modifier = Modifier.width(8.dp))
    DefaultRadioButton(
        text = "Color",
        selected = noteOrder is NoteOrder.Color,
        onClick = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) }
    )
}

@Composable
fun OrderTypeRadioButtonGroup(noteOrder: NoteOrder, onOrderChange: (NoteOrder) -> Unit) {
    DefaultRadioButton(
        text = "Ascending",
        selected = noteOrder.orderType is OrderType.Ascending,
        onClick = { onOrderChange(noteOrder.copy(OrderType.Descending)) }
    )
    Spacer(modifier = Modifier.width(8.dp))
    DefaultRadioButton(
        text = "Descending",
        selected = noteOrder.orderType is OrderType.Descending,
        onClick = { onOrderChange(noteOrder.copy(OrderType.Ascending)) }
    )
}