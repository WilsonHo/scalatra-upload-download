package com.bao.ho.app.jsonhandle.model

import java.util.UUID

import play.api.libs.json.{OWrites, __}

object JsonWrites {
  lazy val idWrites: OWrites[Int] = (__ \ "id").write[Int]
  lazy val labelNameWrites: OWrites[String] = (__ \ "label_name").write[String]
  lazy val statusWrites: OWrites[ResponseStatus] = (__ \ "status").write[ResponseStatus]
  lazy val uuidWrites: OWrites[UUID] = (__ \ "uuid").write[UUID]
  lazy val questionWrites: OWrites[Question] = (__ \ "question").write[Question]
  lazy val questionsWrites: OWrites[List[Question]] = (__ \ "questions").write[List[Question]]
  lazy val rolesWrites: OWrites[List[Role]] = (__ \ "roles").write[List[Role]]
  lazy val roleWrites: OWrites[Role] = (__ \ "role").write[Role]
}