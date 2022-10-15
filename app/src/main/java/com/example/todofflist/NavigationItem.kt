package com.example.todofflist

sealed class NavigationItem(val route: String){

    object Home:NavigationItem("Home")
    object Second:NavigationItem("Second")
    object Third:NavigationItem("Third")
    object Fourth:NavigationItem("Fourth/{f_todos}")
    object Fifth:NavigationItem("Fifth/{if_todos}")
}
