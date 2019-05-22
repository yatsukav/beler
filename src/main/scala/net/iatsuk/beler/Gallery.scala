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
import org.scalajs.dom
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

  val thumbnails: Map[GalleryData.ItemMeta, html.Div] = conf.projects.map(prj => prj -> renderThumbnail(prj)).toMap

  def draw(): html.Div = {
    div(
      renderTagCloud(),
      renderThumbnails()
    ).render
  }

  def renderTagCloud(): html.Div = {
    val result = div(
      if (conf.showTags) display.inline else display.none,
      sortedTags.map { tagName =>
        div(
          p(tagName),
          onmousedown := { e: dom.MouseEvent => tagIndex.getOrElse(tagName, List.empty)
              .map(meta => thumbnails.get(meta))
              .foreach(divOption => divOption.foreach(e => e.style.display = display.none.v))
          }
        )
      }
    ).render

    result
  }

  def renderThumbnails(): html.Div = {
    div(
      thumbnails.values.toSeq
    ).render
  }

  def renderThumbnail(project: GalleryData.ItemMeta): html.Div = {
    val result = div(
      img(src := project.thumbnail),
      p(project.name),
      p(project.description)
    ).render
    result.onmousedown = (e: dom.MouseEvent) => println(project.name)
    result
  }

}
