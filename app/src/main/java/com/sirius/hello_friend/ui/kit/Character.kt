import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sirius.hello_friend.domain.model.Gender
import com.sirius.hello_friend.domain.model.People
import com.sirius.hello_friend.ui.model.PeopleViewState
import com.sirius.hello_friend.ui.theme.Typography

@Composable
fun character(people: People) {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            label(text = people.name)
            label("height = ${people.height}")
        }
    }
}

@Composable
private fun label(text: String) {
    Text(
        text = text,
        Modifier.padding(16.dp),
        style = Typography.body1
    )
}

@Preview
@Composable
fun characterPreview() = character(people =
    People("Luke", 172, 75, "blonde", "", Gender.MALE)
)

@Composable
fun characters(people: List<People>) {
    LazyColumn { items(people) { character(people = it) } }
}

@Composable
fun CharactersScreen(state: State<PeopleViewState>) {
    val viewState = state.value
    if (viewState.isLoading.not()) {
        characters(people = viewState.data)
    }
}