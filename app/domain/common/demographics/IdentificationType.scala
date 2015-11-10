package domain.common.demographics

/**
 * Created by hashcode on 2015/11/07.
 */
import play.api.libs.json.Json

case class IdentificationType(id: String, name: String)
object IdentificationType {
  implicit val idFmt = Json.format[IdentificationType]
}