package com.visioncritical.touchpointapp.ui.banner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.visioncritical.touchpointapp.databinding.FragmentBannerBinding
import com.visioncritical.touchpointkit.utils.TouchPointActivity

class BannerFragment : Fragment() {

    private var _binding: FragmentBannerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBannerBinding.inflate(inflater, container, false)
        context?.let { TouchPointActivity.shared.setCurrentScreen(it, "Banner Screen") }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}