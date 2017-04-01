package cedric.gloseapplication.common.domain.redux

import java.io.Serializable

/**
 * Usual reducer
 *
 * @param <A> action
 * @param <S> state
 */
interface Reducer<A, S : Serializable> {

    // Reducer
    fun reduce(action: A, state: S): S
}
