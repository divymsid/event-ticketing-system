
ThisBuild / scalaVersion := "3.3.6"

ThisBuild / version := "1.0.0"

ThisBuild / organization := "com.eventticketing"

lazy val root = (project in file("."))
  .settings(
    name := "event-ticketing-system",
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.2" % Test
  )