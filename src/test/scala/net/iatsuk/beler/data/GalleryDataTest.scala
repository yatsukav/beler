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

import net.iatsuk.beler.data.GalleryData._
import utest._

object GalleryDataTest extends TestSuite {

  override def tests = Tests {
    "Configuration from json without projects" - {
      val json =
        """{
          | "showTags":true,
          | "projects":[]
          |}""".stripMargin
      val parsed = Configuration.fromJson(json)
      assert(
        parsed.showTags,
        parsed.projects.isEmpty
      )
    }

    "Configuration from json with projects" - {
      val json =
        """{
          | "showTags":true,
          | "projects":[
          |   {
          |     "path":"projects/prj1",
          |     "name":"BELeR CV",
          |     "description":"Scala.JS Portfolio gallery",
          |     "thumbnail":"thumbnail.png",
          |     "tags":["scala","web"]
          |   }
          | ]
          |}""".stripMargin
      val parsed = Configuration.fromJson(json)
      assert(
        parsed.showTags,
        parsed.projects.length == 1,
        parsed.projects.head.path == "projects/prj1",
        parsed.projects.head.name == "BELeR CV",
        parsed.projects.head.description == "Scala.JS Portfolio gallery",
        parsed.projects.head.thumbnail == "thumbnail.png",
        parsed.projects.head.tags.toArray.sorted sameElements Array("scala", "web"),
      )
    }

    "ItemMeta from json" - {
      val json =
        """{
          | "path":"projects/prj1",
          | "name":"BELeR CV",
          | "description":"Scala.JS Portfolio gallery",
          | "thumbnail":"thumbnail.png",
          | "tags":["scala","web"]
          |}""".stripMargin
      val parsed = ItemMeta.fromJson(json)
      assert(
        parsed.path == "projects/prj1",
        parsed.name == "BELeR CV",
        parsed.description == "Scala.JS Portfolio gallery",
        parsed.thumbnail == "thumbnail.png",
        parsed.tags.toArray.sorted sameElements Array("scala", "web")
      )
    }
  }

}
