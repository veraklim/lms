package admin.dao

import java.io.File

import com.almworks.sqlite4java.{SQLiteConnection, SQLiteStatement}

abstract class Dao {
  def createCourse(course: Course): Unit
  def addGroup(group: Group, course: Course): Unit
  def addTeacher(teacher: Teacher, course: Course): Unit
  def addUser(user: User): Unit
}

class DaoImpl() extends Dao{
  def createCourse(course: Course): Unit = {
    val db: SQLiteConnection = new SQLiteConnection(new File("/tmp/database"))
    db.open(true)
    SQLiteStatement st = db.prepare("SELECT order_id FROM orders WHERE quantity >= ?")
    try {
      st.bind(1, minimumQuantity);
      while (st.step()) {
        orders.add(st.columnLong(0));
      }
    } finally {
      st.dispose();
    }
    ...
    db.dispose();
  }

  def addGroup(group: Group, course: Course): Unit = ???

  def addTeacher(teacher: Teacher, course: Course): Unit = ???

  def addUser(user: User): Unit = ???

}
