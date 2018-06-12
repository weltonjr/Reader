package ninja.welton.reader.managers

import android.os.StrictMode
import com.github.kittinunf.fuel.android.core.Json
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import ninja.welton.reader.API
import ninja.welton.reader.extensions.iterator
import ninja.welton.reader.models.Library
import org.jetbrains.anko.AnkoLogger


object LibraryManager : AnkoLogger {

    val libraries by lazy {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val (request, response, result: Result<Json, FuelError>) = "$API/libraries".httpGet().responseJson()

        val json = result.component1()?.array()

        var list = emptyList<Library>()

        if(json != null){
            for(item in json){
                list += Library(item.getInt("Id"), item.getString("Name"), "")
            }
        }
        list
    }
}