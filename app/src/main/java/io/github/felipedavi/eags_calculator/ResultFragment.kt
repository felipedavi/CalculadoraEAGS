package io.github.felipedavi.eags_calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.activity.addCallback
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import io.github.felipedavi.eags_calculator.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigateUp()
        }

        setListeners()

        return view
    }

    private fun setListeners() {
        val p = args.pt
        val e = args.esp
        val mp = (p.toDouble().div(40))*10
        val me = (e.toDouble()/60)*10
        val m = (mp+(me*2))/3
                
        binding.textResult.text = String.format(if (m>=5)
            getString(R.string.result_classified, m)
        else getString(R.string.result_disqualified))

        binding.textPt.text = getString(R.string.result_pt, mp)

        binding.textEsp.text = getString(R.string.result_pt, me)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}