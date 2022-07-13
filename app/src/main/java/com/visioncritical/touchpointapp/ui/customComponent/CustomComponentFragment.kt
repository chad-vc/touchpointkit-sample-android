package com.visioncritical.touchpointapp.ui.customComponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.visioncritical.touchpointapp.databinding.FragmentCustomComponentBinding
import com.visioncritical.touchpointkit.utils.TouchPointActivity

class CustomComponentFragment : Fragment() {

    private var _binding: FragmentCustomComponentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomComponentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val button1: MaterialButton = binding.button1
        button1.setOnClickListener { _ ->
            run {
                context?.let {
                    TouchPointActivity.shared.openActivityForScreenComponent(
                        it,
                        "Custom Component Screen",
                        "Button 1"
                    )
                }
            }
        }

        val button2: MaterialButton = binding.button2
        button2.setOnClickListener { _ ->
            run {
                context?.let {
                    TouchPointActivity.shared.openActivityForScreenComponent(
                        it,
                        "Custom Component Screen",
                        "Button 2"
                    )
                }
            }
        }

        val button3: MaterialButton = binding.button3
        button3.setOnClickListener { _ ->
            run {
                context?.let {
                    TouchPointActivity.shared.openActivityForScreenComponent(
                        it,
                        "Custom Component Screen",
                        "Button 3"
                    )
                }
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}