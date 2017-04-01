package cedric.gloseapplication.gallery.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import cedric.gloseapplication.book.domain.model.BookModel
import cedric.gloseapplication.common.domain.model.ModuleModel

/**
 * Model representing a gallery of book, filled by retrofit when ws call.
 * Book are stored in the module "books-vertical"
 */
class BookGalleryModel {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("modules")
    @Expose
    var modules: List<ModuleModel>? = null

    val books: List<BookModel>?
        get() {
            if (modules != null) {
                for (module in modules!!) {
                    if (module.type.equals(BOOKS_VERTICAL, ignoreCase = true)) {
                        return module.books
                    }
                }
            }
            return null
        }

    companion object {

        val BOOKS_VERTICAL = "books-vertical"
    }

}
