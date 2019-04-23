package net.iatsuk.beler

object Settings {

  case class Configuration(path: String, showTags: Boolean, projects: List[ProjectMeta])

  case class ProjectMeta(dir: String, name: String, description: String, thumbnail: String, tags: Array[String])

  case class ProjectData(content: String, images: Array[String], thumbnails: Array[String])

}