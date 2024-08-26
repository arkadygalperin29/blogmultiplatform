package com.dev.agalperin.blogmultiplatform.pages.admin

import androidx.compose.runtime.Composable
import com.dev.agalperin.blogmultiplatform.util.isUserLoggedIn
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomeScreen() {
    isUserLoggedIn {
        HomePage()
    }
}

@Page
@Composable
fun HomePage() {
    println("Hello world!")
}
