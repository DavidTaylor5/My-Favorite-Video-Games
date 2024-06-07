package com.example.topthirty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.topthirty.model.Game
import com.example.topthirty.model.GameRepository
import com.example.topthirty.ui.theme.TopThirtyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopThirtyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Write screen here
                    GamesAppScaffold(GameRepository.gameList)
                }
            }
        }
    }
}

@Composable
fun GamesAppScaffold(games: List<Game>) {
    Scaffold(
        topBar = {
            GamesTopAppBar()
        }
    ) {
        GameListColumn(games)
    }
}
@Composable
fun GamesTopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text ="DAVID TAYLOR'S TOP 30",
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun GameListColumn(games: List<Game>) {
    LazyColumn() {
        itemsIndexed(games) { index, game ->
            GameItem(game.titleId, game.scoreId, game.imageId, game.descId, index)
        }
    }
}

@Composable
fun GameItem(titleId: Int, scoreId: Int, imageId: Int, descId: Int, index: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(bottom = 8.dp),
        elevation = 3.dp

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GameTitle(titleId, index)
            GameReviewImage(imageId, titleId, scoreId)
            GameDescription(descId)
            Spacer(modifier.size(width = 150.dp, height = 10.dp))
        }
    }
}

@Composable
fun GameReviewImage(imageId: Int, titleId: Int, scoreId: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .wrapContentSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        GameImage(imageId, titleId)
        IgnIcon(scoreId)
    }
}

@Composable
fun GameTitle(titleId: Int, index: Int, modifier: Modifier = Modifier) {
    Text(
        text = "Rank ${index+1}:  " + stringResource(titleId),
        style = MaterialTheme.typography.h2
    )
}

@Composable
fun GameImage(imageId: Int, titleId: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(imageId),
        contentDescription = stringResource(titleId),
        Modifier
            .clip(RoundedCornerShape(25))
            .size(width = 350.dp, height = 200.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun IgnIcon(scoreId: Int) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .wrapContentSize()
            .padding(bottom = 15.dp, end = 30.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ign_hexagon),
            contentDescription = null,
            modifier = Modifier.size(width = 60.dp, height = 60.dp)
        )
        Text(
            text = stringResource(id = scoreId),
            color = Color.White,
            fontSize = 25.sp
        )
    }
}

@Composable
fun GameDescription(descId: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(descId),
        style = MaterialTheme.typography.body1,
        modifier = modifier.padding(all = 6.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TopThirtyTheme(darkTheme = false) {
        GamesAppScaffold(GameRepository.gameList)
        //GameItem(titleId = R.string.game_1_title, imageId = R.drawable.spelunky, descId = R.string.game_1_description, scoreId = R.string.game_1_score)
        //GameReviewImage(imageId = R.drawable.bioshock, titleId = R.string.game_1_title, scoreId = R.string.game_1_score)
        //GameImage(R.drawable.bioshock, R.string.game_1_title)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultDarkPreview() {
    TopThirtyTheme(darkTheme = true) {
        GamesAppScaffold(GameRepository.gameList)
    }
}