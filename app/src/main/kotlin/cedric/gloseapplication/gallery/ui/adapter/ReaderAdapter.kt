package cedric.gloseapplication.gallery.ui.adapter

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
import cedric.gloseapplication.social.domain.model.ReaderModel
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Adapter to display list of book readers
 * Created by cedric on 28/03/2017.
 */
class ReaderAdapter : RecyclerView.Adapter<ReaderAdapter.ReaderHolder>() {

    private var mData: MutableList<ReaderModel>? = null

    /**
     * Update the adapter with new data.
     * @param data list of reader
     */
    fun updateData(data: List<ReaderModel>) {
        if (mData == null) {
            mData = ArrayList<ReaderModel>()
        }
        val previousDataCount = mData!!.size
        val newDataCount = data.size
        mData!!.clear()
        notifyItemRangeRemoved(0, previousDataCount)
        mData!!.addAll(data)
        notifyItemRangeInserted(0, newDataCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReaderHolder {
        return ReaderHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_reader, null, false))
    }

    override fun onBindViewHolder(holder: ReaderHolder, position: Int) {
        val readerModel = mData!![position]
        val imageUrl = readerModel.avatar
        if (imageUrl != null) {
            Glide.with(holder.mReaderImage!!.context.applicationContext).load(imageUrl).into(holder.mReaderImage!!)
        }
    }

    override fun getItemCount(): Int {
        return if (mData == null) 0 else mData!!.size
    }

    inner class ReaderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mReaderImage: ImageView by bindView(R.id.item_reader_image)

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}
