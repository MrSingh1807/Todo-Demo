package presentation.screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextDecoration
import org.jetbrains.compose.resources.painterResource
import presentation.screen.todoTasks.TodoTask
import todokmpdemo.composeapp.generated.resources.Res
import todokmpdemo.composeapp.generated.resources.compose_multiplatform


@Composable
fun TaskView(
    task: TodoTask,
    showActive: Boolean = true,
    onSelect: (TodoTask) -> Unit,
    onCompleted: (TodoTask, Boolean) -> Unit,
    onFavorite: (TodoTask, Boolean) -> Unit,
    onDelete: (TodoTask) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .clickable {
                if (showActive) onSelect.invoke(task)
                else onDelete.invoke(task)
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.completed,
                onCheckedChange = { onCompleted.invoke(task, !task.completed) }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = task.titile,
                modifier = Modifier.alpha(if (showActive) 1f else 0.5f),
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                textDecoration = if (showActive) TextDecoration.None
                else TextDecoration.LineThrough
            )
        }
        IconButton(onClick = {
            if (showActive) onFavorite(task, task.favorite)
        }) {
            Icon(
                painter = painterResource(
                    Res.drawable.compose_multiplatform
//                    if (showActive) Res.drawable.star
//                    else Res.drawable.delete
                ),
                contentDescription = "Favourite iCon",
                tint = if (task.favorite) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}