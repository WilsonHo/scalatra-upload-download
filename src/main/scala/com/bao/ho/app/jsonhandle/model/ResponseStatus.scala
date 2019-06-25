package com.bao.ho.app.jsonhandle.model

import play.api.libs.json.{Format, JsString, JsSuccess, JsValue}


sealed trait ResponseStatus

object ResponseStatus {

  case object SUCCESS extends ResponseStatus

  case object FAILURE extends ResponseStatus

  implicit object ResponsePayloadStatusFormat extends Format[ResponseStatus] {
    def reads(json: JsValue) =
      json match {
        case JsString("SUCCESS") => JsSuccess(SUCCESS)
        case JsString("FAILURE") => JsSuccess(FAILURE)
        case _ => JsSuccess(FAILURE)
      }

    def writes(status: ResponseStatus) = JsString(status.toString)
  }

}