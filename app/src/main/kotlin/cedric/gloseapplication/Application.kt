package cedric.gloseapplication


import android.content.Intent

import cedric.gloseapplication.common.domain.redux.Action
import cedric.gloseapplication.common.domain.redux.AppState
import cedric.gloseapplication.common.domain.redux.AppStateMiddleware
import cedric.gloseapplication.common.domain.redux.AppStateReducer
import cedric.gloseapplication.common.domain.redux.Store
import cedric.gloseapplication.gallery.domain.redux.GalleryWsMiddleware
import cedric.gloseapplication.gallery.ui.activity.BookGalleryActivity

/**
 * Application entry point
 * Created by cedric on 29/03/2017.
 */
class Application : android.app.Application() {

    //init store at start up
    companion object {
        var sStore: Store<Action, AppState> = Store(
                AppStateReducer(),
                AppState(),
                AppStateMiddleware())
    }

    override fun onCreate() {
        super.onCreate()
        //start activity
        startActivity(Intent(this, BookGalleryActivity::class.java))
    }
}
