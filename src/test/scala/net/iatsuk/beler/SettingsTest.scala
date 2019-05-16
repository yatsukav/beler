package net.iatsuk.beler

import net.iatsuk.beler.config._
import utest._

object SettingsTest extends TestSuite {

  val tests = Tests {

    "Configuration from json without projects" - {
      val json =
        """{
          | "path":"projects",
          | "showTags":true,
          | "projects":[]
          |}""".stripMargin
      val parsed = GalleryConfiguration.Configuration.fromJson(json)
      assert(
        parsed.path == "projects",
        parsed.showTags,
        parsed.projects.isEmpty
      )
    }

    "Configuration from json with projects" - {
      val json =
        """{
          | "path":"projects",
          | "showTags":true,
          | "projects":[
          |   {
          |     "dir":"prj1",
          |     "name":"BELeR CV",
          |     "description":"Scala.JS Portfolio gallery",
          |     "thumbnail":"thumbnail.png",
          |     "tags":["scala","web"]
          |   }
          | ]
          |}""".stripMargin
      val parsed = GalleryConfiguration.Configuration.fromJson(json)
      assert(
        parsed.path == "projects",
        parsed.showTags,
        parsed.projects.length == 1,
        parsed.projects.head.dir == "prj1",
        parsed.projects.head.name == "BELeR CV",
        parsed.projects.head.description == "Scala.JS Portfolio gallery",
        parsed.projects.head.thumbnail == "thumbnail.png",
        parsed.projects.head.tags sameElements Array("scala", "web"),
      )
    }

    "ProjectMeta from json" - {
      val json =
        """{
          | "dir":"prj1",
          | "name":"BELeR CV",
          | "description":"Scala.JS Portfolio gallery",
          | "thumbnail":"thumbnail.png",
          | "tags":["scala","web"]
          |}""".stripMargin
      val parsed = GalleryConfiguration.ProjectMeta.fromJson(json)
      assert(
        parsed.dir == "prj1",
        parsed.name == "BELeR CV",
        parsed.description == "Scala.JS Portfolio gallery",
        parsed.thumbnail == "thumbnail.png",
        parsed.tags sameElements Array("scala", "web")
      )
    }

    "ProjectData from json" - {
      val json =
        """{
          | "content":"file.html",
          | "images":["1.jpg","2.jpg"],
          | "thumbnails":["1.m.jpg","2.m.jpg"]
          |}""".stripMargin
      val parsed = ProjectConfiguration.ProjectData.fromJson(json)
      assert(
        parsed.content == "file.html",
        parsed.images sameElements Array("1.jpg", "2.jpg"),
        parsed.thumbnails sameElements Array("1.m.jpg", "2.m.jpg")
      )
    }

  }

}
