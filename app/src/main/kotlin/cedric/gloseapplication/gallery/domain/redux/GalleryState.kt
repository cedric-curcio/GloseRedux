package cedric.gloseapplication.gallery.domain.redux

import java.io.Serializable

import cedric.gloseapplication.book.domain.model.BookDetailsModel
import io.reactivex.Observable
import io.reactivex.Single

/**
 * State for gallery feature

 * Created by cedric on 29/03/2017.
 */
class GalleryState : Serializable {
    //todo manage error state

    var books: List<BookDetailsModel>? = null
    var isLoadingGallery: Boolean = false
}
