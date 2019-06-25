package com.bao.ho.app.jsonhandle

import java.util.UUID

import com.bao.ho.app.jsonhandle.model.ResponseStatus.SUCCESS
//import com.bao.ho.app.jsonhandle.model.Role.{Admin, Contributor}
import com.bao.ho.app.jsonhandle.model._
import play.api.libs.json._

object JsonHandleExample {

  def main(args: Array[String]): Unit = {
    val q1 = Question(1, UUID.randomUUID(), Admin)
    val q2 = Question(2, UUID.randomUUID(), Contributor("tookitaki"))
    val qs = List[Question](q1, q2)
    val a1: Answer = Answer(1, UUID.randomUUID(), "blue", SUCCESS, qs, q1, Admin)
    println(q1)
    println(q2)
    println(qs)
    println(a1)
    val q1Json = Json.toJson(q1)
    val q2Json = Json.toJson(q2)
    val qsJson = Json.toJson(qs)
    val a1Json = Json.toJson(a1)
    println(q1Json)
    println(q2Json)
    println(qsJson)
    println(a1Json)

    val a1String = a1Json.toString()
    val a2 = Json.parse(a1String)

    val a2Class = a2.as[Answer]

    println(a1String)
    println(a2)
    println(a2Class)

    assert(a2Class.questions == a1.questions)
    assert(a2Class.question == a1.question)
    assert(a2Class.uuid == a1.uuid)
    assert(a2Class.id == a1.id)
    assert(a2Class.status == a1.status)
    assert(a2Class.labelName == a1.labelName)
  }
}
