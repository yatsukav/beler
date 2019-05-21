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

import net.iatsuk.beler.data.GalleryData
import net.iatsuk.beler.network.AjaxUtils
import org.scalajs.dom.html

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("BELeR")
object BELeR {

  @JSExport
  def addGallery(target: html.Div, settingsJsonFile: String): Unit = {
    // get conf by ajax
    val conf = AjaxUtils.syncGetText(settingsJsonFile)
      .map(GalleryData.Configuration.fromJson)
      .getOrElse(GalleryData.Configuration(showTags = false, projects = List.empty))
    // initialize gallery from conf
    val gallery = new Gallery(conf)
    // apply to html dom
    target.appendChild(gallery.draw())
    // you are beauty!
  }

}
