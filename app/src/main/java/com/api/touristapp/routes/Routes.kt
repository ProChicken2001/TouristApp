package com.api.touristapp.routes

const val ROOT_MAIN = "main"
const val ROOT_FOTO = "foto"
const val ROOT_VIDEO = "video"

sealed class Routes(
    val route : String
){
    object MainRoute: Routes(route = ROOT_MAIN)
    object FotoRoute: Routes(route = ROOT_FOTO)
    object VideoRoute: Routes(route = ROOT_VIDEO)
}