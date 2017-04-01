package cedric.gloseapplication.common.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Model representing an author
 */
class AuthorModel {

    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

    override fun toString(): String {
        if(name == null ) return "" else return name!!;
    }
}
