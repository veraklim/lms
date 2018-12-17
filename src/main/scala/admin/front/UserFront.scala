package admin.front

import configuration.Configuration._
import spray.json.DefaultJsonProtocol

trait UserFront {
  val firstName: String
  val middleName: String
  val lastName: String
}

case class StudentFront (
    firstName: String,
    middleName: String,
    lastName: String,
    group: String,
    entryYear: String,
    grade: String,
    form: String,
    basis: String
) extends UserFront {
  require(grades.contains(grade))
  require(forms.contains(form))
  require(basises.contains(basis))
}

object StudentJson extends DefaultJsonProtocol {
  implicit val studentJson = jsonFormat8(StudentFront)
}

case class TeacherFront (firstName: String, middleName: String, lastName: String)
    extends UserFront

object TeacherJson extends DefaultJsonProtocol {
  implicit val teacherJson = jsonFormat3(TeacherFront)
}