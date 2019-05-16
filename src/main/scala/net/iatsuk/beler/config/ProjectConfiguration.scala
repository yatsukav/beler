package net.iatsuk.beler.config

import upickle.default.{ReadWriter => RW, macroRW, read}

/**
  * Json settings for project page.
  */
object ProjectConfiguration {

  case class ProjectData(content: String, images: Array[String], thumbnails: Array[String])
  object ProjectData {
    implicit val rw: RW[ProjectData] = macroRW

    def fromJson(string: String): ProjectData = read[ProjectData](string)
  }

}
