package com.visioncritical.touchpointapp.ui.customComponent

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.visioncritical.touchpointapp.databinding.FragmentCustomComponentBinding
import com.visioncritical.touchpointkit.utils.TouchPointActivity
import com.visioncritical.touchpointkit.utils.TouchPointActivityListener

class CustomComponentFragment : Fragment(), TouchPointActivityListener {

    private var _binding: FragmentCustomComponentBinding? = null
    private var curSelectedButton: Button? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onTouchPointActivityComplete() {
        super.onTouchPointActivityComplete()
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Thanks for completing the activity!")
        builder.setMessage("We really appreciate your feedback")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }

    override fun onTouchPointActivityCollapse() {
        curSelectedButton?.setBackgroundColor(Color.GRAY)
    }

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
                curSelectedButton = button1
                context?.let {
                    TouchPointActivity.shared.openActivityForScreenComponent(
                        it,
                        "Custom Component Screen",
                        "Button 1",
                        this
                    )
                }
            }
        }

        val button2: MaterialButton = binding.button2
        button2.setOnClickListener { _ ->
            run {
                curSelectedButton = button2
                context?.let {
                    TouchPointActivity.shared.openActivityForScreenComponent(
                        it,
                        "Custom Component Screen",
                        "Button 2",
                        this
                    )
                }
            }
        }

        val button3: MaterialButton = binding.button3
        button3.setOnClickListener { _ ->
            run {
                curSelectedButton = button3
                context?.let {
                    TouchPointActivity.shared.openActivityForScreenComponent(
                        it,
                        "Custom Component Screen",
                        "Button 3",
                        this
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