package com.bao.ho.app

import java.io.{File, FileInputStream, InputStream}

import org.scalatra._
import org.scalatra.servlet.{FileUploadSupport, MultipartConfig, SizeConstraintExceededException}

import scala.xml.Node

class MyUploadServlet extends ScalatraServlet
  with FileUploadSupport
  with FlashMapSupport {

  configureMultipartHandling(MultipartConfig(maxFileSize = Some(3 * 1024 * 1024)))

  def displayPage(content: Seq[Node]) = Template.page("File upload example", content, url(_))

  error {
    case e: SizeConstraintExceededException =>
      RequestEntityTooLarge(displayPage(
        <p>The file you uploaded exceeded the 3 MB limit.</p>))
  }

  get("/") {
    displayPage(
      <form action={url("/upload")} method="post" enctype="multipart/form-data">
        <p>File to upload:
          <input type="file" name="file_upload"/>
        </p>
        <p>
          <input type="submit" value="Upload"/>
        </p>
      </form>
        <p>
          Upload a file using the above form. After you hit "Upload"
          the file will be uploaded and your browser will start
          downloading it.
        </p>

        <p>
          The maximum file size accepted is 3 MB.
        </p>)
  }

  post("/upload") {
    fileParams.get("file_upload") match {
      case Some(file) =>

        val fileName = file.getName.getBytes
        val uploadName = new String(fileName, "utf-8")
        println(uploadName)
        val writeFile = new File(uploadName)
        file.write(writeFile)
        Ok(uploadName)
      //          file.get(), Map(
      //          "Content-Type" -> (file.contentType.getOrElse("application/octet-stream")),
      //          "Content-Disposition" -> ("attachment; filename=\"" + file.name + "\"")
      //        )
      //    )

      case None =>
        BadRequest(displayPage(
          <p>
            Hey! You forgot to select a file.
          </p>))
    }
  }

  get("/download") {
    val fileName = params("file_name")
    val file = new File(fileName)
    val inputStream: InputStream = new FileInputStream(file)
    Ok(inputStream, Map(
      "Content-Type" -> "application/octet-stream",
      "Content-Disposition" -> ("attachment; filename=\"" + fileName + "\"")
    )
    )
  }


  //  post("/upload") {
  //    fileParams.get("file") match {
  //      case Some(file) =>
  //
  //        Ok(file.get(), Map(
  //          "Content-Type"        -> (file.contentType.getOrElse("application/octet-stream")),
  //          "Content-Disposition" -> ("attachment; filename=\"" + file.name + "\"")
  //        ))
  //
  //      case None =>
  //        BadRequest(displayPage(
  //          <p>
  //            Hey! You forgot to select a file.
  //          </p>))
  //    }
  //  }
}
