package com.dev.agalperin.blogmultiplatform.models

import kotlinx.serialization.Serializable
import org.litote.kmongo.id.ObjectIdGenerator

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
@Serializable
actual data class User(
    actual val _id: String = ObjectIdGenerator.newObjectId<String>().id.toHexString(),
    actual val username: String = "",
    actual val password: String = ""
)
