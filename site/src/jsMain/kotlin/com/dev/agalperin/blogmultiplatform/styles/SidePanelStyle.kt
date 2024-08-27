package com.dev.agalperin.blogmultiplatform.styles

import com.dev.agalperin.blogmultiplatform.models.Theme
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle

val NavigationItemStyle by ComponentStyle {
    cssRule(suffix = ":hover > #svgParent > #vectorIcon") {
        Modifier.styleModifier {
            property("stroke", Theme.Primary.hex)
        }
    }
}