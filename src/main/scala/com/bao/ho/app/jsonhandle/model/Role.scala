package com.bao.ho.app.jsonhandle.model
import play.api.libs.json._

sealed trait Role

case object Admin extends Role

case class Contributor(organization: String) extends Role

object Role {


  //  {
  //    override def equals(obj: Any): Boolean = obj match {
  //      case other: Contributor if obj != null => this.organization == other.organization
  //      case _ => false
  //    }
  //  }
  //
  //  object Contributor {
  //    def apply(organization: String): Contributor = new Contributor(organization)
  //
  //    def unapply(contributor: Contributor): Option[(String)] = Some(contributor.organization)
  //  }

  //  implicit object RoleFormat extends Format[Role] {
  //    def reads(json: JsValue) =
  //      json match {
  //        case JsString("SUCCESS") => JsSuccess(SUCCESS)
  //        case JsString("FAILURE") => JsSuccess(FAILURE)
  //        case _ => JsSuccess(FAILURE)
  //      }
  //
  //    def writes(status: ResponseStatus) = JsString(status.toString)
  //  }

  implicit val adminFormat = OFormat[Admin.type](
    Reads[Admin.type] {
      case JsObject(_) => JsSuccess(Admin)
      case _ => JsError("Empty object expected")
    },
    OWrites[Admin.type] { _ => Json.obj() })

  implicit val contributorFormat = Json.format[Contributor]

  implicit val roleFormat: OFormat[Role] = Json.format[Role]

  implicit val cfg = JsonConfiguration(
    // Each JSON objects is marked with the admTpe, ...
    discriminator = "role_name",

    typeNaming = JsonNaming { fullName =>
      fullName.split('.').last.toUpperCase
    })
}
