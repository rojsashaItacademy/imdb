package ru.trinitydigital.cinemainfo.ui.main

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.trinitydigital.cinemainfo.R
import ru.trinitydigital.cinemainfo.data.model.CinemaSearchModel
import ru.trinitydigital.cinemainfo.data.remote.RetrofitBuilder

//1adac051
class MainActivity : BaseAcitivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        search.doAfterTextChanged {
//            if (!it.isNullOrEmpty() && it.toString().length > 2)
                getSearch(it.toString())
        }
    }


    private fun getSearch(text: String) {
        RetrofitBuilder.getService()?.getCinema("1adac051", text)
            ?.enqueue(object : Callback<CinemaSearchModel> {
                override fun onResponse(
                    call: Call<CinemaSearchModel>,
                    response: Response<CinemaSearchModel>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val arrays = response.body()?.search?.map { it.title }?.toTypedArray()
                        arrays?.let {
                            search.setAdapter(
                                ArrayAdapter(
                                    applicationContext,
                                    android.R.layout.simple_dropdown_item_1line,
                                    it
                                )
                            )
                        }

                    }

                }

                override fun onFailure(call: Call<CinemaSearchModel>, t: Throwable) {
                    Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT)
                        .show()
                }

            })
    }
}