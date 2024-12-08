package jp.speakbuddy.edisonandroidexercise.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import jp.speakbuddy.edisonandroidexercise.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val catFact by viewModel.catFact.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadCatFact()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display image using Coil
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://placekitten.com/400/300")
                .crossfade(true)
                .build(),
            contentDescription = "Cat Image",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp)
        )

        if (catFact != null) {
            Text("Cat Fact: ${catFact!!.fact}")
            if (catFact!!.length > 100) {
                Text("Fact Length: ${catFact!!.length}")
            }
            if (catFact!!.fact.contains("cats", ignoreCase = true)) {
                Text("Multiple cats!", color = Color.Red)
            }
        } else {
            Text("No cat fact saved.")
        }
    }
}
