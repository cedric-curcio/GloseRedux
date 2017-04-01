package cedric.gloseapplication.gallery.ui.activity

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import butterknife.ButterKnife
import butterknife.bindView
import cedric.gloseapplication.Application
import cedric.gloseapplication.R
import cedric.gloseapplication.gallery.domain.redux.GalleryActions
import cedric.gloseapplication.gallery.ui.adapter.BookGalleryAdapter
import android.support.v7.widget.DividerItemDecoration



/**
 * Activity displaying a gallery of books
 */
class BookGalleryActivity : AppCompatActivity() {

    //view binding
    val mProgressBar: ProgressBar by bindView(R.id.book_gallery_progress_bar)
    val mBookGalleryView: RecyclerView by bindView(R.id.book_gallery_recycler_view)

    var mBookGalleryAdapter: BookGalleryAdapter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_gallery)
        ButterKnife.bind(this);
        mBookGalleryView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
//        val dividerItemDecoration = DividerItemDecoration(mBookGalleryView.getContext(),
//                GridLayoutManager.VERTICAL)
//        mBookGalleryView.addItemDecoration(dividerItemDecoration)
        mBookGalleryView.addItemDecoration(object:RecyclerView.ItemDecoration(){
            override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
                outRect?.top = 10;
                outRect?.left = 10;
                outRect?.right = 10;
                outRect?.bottom = 10;
            }
        });
        if (mBookGalleryAdapter == null) {
            mBookGalleryAdapter = BookGalleryAdapter();
        }
        mBookGalleryView.adapter = mBookGalleryAdapter;
        //register routine to update view in store
        Application.sStore.subscribe(Runnable {
            runOnUiThread {
                mProgressBar.visibility = if (Application.sStore.state.mGalleryState.isLoadingGallery) View.VISIBLE else View.GONE;
                mBookGalleryAdapter!!.updateData(Application.sStore.state.mGalleryState.books)
            }
        }
        )
    }

    override fun onStart() {
        super.onStart()
        //show loader
        //load the bookgallery with redux
        Application.sStore.dispatch(GalleryActions.LoadBookAction());

    }
}
