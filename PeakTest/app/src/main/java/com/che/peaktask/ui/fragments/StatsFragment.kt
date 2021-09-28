package com.che.peaktask.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.che.peaktask.databinding.FragmentStatsBinding
import com.che.peaktask.ui.MainViewModel
import com.che.peaktask.model.PeakShape

class StatsFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentStatsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textViewSquares: TextView = binding.textSquares
        val textViewCircles: TextView = binding.textCircles
        val textViewTriangles: TextView = binding.textTriangles
        mainViewModel.shapesData.observe(viewLifecycleOwner, { list ->
            textViewSquares.text = list.filter { it.shapeType == PeakShape.Type.Square }.size.toString()
            textViewCircles.text = list.filter { it.shapeType == PeakShape.Type.Circle }.size.toString()
            textViewTriangles.text = list.filter { it.shapeType == PeakShape.Type.Triangle }.size.toString()
        })

        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}