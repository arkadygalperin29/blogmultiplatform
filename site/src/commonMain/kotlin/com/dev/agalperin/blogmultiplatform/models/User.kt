package com.dev.agalperin.blogmultiplatform.models

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class User {
    val _id: String
    val username: String
    val password: String
}