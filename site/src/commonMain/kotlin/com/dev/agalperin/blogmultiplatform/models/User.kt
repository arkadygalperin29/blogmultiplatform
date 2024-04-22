package com.dev.agalperin.blogmultiplatform.models

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class User {
    val id: String
    val userName: String
    val password: String
}