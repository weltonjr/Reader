package ninja.welton.reader


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ninja.welton.reader.managers.BookManager
import ninja.welton.reader.managers.UserManager
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class HomeFragment : Fragment(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_home, container, false)
        //todo mudar fragment layout
        if (view is RecyclerView) {
            val context = view.getContext()

            view.layoutManager = GridLayoutManager(context, 2)
            view.adapter = ModelRecyclerViewAdapter(UserManager.getFavs(), R.id.book_item){
                //chamar activity
                info { "Click" }
            }
        }
        return view
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}
