package com.dev.agalperin.blogmultiplatform.styles

import com.dev.agalperin.blogmultiplatform.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.ms

val NavigationItemStyle by ComponentStyle {
    cssRule(suffix = " > #svgParent > #vectorIcon") {
        Modifier
            .transition(
                CSSTransition(
                    property = TransitionProperty.All,
                    duration = 300.ms
                )
            ).styleModifier {
                property("stroke", Theme.White.hex)
            }
    }
    cssRule(suffix = ":hover > #svgParent > #vectorIcon") {
        Modifier
            .styleModifier {
                property("stroke", Theme.Primary.hex)
            }
    }
    cssRule(suffix = " > #navigationText") {
        Modifier
            .transition(
                CSSTransition(
                    property = TransitionProperty.All,
                    duration = 300.ms
                )
            ).color(
                Theme.White.rgb
            )
    }
    cssRule(suffix = ":hover > #navigationText") {
        Modifier.color(
            Theme.Primary.rgb
        )
    }
}