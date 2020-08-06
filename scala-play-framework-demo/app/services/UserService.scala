package services

import models.User

class UserService {
  var userLists: Seq[User] = Nil

  object Crud {
    def getAll: Seq[User] = userLists
  }

}
