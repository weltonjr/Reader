package ninja.welton.reader.extensions

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction


inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    beginTransaction().apply(func).commit()
}