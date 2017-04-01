package cedric.gloseapplication.common.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import cedric.gloseapplication.book.domain.model.BookModel

/**
 * Model representing a module
 */
class ModuleModel {

    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("title")
    @Expose
    var title: Any? = null
    @SerializedName("seeAll")
    @Expose
    var seeAll: Any? = null
    @SerializedName("books")
    @Expose
    var books: List<BookModel>? = null

}
