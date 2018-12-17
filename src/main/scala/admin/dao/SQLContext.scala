package admin.dao

import io.getquill.{SnakeCase, SqliteJdbcContext}

object SQLContext extends SqliteJdbcContext(SnakeCase, "ctx")
