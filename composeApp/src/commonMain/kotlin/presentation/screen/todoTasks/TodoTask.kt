package presentation.screen.todoTasks

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId


class TodoTask : RealmObject {

    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var titile = ""
    var description = ""
    var favorite = false
    var completed = false

}