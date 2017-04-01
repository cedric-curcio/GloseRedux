package cedric.gloseapplication.gallery.domain.redux


import cedric.gloseapplication.book.domain.model.BookDetailsModel
import cedric.gloseapplication.common.domain.redux.Action

/**
 * Actions interacting with the gallery view.
 *
 *
 * Created by cedric on 29/03/2017.
 */
object GalleryActions {

    //action to init the loading, it will set the state telling the view has progress
    val LOAD_BOOK = "LOAD_BOOKS_STARTED"
    class LoadBookAction : Action {
        override val type: String = LOAD_BOOK;
        var isLoading: Boolean = false

    }

    //action to finish the loading succesfully, it will set the state the view is filled with books
    val LOAD_BOOK_FINISHED = "LOAD_BOOKS_FINISHED"

    class LoadBookFinishedAction : Action {
        override val type: String = LOAD_BOOK_FINISHED;
        var mBooks: List<BookDetailsModel>? = null
    }

    //do an action to show error if book loading failed
}
