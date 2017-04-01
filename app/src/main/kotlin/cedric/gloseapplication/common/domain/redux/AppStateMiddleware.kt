package cedric.gloseapplication.common.domain.redux

import cedric.gloseapplication.gallery.domain.redux.GalleryWsMiddleware

/**
 * Combine all Middlewares
 * Created by cedric on 31/03/2017.
 */
class AppStateMiddleware : Middleware<Action, AppState> {
    override fun dispatch(store: Store<Action, AppState>, action: Action, next: Store.NextDispatcher<Action>?) {
        GalleryWsMiddleware.WS_MIDDLEWARE.dispatch(store, action, next)
        LoggerMiddleware.MIDDLEWARE.dispatch(store, action, next)
        //add other middleware here
    }
}
