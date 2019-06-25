package com.bao.ho.app.jsonhandle.model

import java.util.UUID

import play.api.libs.functional.syntax.{unlift, _}
import play.api.libs.json.{Format, Reads, Writes}

case class Question(id: Int,
                    uuid: UUID)

object Question {
  val questionReads: Reads[Question] = (
    JsonReads.idReads and
      JsonReads.uuidReads
    ) (Question.apply _)

  val questionWrites: Writes[Question] = (
    JsonWrites.idWrites and
      JsonWrites.uuidWrites
    ) (unlift(Question.unapply))

  implicit val answerFormat: Format[Question] =
    Format(questionReads, questionWrites)
}

