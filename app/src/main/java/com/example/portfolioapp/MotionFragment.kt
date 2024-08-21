package com.example.portfolioapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment

class MotionFragment : Fragment(R.layout.fragment_motion) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.hide()
        val tvEmail = view.findViewById<TextView>(R.id.tvEmail)
        val tvPhone = view.findViewById<TextView>(R.id.tvPhone)

        tvEmail.setOnClickListener {
            copyToClipboard("Email", tvEmail.text.toString())
            Toast.makeText(requireContext(), "Email copied to clipboard!", Toast.LENGTH_SHORT).show()
        }

        tvPhone.setOnClickListener {
            copyToClipboard("Phone", tvPhone.text.toString())
            Toast.makeText(requireContext(), "Phone number copied to clipboard!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun copyToClipboard(label: String, text: String) {
        val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(label, text)
        clipboard.setPrimaryClip(clip)
    }
}