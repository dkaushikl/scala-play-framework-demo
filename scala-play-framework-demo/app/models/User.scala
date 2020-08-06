package models

import java.util.UUID

case class User(
                 firstName: String,
                 lastName: String,
                 email: String,
                 password: String,
                 city: Option[String],
                 state: Option[String],
                 country: Option[String],
                 _id: Option[UUID]
               )