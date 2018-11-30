package com.example.emmaburton.projectemma.testData

import android.util.Log
import org.json.JSONArray

object JsonReader {

//    private const val TEST_JSON = "com/example/emmaburton/projectemma/testData/test_json.json"
    private val jsonArray = JSONArray(TestJson.recipesJson)

    fun readJson() = (0..(jsonArray.length() - 1)).forEach {
        Log.d("JSON", jsonArray.getJSONObject(it).getString("name"))
    }
}