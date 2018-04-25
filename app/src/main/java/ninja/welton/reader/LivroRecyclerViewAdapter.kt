package ninja.welton.reader

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import ninja.welton.reader.models.Book

class BookRecyclerViewAdapter(private val mValues: List<Book>)
    : RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder>(), AnkoLogger {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_library, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues.get(index = position)
        holder.mTextView.text = mValues[position].name

//        Glide.with(holder.mView).load(mValues[position].image).into(holder.mImageView)

        holder.mView.setOnClickListener {
            info { "ITEM" }
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mTextView = mView.findViewById<View>(R.id.content) as TextView
        val mImageView = mView.findViewById<View>(R.id.imageView) as ImageView
        var mItem: Book? = null

        override fun toString(): String {
            return super.toString() + " '" + mTextView.text + "'"
        }
    }
}
