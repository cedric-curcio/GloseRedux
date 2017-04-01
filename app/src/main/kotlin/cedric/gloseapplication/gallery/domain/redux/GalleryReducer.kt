package cedric.gloseapplication.gallery.domain.redux


import cedric.gloseapplication.common.domain.redux.Action
import cedric.gloseapplication.common.domain.redux.Reducer

/**
 * Created by cedric on 29/03/2017.
 */
object GalleryReducer {

    val REDUCER: Reducer<Action, GalleryState> = object : Reducer<Action, GalleryState> {

        override fun reduce(action: Action, currentState: GalleryState): GalleryState {
            when (action.type) {
                GalleryActions.LOAD_BOOK -> {
                    currentState.isLoadingGallery = true
                    return currentState
                }

                GalleryActions.LOAD_BOOK_FINISHED -> {
                    currentState.isLoadingGallery = false
                    val galleryAction = action as GalleryActions.LoadBookFinishedAction
                    currentState.books = galleryAction.mBooks

                    return currentState
                }
            }
            return currentState
        }
    }
}

