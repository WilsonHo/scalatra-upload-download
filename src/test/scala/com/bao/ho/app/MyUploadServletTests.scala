package com.bao.ho.app

import org.scalatra.test.scalatest._

class MyUploadServletTests extends ScalatraFunSuite {

  addServlet(classOf[MyUploadServlet], "/*")

  test("GET / on com.bao.ho.app.MyScalatraServlet should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
