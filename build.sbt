name := "lms"

version := "0.1"

scalaVersion := "2.12.7"

lazy val cabinet = (project in file("."))
  .settings(
  libraryDependencies ++= Dependencies.sql
  )
  .settings(
    libraryDependencies ++= Dependencies.spray
  )