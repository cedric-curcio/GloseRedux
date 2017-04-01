package cedric.gloseapplication.book.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import cedric.gloseapplication.common.domain.model.AuthorModel
import cedric.gloseapplication.social.domain.model.ReaderModel

/**
 * Model representing a book with more informations than those in gallery
 */
class BookDetailsModel {

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
    @SerializedName("annotationsCount")
    @Expose
    var annotationsCount: Int? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("isbn")
    @Expose
    var isbn: String? = null
    @SerializedName("likesCount")
    @Expose
    var likesCount: Int? = null
    @SerializedName("rating")
    @Expose
    var rating: Double? = null
    @SerializedName("readersCount")
    @Expose
    var readersCount: Int? = null
    @SerializedName("wishlistCount")
    @Expose
    var wishlistCount: Int? = null
    @SerializedName("video")
    @Expose
    var video: String? = null
    @SerializedName("access")
    @Expose
    var access: Boolean? = null
    @SerializedName("readers")
    @Expose
    var readers: List<ReaderModel>? = null

}
