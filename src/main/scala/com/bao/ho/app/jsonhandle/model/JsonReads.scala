package com.bao.ho.app.jsonhandle.model

import java.util.UUID

import play.api.libs.json.{Reads, __}

object JsonReads {
  lazy val idReads: Reads[Int] = (__ \ "id").read[Int]
  lazy val labelNameReads: Reads[String] = (__ \ "label_name").read[String]
  lazy val statusReads: Reads[ResponseStatus] = (__ \ "status").read[ResponseStatus]
  lazy val uuidReads: Reads[UUID] = (__ \ "uuid").read[UUID]
  lazy val questionReads: Reads[Question] = (__ \ "question").read[Question]
  lazy val questionsReads: Reads[List[Question]] = (__ \ "questions").read[List[Question]]
  lazy val roleReads: Reads[Role] = (__ \ "role").read[Role]
  lazy val rolesReads: Reads[List[Role]] = (__ \ "roles").read[List[Role]]
}
