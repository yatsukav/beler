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
import org.scalajs.dom.html
import scalatags.JsDom.all._

class Gallery(val conf: GalleryData.Configuration) {

  val sortedTags: List[String] = conf.projects
    .flatMap(_.tags)
    .groupBy(identity)
    .mapValues(_.length)
    .toList
    .sortWith(_._2 >= _._2)
    .map(_._1)

  val tagIndex: Map[String, List[GalleryData.ItemMeta]] = conf.projects
    .flatMap(_.tags)
    .distinct
    .map(tag => (tag, conf.projects.filter(_.tags.contains(tag))))
    .toMap

  def draw(): html.Div = {
    div(
      renderTagCloud(),
      renderThumbnails()
    ).render
  }

  def renderTagCloud(): html.Div = {
    div(
      if (conf.showTags) display.inline else display.none,
      sortedTags.map(div(_))
    ).render
  }

  def renderThumbnails(): html.Div = {
    div(
      conf.projects.map(_.thumbnail).map(url => img(src:=url))
    ).render
  }

}
