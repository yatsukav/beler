/**
  * BELeR - Scala.JS resume/cv/portfolio
  * Copyright (C) 2019  Andrei Iatsuk
  *
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * You should have received a copy of the GNU General Public License
  * along with this program.  If not, see https://www.gnu.org/licenses/.
  */
package net.iatsuk.beler.data

import upickle.default.{ReadWriter => RW, macroRW, read}

/**
  * Json settings for main page.
  */
object GalleryData {

  /**
    * Gallery configuration.
    */
  case class Configuration(showTags: Boolean, projects: List[ItemMeta])
  object Configuration {
    implicit val rw: RW[Configuration] = macroRW

    def fromJson(string: String): Configuration = read[Configuration](string)
  }

  /**
    * Part of [[Configuration]]  with description of each project.
    */
  case class ItemMeta(path: String, name: String, description: String, thumbnail: String, tags: Set[String])
  object ItemMeta {
    implicit val rw: RW[ItemMeta] = macroRW

    def fromJson(string: String): ItemMeta = read[ItemMeta](string)
  }

}
