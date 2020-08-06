package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class AdvanceController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def index(): Action[AnyContent] =
    Action {
      Ok(views.html.index())
    }
}
