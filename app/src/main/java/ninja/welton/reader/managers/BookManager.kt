package ninja.welton.reader.managers

import android.os.StrictMode
import com.github.kittinunf.fuel.android.core.Json
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import ninja.welton.reader.API
import ninja.welton.reader.extensions.iterator
import ninja.welton.reader.models.Book


object BookManager {

    fun getByLibrary(idLibrary: Int): List<Book> {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val (_, _, result: Result<Json, FuelError>) = "$API/GetLibraryBooks?id=$idLibrary".httpGet().responseJson()

        val json = result.component1()?.array()

        var list = emptyList<Book>()

        if(json != null){
            for(item in json){
                list += Book(item.getInt("Id"), item.getString("Name"), item.getString("Imagem1"), item.getString("Imagem2"))
            }
        }
        return list
    }

    fun getById(idBook: Int): Book? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val (_, _, result: Result<Json, FuelError>) = "$API/GetBook?id=$idBook".httpGet().responseJson()

        val json = result.component1()?.obj()

        return if(json == null) null else Book(json.getInt("Id"), json.getString("Name"), json.getString("Imagem1"), json.getString("Imagem2"))
    }

    fun getByIds(ids: List<Int>): List<Book> {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        //todo: falta fazer
        val (_, _, result: Result<Json, FuelError>) = "$API/GetBooks".httpGet().responseJson()

        val json = result.component1()?.array()

        var list = emptyList<Book>()

        if(json != null){
            for(item in json){
                list += Book(item.getInt("Id"), item.getString("Name"), item.getString("Imagem1"), item.getString("Imagem2"))
            }
        }
        return list
    }
}