import admin.Admin
import admin.dao._
import admin.dao.CourseJson._
import admin.dao.GroupJson._
import admin.front.StudentJson._
import admin.front.TeacherJson._
import spray.json._
import admin.front.{StudentFront, TeacherFront}

import scala.io.Source
import configuration.Configuration._

object Main extends App{

  val source1 = Source.fromFile(pathCourse).getLines().mkString
  val source2 = Source.fromFile(pathGroup).getLines().mkString
  val source3 = Source.fromFile(pathStudent).getLines().mkString
  val source4 = Source.fromFile(pathTeacher).getLines().mkString

  val course = source1.parseJson.convertTo[Course]
  val group = source2.parseJson.convertTo[Group]
  val frontStudent = source3.parseJson.convertTo[StudentFront]
  val frontTeacher = source4.parseJson.convertTo[TeacherFront]

  val dao = new Dao()
  val admin = new Admin(dao)

  admin.createCourse(course)
  admin.createGroup(group)
  val teacher = admin.addTeacher(frontTeacher)
  val student = admin.addStudent(frontStudent)
  admin.addTeacherToCourse(teacher, course)
  admin.addGroupToCourse(group, course)
}
