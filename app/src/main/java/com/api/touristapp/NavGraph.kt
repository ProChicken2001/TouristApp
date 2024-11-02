package com.api.touristapp

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.api.touristapp.pages.FotoPage
import com.api.touristapp.pages.GalPage
import com.api.touristapp.pages.MainPage
import com.api.touristapp.pages.MediaViewPage
import com.api.touristapp.pages.VideoPage
import com.api.touristapp.routes.ARG_MVP
import com.api.touristapp.routes.ROOT_MVP
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

        composable(
            route = Routes.VideoRoute.route
        ){
            VideoPage(navController)
        }

        composable(
            route = Routes.GalRoute.route
        ) {
            GalPage(navController)
        }

        composable(
            route = Routes.MediaViewRoute.route
        ) { backStackEntry ->
            val uriString = backStackEntry.arguments?.getString(ARG_MVP) ?: ""
            val uri = Uri.parse(Uri.decode(uriString))
            MediaViewPage(navController, uri)
        }
    }
}