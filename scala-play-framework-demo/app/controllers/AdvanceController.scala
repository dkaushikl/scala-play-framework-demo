package controllers

import javax.inject._
import models.{Arithmetic, Student}
import play.api.mvc._

@Singleton
class AdvanceController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def index(): Action[AnyContent] =
    Action {
      // anonymous function it used when you don't want to use it later
      def result1: (Int, Int) => Int = (a: Int, b: Int) => a + b // Anonymous function by using => (rocket)
      def result2: (Int, Int) => Int = (_: Int) + (_: Int) // Anonymous function by using _ (underscore) wild card

      println("This is the result of result1 function " + result1(10, 10))
      println("This is the result of result2 function " + result2(10, 10))

      // functin currying example
      println(add(10)(10))

      val addIt = add(10) _
      println("10 + 10 = " + addIt(10))

      println(complexCalculation(100)(100)(10)(10))

      println("-------------------------------------")
      val sumValue = complexCalculation(100)(100) _
      val multiplyValue = sumValue(100)
      val devideValue = multiplyValue(10)
      println(devideValue)
      // answer will be 20

      // Function with Variable Length Parameters
      println(addVariableLength(1,2,3,4,5,6,7,8,9))

      // class and object example
      val s = new Student()
      s.printName()

      val s2 = new Student(2, "Mohil")
      s2.printName()

      // Scala Singleton Object -> For c# developer it is Static class
      println(Arithmetic.sum(5, 10))

      // scala case classes and case object -> It's a constant class
      println("a = " +  CaseClass(10,10).a)


      Ok(views.html.index())
    }

  case class CaseClass(a:Int, b:Int)

  def addVariableLength(args: Int*): Int = {
    var sum = 0
    println(args)
    for(a <- args) sum+=a
    sum
  }


  def add(a: Int)(b: Int): Int = a + b

  def complexCalculation(a: Int)(b: Int)(c: Int)(d: Int): Int = (d * (a + b)) / c

}
