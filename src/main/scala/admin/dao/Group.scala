package admin.dao

import spray.json.DefaultJsonProtocol

case class Group(name: String, depart: String, courseId: Int)

object GroupJson extends DefaultJsonProtocol {
  implicit val groupJson = jsonFormat3(Group)
}
