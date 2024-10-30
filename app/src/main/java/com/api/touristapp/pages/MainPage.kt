package com.api.touristapp.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.api.touristapp.ui.theme.TouristAppTheme

@Composable
fun MainPage(

){

}

@Preview(showBackground = true)
@Composable
private fun MainPagePreview(){

    TouristAppTheme(
        dynamicColor = false
    ) {
        MainPage()
    }

}