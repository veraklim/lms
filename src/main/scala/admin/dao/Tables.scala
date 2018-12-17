package admin.dao

import admin.dao.SQLContext.{querySchema, quote}

object Tables {
  val groups = quote {
    querySchema[Group]("Groups", _.name -> "name", _.depart -> "depart", _.courseId -> "course")
  }

  val courses = quote {
    querySchema[Course]("Courses", _.name -> "name", _.descrp -> "descrp", _.id -> "id")
  }

  val students = quote {
    querySchema[Student](
      "Students",
      _.id -> "id",
      _.firstName -> "firstname",
      _.middleName -> "middlename",
      _.lastName -> "lastname",
      _.code -> "code",
      _.groupName -> "groupname",
      _.entryYear -> "entryyear",
      _.grade -> "grade",
      _.form -> "form",
      _.basis -> "basis"
    )
  }

  val teachers = quote {
    querySchema[Teacher](
      "Teachers",
      _.id -> "id",
      _.firstName -> "firstname",
      _.middleName -> "middlename",
      _.lastName -> "lastname",
      _.code -> "code"
    )
  }

  val studycourse = quote {
    querySchema[StudyCourse]("study_course", _.courseId -> "courseid", _.groupName -> "groupname")
  }

  val teachcourse = quote {
    querySchema[TeachCourse]("teach_course", _.courseId -> "courseid", _.teacherId -> "teacherid")
  }
}
