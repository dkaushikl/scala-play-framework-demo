package models

class Student(id: Int = 0, name: String = "Kaushik") {
  def printName(): Unit = {
    println("my name is %s and id is %d" format(name, id))
  }
}

object Arithmetic {
  def sum(a:Int, b: Int): Int = {
    a + b
  }

  def minus(a:Int, b: Int): Int = {
    a - b
  }

  def multiply(a:Int, b: Int): Int = {
    a * b
  }

  def devide(a:Int, b: Int): Int = {
    a / b
  }
}