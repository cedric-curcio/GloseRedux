package cedric.gloseapplication.common.domain.redux

import java.io.Serializable
import java.util.ArrayList

import cedric.gloseapplication.gallery.domain.redux.GalleryState
import cedric.gloseapplication.gallery.domain.redux.GalleryWsMiddleware

/**
 * Store holding current application state and dispatch the action that changing state.
 * Created by cedric on 27/03/2017.
 */
class Store<A, S : Serializable> (
        private val reducer: Reducer<A, S>,
        initialState: S,
        vararg middlewares: Middleware<A, S>) {

    var state: S = initialState;
    private val dispatcher = object : Middleware<A, S> {
        override fun dispatch(store: Store<A, S>, action: A, next: NextDispatcher<A>?) {
            synchronized(this) {
                state = store.reducer.reduce(action, state)
            }

            for (i in subscribers.indices) {
                store.subscribers[i].run()
            }
        }
    };
    private val subscribers = ArrayList<Runnable>()
    private val next = ArrayList<NextDispatcher<A>>()

    init {
        this.state = initialState

        this.next.add(object : NextDispatcher<A> {
            override fun dispatch(action: A) {
                this@Store.dispatcher.dispatch(this@Store, action, null)
            }
        })
        for (i in middlewares.indices.reversed()) {
            val mw = middlewares[i]
            val n = next[0]
            next.add(0, object : NextDispatcher<A> {
                override fun dispatch(action: A) {
                    mw.dispatch(this@Store, action, n)
                }
            })
        }
    }

    companion object {
        fun <A, S : Serializable> createStore(
                reducer: Reducer<A, S>,
                state: S,
                vararg middleware: Middleware<A, S>): Store<A, S> {
            return Store(reducer, state, *middleware)
        }
    }

    interface NextDispatcher<A> {
        fun dispatch(action: A)

    }



    fun dispatch(action: A): S {
        this.next[0].dispatch(action)
        return this.state
    }

    fun subscribe(r: Runnable): Runnable {
        this.subscribers.add(r)
        return Runnable { subscribers.remove(r) }
    }
}
