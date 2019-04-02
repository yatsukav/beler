ThisBuild / organization := "net.iatsuk"
ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "1.0.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin, WorkbenchPlugin)
  .settings(
    name := "Portfolio",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6",
    libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.7",
  )
