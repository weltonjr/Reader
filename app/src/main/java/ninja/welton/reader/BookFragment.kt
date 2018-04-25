package ninja.welton.reader

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ninja.welton.reader.managers.BookManager


class BookFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_book_list, container, false)

        if (view is RecyclerView) {
            val context = view.getContext()

            view.layoutManager = LinearLayoutManager(context)
            view.adapter = BookRecyclerViewAdapter(BookManager.itens)
        }
        return view
    }
}
