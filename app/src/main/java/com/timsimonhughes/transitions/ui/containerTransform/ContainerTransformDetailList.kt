package com.timsimonhughes.transitions.ui.containerTransform

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.transition.MaterialContainerTransform
import com.timsimonhughes.transitions.R
import kotlinx.android.synthetic.main.fragment_container_transform_detail_list.*

class ContainerTransformDetailList : Fragment(R.layout.fragment_container_transform_detail_list) {

    private val args: ContainerTransformDetailListArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val interp = AnimationUtils.loadInterpolator(
            context,
            android.R.interpolator.fast_out_slow_in
        )

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 400L
            interpolator = interp
        }

        sharedElementReturnTransition = MaterialContainerTransform().apply {
            duration = 400L
            interpolator = interp
        }

        postponeEnterTransition()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageUrl = args.imageUrl

        Glide.with(view.context)
            .load(imageUrl)
            .into(image_view_album_detail)

        startPostponedEnterTransition()
    }
}
