package ninja.welton.reader

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ninja.welton.reader.dummy.DummyContent.DummyItem
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info


class LibraryRecyclerViewAdapter(private val mValues: List<DummyItem>)
    : RecyclerView.Adapter<LibraryRecyclerViewAdapter.ViewHolder>(), AnkoLogger {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_library, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues.get(index = position)
        holder.mIdView.text = mValues.get(position).id
        holder.mContentView.text = mValues.get(position).content

        holder.mView.setOnClickListener {
            info { "ITEM" }
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.findViewById<View>(R.id.id) as TextView
        val mContentView: TextView = mView.findViewById<View>(R.id.content) as TextView
        var mItem: DummyItem? = null

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
