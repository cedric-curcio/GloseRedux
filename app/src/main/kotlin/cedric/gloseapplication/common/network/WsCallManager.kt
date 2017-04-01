package cedric.gloseapplication.common.network

import cedric.gloseapplication.book.domain.model.BookDetailsModel
import cedric.gloseapplication.gallery.domain.model.BookGalleryModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Class handling all WS calls.
 * It matches the json result with an observable of the wanted model.
 * Created by cedric on 27/03/2017.
 */
class WsCallManager private constructor() {
    private val mHttpsGloseService: GloseWsService
    private object Holder { val INSTANCE = WsCallManager() }
    init {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.glose.com/v1/")
                .build()

        mHttpsGloseService = retrofit.create(GloseWsService::class.java)
    }

    companion object {
        val instance: WsCallManager by lazy { Holder.INSTANCE }
    }
    /**
     * Interface describing all WS call
     */
    interface GloseWsService {

        @GET("booklists/free-books?")
        fun getBookGallery(@Query("_version") version: String): Observable<BookGalleryModel>

        @GET("books/{bookId}")
        fun getBookInfo(@Path("bookId") bookId: String?): Observable<BookDetailsModel>
    }

    /************************************************
     * Calls
     */

    /**
     * Call the ws giving the book gallery

     * @param version id of gallery to retrieve (called version in test) mandatory
     * *
     * @return Observable of BookGalleryModel type
     */
    fun callGetBookGallery(version: String): Observable<BookGalleryModel> {
        return mHttpsGloseService.getBookGallery(version)
    }

    /**
     * Call the ws giving the book detailed informations

     * @param bookId id of book to retrieve mandatory
     * *
     * @return Observable of BookDetailsModel type
     */
    fun callGetBookInfo(bookId: String?): Observable<BookDetailsModel> {
        return mHttpsGloseService.getBookInfo(bookId)
    }

}
