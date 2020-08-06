package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def index(): Action[AnyContent] =
    Action { implicit request: Request[AnyContent] =>
      Ok(views.html.index())
    }

  def allUsers(): Action[AnyContent] =
    Action {
      var data: Int = 1000
      data = 10001

      val data1: Int = 1020
      val data2: Int = 10001
      val data3: Int = 10254
      // val can't be changed
      //data1 = 1010

      if (data == data1) {
        // demo of turnary operator in scala
        val isSame: String = if (data == data1) "same" else "not same"
        Ok("Data and data1 are %s... :)".format(isSame))
      }

      findMatchUsingSwitchCase(data, data1, data2, data3)

      //      printNumberUntilValueIs100UsingWhile(data)

      printNumberUntilValueIs100UsingForLoop(data)

      // Higher order functions
      functionExample(25, multiplyBy2)
      // copy-pasted example from javat point site.
      // First it calls function example first and then it calls multiplyby2(25)
      // and eventually it calls 25 * 2 and finally it will return result

      // function composition example
      functionExample(multiplyBy2(25), multiplyBy2)
      // answer of this example is 100

      //

      Ok("This is the final result of this api.")
    }

  def multiplyBy2(a: Int): Int = {
    a * 2
  }

  def functionExample(a: Int, f: Int => AnyVal): Unit = {
    println(f(a)) // Calling that function
  }

  def findMatchUsingSwitchCase(data: Int, data1: Int, data2: Int, data3: Int): Any = {
    data match {
      case data1 => println("Data and data1 are same " + data1)
      case data2 => println("Data and data2 are same " + data2)
      case data3 => println("Data and data3 are same " + data3)
      case _ => println("We are not same bro... :)")
    }
  }

  private def printNumberUntilValueIs100UsingForLoop(data: Int): Any = {
    println("Method is called")
    var data1 = data
    for (a <- 100 until data1) {
      println("data value is " + data1 + "")
      data1 = data1 - 100
    }
  }

  private def printNumberUntilValueIs100UsingWhile(data: Int): Any = {
    var data1 = data
    while (data1 > 100) {
      println("data value is " + data1 + "")
      data1 = data1 - 100
    }
  }
}
