package ninja.welton.reader


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.AnkoLogger


class HomeFragment : Fragment(), AnkoLogger {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_home, container, false)

    override fun onStart() {
        main_buttonStart.setOnClickListener{
            activity.supportFragmentManager.beginTransaction().also {
                it.addToBackStack("HOME")
                it.replace(R.id.main_content, LibraryFragment())
            }.commit()
        }
        super.onStart()
    }

}
