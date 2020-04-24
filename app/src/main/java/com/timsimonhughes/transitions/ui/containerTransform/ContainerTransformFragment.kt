package com.timsimonhughes.transitions.ui.containerTransform

import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.transition.Hold
import com.timsimonhughes.transitions.R
import com.timsimonhughes.transitions.extensions.waitForTransition
import com.timsimonhughes.transitions.model.Album
import com.timsimonhughes.transitions.ui.containerTransform.adapter.ContainerTransformAdapter
import com.timsimonhughes.transitions.ui.containerTransform.viewModel.ContainerTransformViewModel
import kotlinx.android.synthetic.main.fragment_container_transform.*

class ContainerTransformFragment : Fragment(R.layout.fragment_container_transform), ContainerTransformAdapter.OnAlbumItemClickListener {

    private lateinit var containerTransformViewModel: ContainerTransformViewModel
    private var containerTransformAdapter: ContainerTransformAdapter? = null
    private var onAlbumItemClickListener: ContainerTransformAdapter.OnAlbumItemClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retains the previous fragment for transition duration
        exitTransition = Hold()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        containerTransformViewModel = ViewModelProvider(this).get(ContainerTransformViewModel::class.java)
        onAlbumItemClickListener = this
        containerTransformAdapter = ContainerTransformAdapter(onAlbumItemClickListener)

        initializeRecycler()
        observeViewModel()

        toolbar_container_transform.apply {
            title = "Container Transform"
        }

        fab_container_transform.setOnClickListener {

            val direction = ContainerTransformFragmentDirections.actionContainerTransformFragmentToContainterTransformDetailFab()
            val extras = FragmentNavigatorExtras(it to getString(R.string.transition_floating_action_button))

            findNavController().navigate(direction, extras)
        }

        waitForTransition(recycler_view_container_transform)
    }

    private fun observeViewModel() {
        containerTransformViewModel.albums.observe(viewLifecycleOwner, Observer { albumList ->
            containerTransformAdapter?.submitList(albumList)
        })
    }

    private fun initializeRecycler() {
        recycler_view_container_transform.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = containerTransformAdapter
        }
    }

    override fun onAlbumItemClick(album: Album, view: View, position: Int) {
        val transitionName = ViewCompat.getTransitionName(view) as String
        val imageUrl = album.albumUrl

        // Passed attributes through nav directions
        val direction = ContainerTransformFragmentDirections.actionContainerTransformFragmentToContainerTransformDetail1(
            transitionName = transitionName,
            imageUrl = imageUrl
        )

        // Defines all shared elements transitions
        val extras = FragmentNavigatorExtras(
            view to getString(R.string.transition_list_to_detail_1)
        )

        findNavController().navigate(direction, extras)
    }
}
