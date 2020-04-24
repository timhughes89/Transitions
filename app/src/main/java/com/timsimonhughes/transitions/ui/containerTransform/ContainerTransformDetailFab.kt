package com.timsimonhughes.transitions.ui.containerTransform

import android.content.Context
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialContainerTransform
import com.timsimonhughes.transitions.R
import kotlinx.android.synthetic.main.fragment_container_transform_detail_fab.*


class ContainerTransformDetailFab : Fragment(R.layout.fragment_container_transform_detail_fab) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val interp = AnimationUtils.loadInterpolator(
            context,
            android.R.interpolator.fast_out_slow_in
        )

        fab_detail_toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 400L
            interpolator = interp
            scrimColor = resources.getColor(android.R.color.white, context?.theme)
        }

        sharedElementReturnTransition = MaterialContainerTransform().apply {
            duration = 400L
            interpolator = interp
        }
    }
}
