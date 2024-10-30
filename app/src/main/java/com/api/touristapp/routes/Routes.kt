package com.api.touristapp.routes

const val ROOT_MAIN = "main"

sealed class Routes(
    val route : String
){
    object MainRoute : Routes(route = ROOT_MAIN)
}