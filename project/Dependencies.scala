import sbt._

object Dependencies {

  object version {
    val sql = "3.18.0"
    val quill = "2.6.0"
  }

  val sql = Seq(
    "org.xerial" % "sqlite-jdbc" % version.sql,
    "io.getquill" %% "quill-jdbc" % version.quill
  )

}
