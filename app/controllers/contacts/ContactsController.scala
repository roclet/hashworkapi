package controllers.contacts

import domain.contacts.Contacts
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.contacts.ContactsService

import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by hashcode on 2015/11/08.
 */
class ContactsController extends Controller{

  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      val entity = Json.fromJson[Contacts](input).get
      val results = ContactsService.saveOrUpdate(entity)
      results.map(result =>
        Ok(Json.toJson(entity)))
  }

}