package com.dev.agalperin.blogmultiplatform.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.litote.kmongo.id.ObjectIdGenerator

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
@Serializable
actual data class UserWithoutPassword(
    actual val _id: String = ObjectIdGenerator.newObjectId<String>().id.toHexString(),
    actual val userName: String = "",
)
