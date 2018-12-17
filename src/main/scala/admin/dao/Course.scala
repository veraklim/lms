package admin.dao

import spray.json.DefaultJsonProtocol

case class Course(id: Int, name: String, descrp: String)

object CourseJson extends DefaultJsonProtocol {
  implicit val courseJson = jsonFormat3(Course)
}