package cedric.gloseapplication.gallery.domain.redux

import cedric.gloseapplication.book.domain.model.BookDetailsModel
import cedric.gloseapplication.book.domain.model.BookModel
import cedric.gloseapplication.common.domain.redux.Action
import cedric.gloseapplication.common.domain.redux.AppState
import cedric.gloseapplication.common.domain.redux.Middleware
import cedric.gloseapplication.common.domain.redux.Store
import cedric.gloseapplication.common.network.WsCallManager
import cedric.gloseapplication.gallery.domain.model.BookGalleryModel
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * Middleware managing api call for gallery
 * Created by cedric on 31/03/2017.
 */
object GalleryWsMiddleware {

    //todo I would like to put a GalleryState instead of a AppState but then I can't compose
    //with other middleware because the store is unique and is <Action, GalleryState>
    val WS_MIDDLEWARE: Middleware<Action, AppState> = object :Middleware <Action, AppState>{

        override fun dispatch (store:Store<Action, AppState>,
                               action:Action,
                               next:Store.NextDispatcher<Action>?) {
            //when load books is dispatched by store, launch ws to retrieve books
            if (action.type == GalleryActions.LOAD_BOOK) {
                //todo extract "20150601" variable, the only place we have is in action so need to modify action to handle paramters
                WsCallManager.instance.callGetBookGallery("20150601")
                        .subscribeOn(Schedulers.io())
                        .flatMap { galleryModel -> Observable.fromIterable(galleryModel.books) }
                        .flatMap { bookModel -> WsCallManager.instance.callGetBookInfo(bookModel.id) }
                        .toList()
                        .toObservable()
                        .subscribe { books ->
                            val action = GalleryActions.LoadBookFinishedAction()
                            action.mBooks = books
                            next?.dispatch(action)
                        }
            }
        }
    }


}
