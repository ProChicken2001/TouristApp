package com.api.touristapp.routes

const val ROOT_MAIN = "main"
const val ROOT_FOTO = "foto"

sealed class Routes(
    val route : String
){
    object MainRoute: Routes(route = ROOT_MAIN)
    object FotoRoute: Routes(route = ROOT_FOTO)
}