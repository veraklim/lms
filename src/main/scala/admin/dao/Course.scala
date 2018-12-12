package admin.dao

case class Course(id: Int, name: String, descr: String, teacher: Option[Teacher])
