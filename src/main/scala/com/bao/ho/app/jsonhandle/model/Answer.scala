package com.bao.ho.app.jsonhandle.model

import java.util.UUID

import play.api.libs.functional.syntax._
import play.api.libs.json._


case class Answer(id: Int,
                  uuid: UUID,
                  labelName: String,
                  status: ResponseStatus,
                  questions: List[Question],
                  question: Question,
                  role: Role
                 )

object Answer {

  val answerReads: Reads[Answer] = (
    JsonReads.idReads and
      JsonReads.uuidReads and
      JsonReads.labelNameReads and
      JsonReads.statusReads and
      JsonReads.questionsReads and
      JsonReads.questionReads and
      JsonReads.roleReads
    ) (Answer.apply _)

  val answerWrites: Writes[Answer] = (
    JsonWrites.idWrites and
      JsonWrites.uuidWrites and
      JsonWrites.labelNameWrites and
      JsonWrites.statusWrites and
      JsonWrites.questionsWrites and
      JsonWrites.questionWrites and
      JsonWrites.roleWrites
    ) (unlift(Answer.unapply))

  implicit val answerFormat: Format[Answer] =
    Format(answerReads, answerWrites)
}

