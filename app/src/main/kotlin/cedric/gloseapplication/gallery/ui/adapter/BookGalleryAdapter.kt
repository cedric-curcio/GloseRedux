package cedric.gloseapplication.gallery.ui.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide

import java.util.ArrayList

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.bindView
import cedric.gloseapplication.R
import cedric.gloseapplication.book.domain.model.BookDetailsModel
import cedric.gloseapplication.social.domain.model.ReaderModel
import java.io.File.separator

/**
 * Adapter to display list of book in gallery
 * Created by cedric on 28/03/2017.
 */
class BookGalleryAdapter : RecyclerView.Adapter<BookGalleryAdapter.BookGalleryHolder>() {

    private var mData: MutableList<BookDetailsModel>? = null

    /**
     * Update the adapter with new data.

     * @param data list of book details model
     */
    fun updateData(data: List<BookDetailsModel>?) {
        if (mData == null) {
            mData = ArrayList<BookDetailsModel>()
        }
        val previousDataCount = mData!!.size
        val newDataCount = data?.size
        mData!!.clear()
        notifyItemRangeRemoved(0, previousDataCount)
        data?.let { mData!!.addAll(it) }
        newDataCount?.let { notifyItemRangeInserted(0, it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookGalleryHolder {
        val bookGalleryHolder = BookGalleryHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book_gallery, null, false))
        bookGalleryHolder.mBookReadersRecyclerView!!.layoutManager = LinearLayoutManager(parent.context, RecyclerView.HORIZONTAL, false)
        return bookGalleryHolder
    }

    override fun onBindViewHolder(holder: BookGalleryHolder, position: Int) {
        holder.configure(mData!![position])
    }

    override fun getItemCount(): Int {
        return if (mData == null) 0 else mData!!.size
    }

    inner class BookGalleryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mBookCover: ImageView by bindView(R.id.item_book_cover)
        val mBookTitle: TextView by bindView(R.id.item_book_title)
        val mBookAuthor: TextView by bindView(R.id.item_book_author)
        val mBookReadersRecyclerView: RecyclerView by bindView(R.id.item_book_reader_list)

        private var mReaderAdapter: ReaderAdapter? = null

        init {
            ButterKnife.bind(this, itemView)
        }

        fun configure(bookModel: BookDetailsModel) {
            val ctx = mBookCover!!.context
            mBookTitle!!.text = bookModel.title
            mBookAuthor!!.text = ctx.getString(R.string.by) + bookModel.authors?.joinToString(prefix = " ");
            val imageUrl = bookModel.image
            if (imageUrl != null) {
                Glide.with(ctx.applicationContext).load(imageUrl).into(mBookCover!!)
            }
            if (mReaderAdapter == null) {
                mReaderAdapter = ReaderAdapter()
                mBookReadersRecyclerView.adapter = mReaderAdapter;
            }
            bookModel.readers?.let { mReaderAdapter!!.updateData(it) }

        }
    }
}
