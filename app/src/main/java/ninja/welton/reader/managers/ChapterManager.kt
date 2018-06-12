package ninja.welton.reader.managers

import android.os.StrictMode
import com.github.kittinunf.fuel.android.core.Json
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import ninja.welton.reader.API
import ninja.welton.reader.extensions.iterator
import ninja.welton.reader.models.Chapter


object ChapterManager {

    fun getByBook(idBook: Int): List<Chapter> {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val (_, _, result: Result<Json, FuelError>) = "$API/GetChapters?id=$idBook".httpGet().responseJson()

        val json = result.component1()?.array()

        var list = emptyList<Chapter>()

        if(json != null){
            for(item in json){
                list += Chapter(item.getInt("Id"), item.getString("Name"), null)
            }
        }
        return list
    }

    fun getById(idBook: Int): Chapter? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val (_, _, result: Result<Json, FuelError>) = "$API/GetChapter?id=$idBook".httpGet().responseJson()

        val json = result.component1()?.obj()

        return if(json == null) null else Chapter(json.getInt("Id"), json.getString("Name"), json.getString("Texto"))
    }
}