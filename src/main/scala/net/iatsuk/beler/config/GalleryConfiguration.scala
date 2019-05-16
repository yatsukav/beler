package net.iatsuk.beler.config

import upickle.default.{ReadWriter => RW, macroRW, read}

/**
  * Json settings for main page.
  */
object GalleryConfiguration {

  /**
    * Gallery configuration.
    */
  case class Configuration(path: String, showTags: Boolean, projects: List[ProjectMeta])
  object Configuration {
    implicit val rw: RW[Configuration] = macroRW

    def fromJson(string: String): Configuration = read[Configuration](string)
  }

  /**
    * Part of [[Configuration]]  with description of each project.
    */
  case class ProjectMeta(dir: String, name: String, description: String, thumbnail: String, tags: Array[String])
  object ProjectMeta {
    implicit val rw: RW[ProjectMeta] = macroRW

    def fromJson(string: String): ProjectMeta = read[ProjectMeta](string)
  }

}
