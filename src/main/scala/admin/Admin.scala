package admin

import admin.dao._
import admin.front.{StudentFront, TeacherFront}

class Admin(dao: Dao) {

  private def generateCode(): Int = {
    val rnd = scala.util.Random
    100000 + rnd.nextInt(900000)
  }

  def createCourse(course: Course): Unit =
    dao.createCourse(course)

  def createGroup(group: Group): Unit =
    dao.createGroup(group)

  def addGroupToCourse(group: Group, course: Course): Unit =
    dao.addGroupToCourse(group, course)

  def addTeacherToCourse(teacher: Teacher, course: Course): Unit =
    dao.addTeacherToCourse(teacher, course)

  def addTeacher(teacher: TeacherFront): Teacher = {
    val id = java.util.UUID.randomUUID().toString
    val code = generateCode()
    val newTeacher = Teacher(id, teacher.firstName, teacher.middleName, teacher.lastName, code)
    dao.createUser(newTeacher)
    newTeacher
  }

  def addStudent(student: StudentFront): Student = {
    val id = java.util.UUID.randomUUID().toString
    val code = generateCode()
    val newStudent = Student(
      id,
      student.firstName,
      student.middleName,
      student.lastName,
      code,
      student.group,
      student.entryYear,
      student.grade,
      student.form,
      student.basis
    )
    dao.createUser(newStudent)
    newStudent
  }

}
