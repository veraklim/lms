package admin.dao

trait User {
  val id: String
  val firstName: String
  val middleName: String
  val lastName: String
  val code: Int
}

case class Student(
    id: String,
    firstName: String,
    middleName: String,
    lastName: String,
    code: Int,
    groupName: String,
    entryYear: String,
    grade: String,
    form: String,
    basis: String
) extends User

case class Teacher(id: String, firstName: String, middleName: String, lastName: String, code: Int)
    extends User
