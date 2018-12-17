import sbt._

object Dependencies {

  object version {
    val sql = "3.18.0"
    val quill = "2.6.0"
    val slick = "3.2.3"
    val spray = "1.3.5"
  }

  val sql = Seq(
    "org.xerial" % "sqlite-jdbc" % version.sql,
    "io.getquill" %% "quill-jdbc" % version.quill,
    "com.typesafe.slick" %% "slick" % version.slick
  )

  val spray = Seq(
    "io.spray" %%  "spray-json" % version.spray
  )

}
