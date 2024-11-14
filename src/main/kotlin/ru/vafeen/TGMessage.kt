package ru.vafeen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import ru.vafeen.ui.FontSize
import ru.vafeen.ui.background
import ru.vafeen.ui.messageBackgroundColor
import ru.vafeen.ui.nameColor

@Composable
private fun Fake() {
    Text(
        "FAKE",
        color = nameColor,
        fontSize = FontSize.small,
        modifier = Modifier.background(nameColor)
            .padding(1.dp).background(messageBackgroundColor).padding(1.dp)
    )
}

@Composable
private fun StandardText(text: String, color: Color, fontSize: TextUnit) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        style = MaterialTheme.typography.body1.copy(
            fontWeight = FontWeight.Light
        )
    )
}

@Composable
private fun MessageTitle(title: String) {
    StandardText(text = title, color = nameColor, fontSize = FontSize.normal)
}

@Composable
private fun MessageText(text: String) {
    StandardText(text = text, color = Color.White, fontSize = FontSize.normal)
}


private fun shapeByIndex(index: Int, size: Int): Shape {
    val no = 0
    val normal = 10
    val full = 30
    var topStart = 0.dp
    var topEnd = full.dp
    var bottomEnd = full.dp
    var bottomStart = 0.dp
    topStart = if (index == 0) full.dp else normal.dp
    bottomStart = if (index == size - 1) no.dp else normal.dp
    return RoundedCornerShape(
        topStart = topStart,
        topEnd = topEnd,
        bottomStart = bottomStart,
        bottomEnd = bottomEnd
    )
}

@Composable
internal fun TGMessage(title: String? = null, text: String, index: Int, size: Int) {
    val cornerBottomSize = 20.dp
    Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.padding(4.dp)) {
        if (index == size - 1) {
            Card(
                modifier = Modifier.size(cornerBottomSize).background(messageBackgroundColor),
                backgroundColor = background,
                shape = RoundedCornerShape(bottomEnd = cornerBottomSize)
            ) {}
        }
        Card(
            modifier = Modifier.let {
                if (index != size - 1) it.padding(start = cornerBottomSize) else it
            },
            backgroundColor = messageBackgroundColor,
            shape = shapeByIndex(index = index, size = size)
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                title?.let {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        MessageTitle(title = title)
                        Spacer(modifier = Modifier.width(2.dp))
                        Fake()
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
                MessageText(text = text)
            }
        }
    }
}