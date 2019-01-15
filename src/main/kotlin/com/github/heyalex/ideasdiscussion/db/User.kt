package com.github.heyalex.ideasdiscussion.db

import org.jetbrains.exposed.sql.Table

object User : Table() {
    val id = long(Field.ID).primaryKey().autoIncrement()
    val userUuid = varchar(Field.USER_UUID, 10).index(Index.USER_UUID, true)

    object Field {
        const val ID = "id"
        const val USER_UUID = "user_uuid"
    }

    object Index {
        const val USER_UUID = "users_user_uuid_index"
    }
}