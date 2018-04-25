package ninja.welton.reader

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import ninja.welton.reader.models.Library

class LibraryRecyclerViewAdapter(private val mValues: List<Library>)
    : RecyclerView.Adapter<LibraryRecyclerViewAdapter.ViewHolder>(), AnkoLogger {

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
            if(holder.mView.context is MainActivity){
                val activity = holder.mView.context as MainActivity
                activity.supportFragmentManager.beginTransaction().also {
                    it.replace(R.id.main_content, BookFragment(), "Book")
                    it.addToBackStack(null)
                }.commit()
            }
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mTextView = mView.findViewById<View>(R.id.content) as TextView
        val mImageView = mView.findViewById<View>(R.id.imageView) as ImageView
        var mItem: Library? = null

        override fun toString(): String {
            return super.toString() + " '" + mTextView.text + "'"
        }
    }
}
