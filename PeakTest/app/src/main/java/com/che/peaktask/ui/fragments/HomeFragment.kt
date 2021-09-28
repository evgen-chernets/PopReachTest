package com.che.peaktask.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.che.peaktask.R
import com.che.peaktask.databinding.FragmentHomeBinding
import com.che.peaktask.ui.MainViewModel
import com.che.peaktask.ui.custom.PeakShapesCanvas

class HomeFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val root: View = binding.root

        binding.shapesCanvas.post { initController() }

        val shapesCanvas: PeakShapesCanvas = binding.shapesCanvas
        mainViewModel.shapesData.observe(viewLifecycleOwner, {
            shapesCanvas.drawShapes(it, listener, longListener)
        })

        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        return root
    }

    private fun initController() {
        val imageWidth = context?.getDrawable(R.drawable.ic_square)?.minimumWidth ?: 20
        val imageHeight = context?.getDrawable(R.drawable.ic_square)?.minimumHeight ?: 20
        val x = binding.shapesCanvas.width - imageWidth
        val y = binding.shapesCanvas.height - imageHeight
        mainViewModel.initController(x, y)
    }

    private val listener = View.OnClickListener {
        mainViewModel.onShapeClicked(it.z.toInt())
    }

    private val longListener = View.OnLongClickListener {
        mainViewModel.onShapeLongClicked(it.z.toInt())
        true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}