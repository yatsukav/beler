package net.iatsuk.beler

import upickle.default.{ReadWriter => RW, macroRW, read}

object Settings {

  case class Configuration(path: String, showTags: Boolean, projects: List[ProjectMeta])
  object Configuration {
    implicit val rw: RW[Configuration] = macroRW

    def fromJson(string: String): Configuration = read[Configuration](string)
  }

  case class ProjectMeta(dir: String, name: String, description: String, thumbnail: String, tags: Array[String])
  object ProjectMeta {
    implicit val rw: RW[ProjectMeta] = macroRW

    def fromJson(string: String): ProjectMeta = read[ProjectMeta](string)
  }

  case class ProjectData(content: String, images: Array[String], thumbnails: Array[String])
  object ProjectData {
    implicit val rw: RW[ProjectData] = macroRW

    def fromJson(string: String): ProjectData = read[ProjectData](string)
  }

}
