package com.bao.ho.app

import org.scalatra.servlet.FileUploadSupport
import org.scalatra.{FlashMapSupport, ScalatraServlet}

class ExceptionHandleController extends ScalatraServlet
  with FileUploadSupport
  with FlashMapSupport {

  get("/IllegalAccessException") {
    throw new IllegalAccessException("Demo 1")
  }

  get("/NullPointerException") {
    throw new NullPointerException("Demo 2")
  }

  error {
    case e: IllegalAccessException => halt(500, s"IllegalAccessException 500 ${e}")
    case e: NullPointerException => halt(500, s"NullPointerException 500 ${e}")
  }
}
