package cedric.gloseapplication.common.domain.redux

import android.util.Log

import java.io.Serializable

/**
 * Picked from examples to test multiple middleware.
 * Created by cedric on 31/03/2017.
 */
object LoggerMiddleware {
    val LOG_TAG = LoggerMiddleware::class.java.simpleName
    val MIDDLEWARE: Middleware<Action, AppState> = object : Middleware<Action, AppState> {
        override fun dispatch(store: Store<Action, AppState>,
                              action: Action,
                              next: Store.NextDispatcher<Action>?) {
            Log.d(LOG_TAG, "--> " + action.toString())
            next?.dispatch(action)
            Log.d(LOG_TAG, "<-- " + store.state.toString())
        }
    }
}
