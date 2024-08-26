package io.github.felipedavi.eags_calculator

import android.os.Bundle
import android.text.InputFilter
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.github.felipedavi.eags_calculator.databinding.FragmentMainBinding
import io.github.felipedavi.eags_calculator.util.MinMaxFilter
import io.github.felipedavi.eags_calculator.util.extension.hideKeyboard
import io.github.felipedavi.eags_calculator.util.extension.showKeyboard

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        setListeners()
        return view
    }

    override fun onResume() {
        super.onResume()
        clearData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setListeners() {
        binding.editPortugues.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                showKeyboard(v)
            } else {
                hideKeyboard()
            }
        }
        binding.editEspecificas.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus)
                showKeyboard(v)
            else
                hideKeyboard()
        }

        binding.editPortugues.filters = arrayOf<InputFilter>(MinMaxFilter(0, 40))
        binding.editEspecificas.filters = arrayOf<InputFilter>(MinMaxFilter(0, 60))
        binding.buttonSave.setOnClickListener {
            val pt = binding.editPortugues.text.toString().trim()
            val esp = binding.editEspecificas.text.toString().trim()

            when {
                pt.isEmpty() -> {
                    binding.editPortugues.error = getString(R.string.edit_error)
                    binding.editPortugues.requestFocus()
                    return@setOnClickListener
                }
                esp.isEmpty() -> {
                    binding.editEspecificas.error = getString(R.string.edit_error)
                    binding.editEspecificas.requestFocus()
                    return@setOnClickListener
                }
                else -> {
                    val directions = MainFragmentDirections.navigateToResultFragment(pt.toInt(), esp.toInt())
                    findNavController().navigate(directions)
                }
            }
        }
    }

    private fun clearData() {
        binding.editPortugues.text.clear()
        binding.editEspecificas.text.clear()
    }

}