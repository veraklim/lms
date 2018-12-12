import sbt._

object Dependencies {

  object version {
    val sql = "1.0.392"
  }

  val sql = Seq(
    "com.almworks.sqlite4java" % "sqlite4java" % version.sql,
  )

}
