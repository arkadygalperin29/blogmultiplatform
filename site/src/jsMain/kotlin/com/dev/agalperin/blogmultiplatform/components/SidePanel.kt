package com.dev.agalperin.blogmultiplatform.components

import androidx.compose.runtime.Composable
import com.dev.agalperin.blogmultiplatform.models.Theme
import com.dev.agalperin.blogmultiplatform.navigation.Screen
import com.dev.agalperin.blogmultiplatform.styles.NavigationItemStyle
import com.dev.agalperin.blogmultiplatform.util.Constants.FONT_FAMILY
import com.dev.agalperin.blogmultiplatform.util.Constants.SIDE_PANEL_WIDTH
import com.dev.agalperin.blogmultiplatform.util.Id
import com.dev.agalperin.blogmultiplatform.util.Res
import com.dev.agalperin.blogmultiplatform.util.logout
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

@Composable
fun SidePanel() {
    val context = rememberPageContext()

    val navItems = listOf(
        NavItemData(
            title = "Home",
            isSelected = context.route.path == Screen.AdminHome.route,
            icon = Res.PathIcon.home,
            action = {
                context.router.navigateTo(Screen.AdminHome.route)
            }),
        NavItemData(
            title = "Create Post",
            isSelected = context.route.path == Screen.AdminCreate.route,
            icon = Res.PathIcon.create,
            action = {
                context.router.navigateTo(Screen.AdminCreate.route)
            }),
        NavItemData(
            title = "My Posts",
            isSelected = context.route.path == Screen.AdminPosts.route,
            icon = Res.PathIcon.posts,
            action = {
                context.router.navigateTo(Screen.AdminPosts.route)
            }),
        NavItemData(title = "Logout", icon = Res.PathIcon.logout, action = {
            logout()
            context.router.navigateTo(Screen.AdminLogin.route)
        }
        )
    )


    Column(
        modifier = Modifier.padding(leftRight = 40.px, topBottom = 40.px)
            .width(SIDE_PANEL_WIDTH.px)
            .height(100.vh)
            .position(Position.Fixed)
            .backgroundColor(Theme.Secondary.rgb)
            .zIndex(9)
    ) {
        Image(
            modifier = Modifier.margin(bottom = 60.px),
            src = Res.Image.logo,
            description = "Logo Image"
        )
        SpanText(
            modifier = Modifier
                .margin(bottom = 30.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(14.px)
                .color(Theme.HalfWhite.rgb),
            text = "Dashboard"
        )
        navItems.forEach { navItem ->
            NavigationItem(
                modifier = Modifier.margin(bottom = 24.px),
                selected = navItem.isSelected,
                title = navItem.title,
                icon = navItem.icon,
                onClick = navItem.action
            )
        }
    }
}

@Composable
fun NavigationItem(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    title: String,
    icon: String,
    onClick: () -> Unit
) {
    Row(
        modifier = NavigationItemStyle.toModifier()
            .then(modifier)
            .cursor(Cursor.Pointer)
            .onClick { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        VectorIcon(
            modifier = Modifier.margin(right = 10.px),
            selected = selected,
            pathData = icon
        )
        SpanText(
            modifier = Modifier
                .id(Id.navigationText)
                .fontFamily(FONT_FAMILY)
                .fontSize(16.px)
                .thenIf(
                    condition = selected,
                    lazyProduce = {
                        Modifier.color(Theme.Primary.rgb)
                    }
                ),
            text = title
        )
    }
}

@Composable
fun VectorIcon(
    modifier: Modifier = Modifier,
    selected: Boolean,
    pathData: String,
) {
    Svg(
        attrs = modifier
            .id(Id.svgParent)
            .width(24.px)
            .height(24.px)
            .toAttrs {
                attr("viewbox", "0 0 24 24")
                attr("fill", "none")
            }
    ) {
        Path(
            attrs = Modifier
                .id(Id.vectorIcon)
                .thenIf(
                    condition = selected,
                    other = Modifier.styleModifier {
                        property("stroke", Theme.Primary.hex)
                    }
                )
                .toAttrs {
                    attr("d", pathData)
                    attr("stroke-width", "2")
                    attr("stroke-linecap", "round")
                    attr("stroke-linejoin", "round")
                }
        )
    }
}


data class NavItemData(
    val title: String,
    val icon: String,
    val isSelected: Boolean = false,
    val action: () -> Unit = {}
)