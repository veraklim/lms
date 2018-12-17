package admin.dao

class Dao() {

  import admin.dao.SQLContext._
  import Tables._

  private def checkCourse(id: Int) = quote {
    courses.filter(_.id == lift(id)).isEmpty
  }
  private def checkGroup(group: Group) = quote {
    groups.filter(_.name == lift(group.name)).isEmpty
  }
  private def checkTeacher(teacher: Teacher) = quote {
    teachers.filter(_.id == lift(teacher.id)).isEmpty
  }

  def createGroup(group: Group): Unit = {
    val newGroup = quote {
      groups.insert(lift(group))
    }
    if (!run(checkCourse(group.courseId))) {
      if (run(checkGroup(group)))
        run(newGroup)
      else println(s"Such group already exists, name - ${group.name}")
    } else println(s"No such course, courseId - ${group.courseId}")
  }

  def createCourse(course: Course): Unit = {
    val newCourse = quote {
      courses.insert(lift(course))
    }
    if (run(checkCourse(course.id)))
      run(newCourse)
    else println(s"Such course already exists, id - ${course.id}, name - ${course.name}")
  }

  def createUser(student: Student): Unit = {
    val newStudent = quote {
      students.insert(lift(student))
    }
    run(newStudent)
  }

  def createUser(teacher: Teacher): Unit = {
    val newTeacher = quote {
      teachers.insert(lift(teacher))
    }
    run(newTeacher)
  }

  def addGroupToCourse(group: Group, course: Course): Unit = {
    val add = quote {
      studycourse.insert(lift(StudyCourse(course.id, group.name)))
    }
    if (!run(checkCourse(course.id))) {
      if (!run(checkGroup(group)))
        run(add)
      else println(s"No such group, name - ${group.name}")
    } else println(s"No such course, id - ${course.id}, name - ${course.name}")
  }

  def addTeacherToCourse(teacher: Teacher, course: Course): Unit = {
    val add = quote {
      teachcourse.insert(lift(TeachCourse(course.id, teacher.id)))
    }
    if (!run(checkCourse(course.id))) {
      if (!run(checkTeacher(teacher)))
        run(add)
      else
        println(
          s"No such teacher, id - ${teacher.id}, name - " + teacher.lastName + " " + teacher.firstName + " " + teacher.middleName
        )
    } else println(s"No such course, id - ${course.id}, name - ${course.name}")
  }

}
