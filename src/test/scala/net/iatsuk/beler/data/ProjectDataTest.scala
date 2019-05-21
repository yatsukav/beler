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

import utest._

object ProjectDataTest extends TestSuite {

  override def tests: Tests = Tests {

    "ProjectData from json" - {
      val json =
        """{
          | "content":"file.html",
          | "images":["1.jpg","2.jpg"],
          | "thumbnails":["1.m.jpg","2.m.jpg"]
          |}""".stripMargin
      val parsed = ProjectData.ProjectConfiguration.fromJson(json)
      assert(
        parsed.content == "file.html",
        parsed.images sameElements Array("1.jpg", "2.jpg"),
        parsed.thumbnails sameElements Array("1.m.jpg", "2.m.jpg")
      )
    }

  }

}
