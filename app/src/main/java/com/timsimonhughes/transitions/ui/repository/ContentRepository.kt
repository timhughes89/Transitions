package com.timsimonhughes.transitions.ui.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.timsimonhughes.transitions.model.Album
import com.timsimonhughes.transitions.model.albums

class ContentRepository {

    fun getAlbums() : LiveData<List<Album>> {

        val mutableList = MutableLiveData<List<Album>>()
        mutableList.postValue(albums)

        return mutableList
    }

}
