package com.visioncritical.touchpointapp.ui.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.visioncritical.touchpointapp.databinding.FragmentPopupBinding
import com.visioncritical.touchpointkit.utils.TouchPointActivity

class PopupFragment : Fragment() {

    private var _binding: FragmentPopupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPopupBinding.inflate(inflater, container, false)
        context?.let { TouchPointActivity.shared.setCurrentScreen(it, "Popup Screen") }
        val root: View = binding.root

        val cancel: Button = binding.cancelButton
        cancel.setOnClickListener { _ ->
            run {
                TouchPointActivity.shared.cancelPopupForScreen("Popup Screen")
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        TouchPointActivity.shared.cancelPopupForScreen("Popup Screen")
    }
}