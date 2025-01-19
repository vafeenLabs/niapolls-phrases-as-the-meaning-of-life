import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.vafeen.ProjectInfo
import ru.vafeen.TGMessage
import ru.vafeen.ui.background
import java.io.File
import javax.imageio.ImageIO

@Composable
private fun ResourceImage(
    modifier: Modifier = Modifier,
    fileName: String
) {
    val image = ImageIO.read(File("src/main/resources/drawable/$fileName"))
    Image(
        modifier = modifier.clip(CircleShape).size(70.dp),
        painter = image.asPainter(), contentDescription = null
    )
}

@Composable
@Preview
private fun App() {
    val messages =
        listOf(
            "Тест",
            "Тест",
            "Тест",
        )
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize().background(background),
            contentAlignment = Alignment.Center
        ) {
            Row(modifier = Modifier) {
                ResourceImage(
                    modifier = Modifier.align(Alignment.Bottom),
                    fileName = "niapoll.jpg"
                )
                Column(modifier = Modifier) {
                    messages.forEachIndexed { index, it ->
                        TGMessage(
                            title = if (index == 0) "Niapoll" else null,
                            text = it,
                            index = index,
                            size = messages.size
                        )
                    }
                }
            }
        }
    }
}

fun main() = application {
    Window(
        title = ProjectInfo.NAME,
        onCloseRequest = ::exitApplication
    ) {
        App()
    }
}
