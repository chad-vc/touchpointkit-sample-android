package com.visioncritical.touchpointapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.visioncritical.touchpointkit.utils.TouchPointActivity

class MyFragment : Fragment(R.layout.my_fragment) {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        TouchPointActivity.shared.setCurrentScreen(requireContext(), "screen2")
    }
}