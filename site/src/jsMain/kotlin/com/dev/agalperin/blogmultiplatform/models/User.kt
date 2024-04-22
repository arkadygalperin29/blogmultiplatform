package com.dev.agalperin.blogmultiplatform.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
@Serializable
actual data class User(
    @SerialName(value = "_id")
    actual val id: String = "",
    actual val userName: String = "",
    actual val password: String = ""
)
