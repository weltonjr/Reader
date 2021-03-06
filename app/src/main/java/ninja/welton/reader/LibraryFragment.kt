package ninja.welton.reader

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ninja.welton.reader.managers.LibraryManager
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info


class LibraryFragment : Fragment(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_home, container, false)

        if (view is RecyclerView) {
            val context = view.getContext()

            view.layoutManager = GridLayoutManager(context, 3)
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            view.adapter = ModelRecyclerViewAdapter(LibraryManager.libraries, R.layout.item_book){ _, model ->
                //chamar activity
                info { "Click on ${model.name}" }

                activity?.startActivity(Intent(activity, BookActivity::class.java).also {
                    it.putExtra("library", model.name)
                })
            }
        }
        return view
    }
}
