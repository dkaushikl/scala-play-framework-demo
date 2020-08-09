package services

import com.google.inject.Inject
import models.{Todo, TodoList}

class TodoService @Inject() (items: TodoList) {

  def addItem(item: Todo): Any = {
    items.add(item)
  }

  def deleteItem(id: Long): Any = {
    items.delete(id)
  }

  def updateItem(item: Todo): Any = {
    items.update(item)
  }

  def getItem(id: Long): Any = {
    items.get(id)
  }

  def listAllItems: Any = {
    items.listAll
  }
}