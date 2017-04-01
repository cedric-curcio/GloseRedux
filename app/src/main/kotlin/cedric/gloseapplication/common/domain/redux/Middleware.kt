package cedric.gloseapplication.common.domain.redux

import java.io.Serializable

/**
 * Created by cedric on 31/03/2017.
 */

interface Middleware<A, S : Serializable> {
    fun dispatch(store: Store<A, S>, action: A, next: Store.NextDispatcher<A>?)
}