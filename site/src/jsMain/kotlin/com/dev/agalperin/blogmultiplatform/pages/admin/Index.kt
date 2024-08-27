package com.dev.agalperin.blogmultiplatform.pages.admin

import androidx.compose.runtime.Composable
import com.dev.agalperin.blogmultiplatform.components.SidePanel
import com.dev.agalperin.blogmultiplatform.util.Constants.PAGE_WIDTH
import com.dev.agalperin.blogmultiplatform.util.isUserLoggedIn
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    isUserLoggedIn {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize().maxWidth(PAGE_WIDTH.px),
        contentAlignment = Alignment.TopStart
    ) {
        SidePanel()
    }
}
