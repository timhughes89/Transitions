package com.timsimonhughes.transitions.ui.containerTransform.viewModel

import androidx.lifecycle.ViewModel
import com.timsimonhughes.transitions.ui.repository.ContentRepository

class ContainerTransformViewModel : ViewModel() {

    private val albumList = ContentRepository().getAlbums()
    val albums = albumList

}