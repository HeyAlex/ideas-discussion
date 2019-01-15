package com.github.heyalex.ideasdiscussion.db

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object Idea : Table() {
  val id = long(Field.ID).primaryKey().autoIncrement()
  val userId = long(Field.USER_ID).references(User.id, ReferenceOption.CASCADE).index(Index.USER_ID)
  val ideaName = varchar(Field.IDEA_NAME, 100).index(Index.IDEA_NAME, true)
  val ideaBody = varchar(Field.IDEA_BODY, 100).index(Index.IDEA_BODY)
  val postTime = datetime(Field.POST_TIME).index(Index.POST_TIME)

  object Field {
    const val ID = "id"
    const val USER_ID = "user_id"
    const val IDEA_NAME = "idea_name"
    const val IDEA_BODY = "idea_body"
    const val POST_TIME = "post_time"
  }

  object Index {
    const val USER_ID = "idea_user_id_index"
    const val IDEA_NAME = "idea_name_index"
    const val IDEA_BODY = "idea_body_index"
    const val POST_TIME = "post_time_index"
  }
}