package cedric.gloseapplication.common.domain.redux

import java.io.Serializable

import cedric.gloseapplication.gallery.domain.redux.GalleryReducer
import cedric.gloseapplication.gallery.domain.redux.GalleryState

/**
 * Combine the reducers
 * //todo add a list of reducer + method to register them
 * //but we still have to build manually the new AppState
 * Created by cedric on 31/03/2017.
 */
class AppStateReducer : Reducer<Action, AppState> {
    override fun reduce(action: Action, state: AppState): AppState {
        val galleryState = GalleryReducer.REDUCER.reduce(action, state.mGalleryState)
        //add other reducer here

        //compose the new state in new object
        return AppState(galleryState)
    }
}
