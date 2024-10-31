package com.api.touristapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.api.touristapp.pages.FotoPage
import com.api.touristapp.pages.MainPage
import com.api.touristapp.routes.Routes

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Routes.MainRoute.route
    ){
        composable(
            route = Routes.MainRoute.route
        ) {
            MainPage(navController)
        }

        composable(
            route = Routes.FotoRoute.route
        ){
            FotoPage(navController)
        }
    }
}