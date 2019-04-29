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
package net.iatsuk.beler

import org.scalajs.dom
import org.scalajs.dom.html
import scalatags.JsDom.all._

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("BELeR")
object BELeR {

  @JSExport
  def addPortfolio(target: html.Div, settingsJsonFile: String): Unit = {
    target.appendChild(
      div(
        h1("Hello World")
      ).render
    )
  }

  def getProjectMeta(settingsJsonFile: String, syncGet: String => Option[String]): Option[Settings.ProjectMeta] = {
    syncGet(settingsJsonFile).map(Settings.ProjectMeta.fromJson)
  }

  def ajaxGet(url: String, async: Boolean = true): Option[String] = {
    var result: Option[String] = None
    val xhr = new dom.XMLHttpRequest()
    xhr.open("GET", url, async = async)
    xhr.onload = (e: dom.Event) => {
      if (xhr.status == 200) {
        result = Some(xhr.responseText)
      }
    }
    xhr.send()
    result
  }

  def ajaxSyncGet(url: String): Option[String] = ajaxGet(url, async = false)

}
