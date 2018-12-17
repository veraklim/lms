package configuration

import com.typesafe.config.ConfigFactory

object Configuration {
  val grades = ConfigFactory.load().getStringList("requirements.grade")
  val forms = ConfigFactory.load().getStringList("requirements.form")
  val basises = ConfigFactory.load().getStringList("requirements.basis")
  val pathCourse = ConfigFactory.load().getString("requests.course")
  val pathGroup = ConfigFactory.load().getString("requests.group")
  val pathStudent = ConfigFactory.load().getString("requests.student")
  val pathTeacher = ConfigFactory.load().getString("requests.teacher")
}
