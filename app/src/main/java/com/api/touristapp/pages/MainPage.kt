package com.api.touristapp.pages

import android.Manifest
import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size
import com.api.touristapp.R
import com.api.touristapp.ui.theme.TouristAppTheme
import com.api.touristapp.utils.CheckPermissions

@Composable
fun MainPage(
    navController: NavHostController
){
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        CheckPermissions(
            context,
            arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_MEDIA_IMAGES),
            onPermissionsGranted = {
                Toast
                    .makeText(
                        context,
                        "CAMARA: PERMISOS CONCEDIDOS",
                        Toast.LENGTH_SHORT)
                    .show()
            },
            onPermissionsFailed = {
                Toast
                    .makeText(
                        context,
                        "CAMARA: PERMISOS DENEGADOS",
                        Toast.LENGTH_SHORT)
                    .show()
            }
        )
    }

    Scaffold(
        topBar = {
            TopBar()
        },
    ) {
        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding(),
                    start = 15.dp,
                    end = 15.dp
                )
            ,
            verticalArrangement = Arrangement.Center
        ) {
            Body()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainPagePreview(){

    TouristAppTheme(
        dynamicColor = false
    ) {
        MainPage(rememberNavController())
    }

}

//-----------------------------------------------------------------[TOP BAR]
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(){

    val context = LocalContext.current

    Column {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.topBarName),
                    fontSize = 25.sp
                )
            },
            navigationIcon = {
                IconButton(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .size(20.dp),
                    onClick = {
                        (context as? Activity)?.finish()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "close app"
                    )
                }
            }
        )
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth()
        )
    }

}

//-----------------------------------------------------------------[BODY MAIN]

@Composable
private fun Body(){
    Column(
        modifier = Modifier
            .padding(top = 15.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(45.dp)
    ) {
        BodyOptions()
    }
}

@Composable
private fun BodyOptions(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        ElevatedCard(
            modifier = Modifier
                .weight(0.5f),
            onClick = {},
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GifImage(
                    url = stringResource(R.string.gifTakePhoto),
                    contentDescription = "take photo",
                    shape = CircleShape
                )
                Text("Tomar foto")
            }

        }

        ElevatedCard(
            modifier = Modifier
                .weight(0.5f),
            onClick = {},
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GifImage(
                    url = stringResource(R.string.gifRecordVideo),
                    contentDescription = "record video",
                    shape = CircleShape
                )
                Text("Grabar video")
            }

        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.Center
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(0.75f),
            onClick = {},
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GifImage(
                    url = stringResource(R.string.gifGallery),
                    contentDescription = "gallery",
                    shape = RectangleShape
                )
                Text("Galeria y multimedia")
            }
        }

    }
}

@Composable
private fun GifImage(
    url: String,
    contentDescription: String,
    shape: Shape = RectangleShape
){

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .decoderFactory(ImageDecoderDecoder.Factory())
            .crossfade(true)
            .diskCachePolicy(CachePolicy.DISABLED)
            .size(Size.ORIGINAL)
            .build(),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(100.dp)
            .clip(shape = shape)
            .border(
                BorderStroke(1.dp, Color.Black),
                shape
            ),
        contentScale = ContentScale.Crop
    )

}