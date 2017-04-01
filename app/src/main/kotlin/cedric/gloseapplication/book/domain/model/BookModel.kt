package cedric.gloseapplication.book.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import cedric.gloseapplication.common.domain.model.AuthorModel

/**
 * Model representing a book coming from gallery WS
 */
class BookModel {

    @SerializedName("authors")
    @Expose
    var authors: List<AuthorModel>? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("document")
    @Expose
    var document: String? = null
    @SerializedName("image")
    @Expose
    var image: String? = null
    @SerializedName("largeImage")
    @Expose
    var largeImage: String? = null
    @SerializedName("mediumImage")
    @Expose
    var mediumImage: String? = null
    @SerializedName("shortTitle")
    @Expose
    var shortTitle: String? = null

}
