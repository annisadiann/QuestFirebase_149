package com.example.praktikum9.view.controllNavigasi

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.navArgument
import com.example.praktikum9.view.EntrySiswaScreen

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(), modifier:
Modifier
) {
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = DestinationHome.route,
        modifier = Modifier ){
        composable(DestinationHome.route) {
            HomeScreen(navigateToItemEntry = {navController.navigate(DestinatiEntry.route)},
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetail.route}/${it}") })
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = {navController.navigate(DestinasiHome.route)})
        }
    }
}