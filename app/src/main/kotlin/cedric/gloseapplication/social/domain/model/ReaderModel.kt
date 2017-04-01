package cedric.gloseapplication.social.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Model representing a people who is reading books.
 */
class ReaderModel {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("image")
    @Expose
    var image: String? = null
    @SerializedName("avatar")
    @Expose
    var avatar: String? = null
    @SerializedName("avatarLarge")
    @Expose
    var avatarLarge: String? = null
    @SerializedName("location")
    @Expose
    var location: String? = null

}
