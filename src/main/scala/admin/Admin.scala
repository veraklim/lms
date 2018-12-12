package admin

import admin.dao.{Course, Group, Teacher, User}

abstract class Admin {
  def createCourse(course: Course): Unit
  def addGroup(group: Group, course: Course): Unit
  def addTeacher(teacher: Teacher, course: Course): Unit
  def addUser(user: User): Unit
}

class AdminImpl() extends Admin{
  def createCourse(course: Course): Unit = {
  }

  def addGroup(group: Group, course: Course): Unit = ???

  def addTeacher(teacher: Teacher, course: Course): Unit = ???

  def addUser(user: User): Unit = ???

}