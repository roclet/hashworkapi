package controllers.common.demographics

import domain.common.demographics.Title
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.common.demographics.TitleService

import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by hashcode on 2015/11/09.
 */
class TitleController extends Controller{

  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      val entity = Json.fromJson[Title](input).get
      val results = TitleService.saveOrUpdate(entity)
      results.map(result =>
        Ok(Json.toJson(entity)))
  }

}