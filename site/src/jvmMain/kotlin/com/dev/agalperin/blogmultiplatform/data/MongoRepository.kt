package com.dev.agalperin.blogmultiplatform.data

import com.dev.agalperin.blogmultiplatform.models.User

interface MongoRepository {
    suspend fun checkUserExistence(user: User): User?
    suspend fun checkUserId(id: String): Boolean
}