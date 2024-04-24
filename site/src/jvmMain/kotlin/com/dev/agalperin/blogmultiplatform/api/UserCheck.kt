package com.dev.agalperin.blogmultiplatform.api

import com.dev.agalperin.blogmultiplatform.data.MongoDB
import com.dev.agalperin.blogmultiplatform.models.User
import com.dev.agalperin.blogmultiplatform.models.UserWithoutPassword
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.data.getValue
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.security.MessageDigest

@Api(routeOverride = "usercheck")
suspend fun userCheck(context: ApiContext) {
    try {
        val userRequest = context.req.body?.decodeToString()?.let {
            Json.decodeFromString<User>(it)
        }
        val user = userRequest?.let {
            context.data.getValue<MongoDB>().checkUserExistence(
                User(
                    username = it.username,
                    password = hashPassword(it.password)
                )
            )
        }
        if (user != null) {
            context.res.setBodyText(
                Json.encodeToString(
                    UserWithoutPassword(
                        _id = user._id,
                        userName = user.username
                    )
                )
            )
        } else {
            context.res.setBodyText(Json.encodeToString("User doesn't exist"))
        }

    } catch (e: Exception) {
        context.res.setBodyText(Json.encodeToString(e.message))
    }
}

private fun hashPassword(password: String): String {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val hashBytes = messageDigest.digest(password.toByteArray(Charsets.UTF_8))
    val hexString = StringBuffer()

    hashBytes.forEach { byte ->
        hexString.append(String.format("%02x", byte))
    }

    return hexString.toString()
}