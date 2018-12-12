package admin.dao

trait User {
  val firstName: String
  val middleName: String
  val lastName: String
  val code: String
}

abstract case class Student(
    group: String,
    entryYear: String,
    grade: String,
    form: String,
    basis: String
) extends User

abstract case class Teacher() extends User
