package controllers.common.demographics

import domain.common.demographics.MaritalStatus
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.common.demographics.{GenderService, MaritalStatusService}

import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by hashcode on 2015/11/09.
 */
class MaritalStatusController extends Controller{

  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      val entity = Json.fromJson[MaritalStatus](input).get
      val results = MaritalStatusService.saveOrUpdate(entity)
      results.map(result =>
        Ok(Json.toJson(entity)))
  }

  def getById(id: String) = Action.async {
    request =>
      MaritalStatusService.get(id) map (result =>
        Ok(Json.toJson(result)))
  }

  def getAll = Action.async {
    request =>
      MaritalStatusService.getAll map (result =>
        Ok(Json.toJson(result)))
  }

}
