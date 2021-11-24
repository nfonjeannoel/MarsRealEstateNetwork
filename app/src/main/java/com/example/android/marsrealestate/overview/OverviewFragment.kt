/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.overview

import android.os.Bundle
import android.view.*
import android.widget.Spinner
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.marsrealestate.R
import com.example.android.marsrealestate.databinding.FragmentOverviewBinding

/**
 * This fragment shows the the status of the Mars real-estate web services transaction.
 */
class OverviewFragment : Fragment() {
    private lateinit var lastView: View
    private lateinit var lastActiveView: View

    /**
     * Lazily initialize our [OverviewViewModel].
     */
    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }
    private lateinit var binding: FragmentOverviewBinding

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentOverviewBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        lastView = binding.llMyResult
        lastActiveView = binding.cvMyResults

        setClickListeners()

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchResults()
        viewModel.results.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()){
                this.findNavController().navigate(OverviewFragmentDirections.actionShowDetail())
                viewModel.doneNavigating()
            }
        })
    }

    private fun fetchResults() {
        binding.btnFetchResult.setOnClickListener {
            val filters = hashMapOf(
                "opt" to "1",
                "center_number" to binding.etOp1CenterNumber.text.toString(),
                "level" to selectLevel(binding.spOpt1Level),
                "year" to selectYear(binding.spOpt1Year),
                "student_name" to binding.etOp1Name.text.toString()
            )
            viewModel.getMarsRealEstateProperties(filters)
        }

        binding.btnOp2FetchResults.setOnClickListener {
            val filters = hashMapOf(
                "opt" to "2",
                "center_number" to binding.etOpt2CenterNumber.text.toString(),
                "level" to selectLevel(binding.spOp2Level),
                "year" to selectYear(binding.spinnerOp2Year)
            )
            viewModel.getMarsRealEstateProperties(filters)
        }

        binding.btnOp3FetchResults.setOnClickListener {
            val filters = hashMapOf(
                "opt" to "3",
                "center_number" to binding.etOp3CenterNumber.text.toString(),
                "level" to selectLevel(binding.spOp3Level),
                "year" to selectYear(binding.spOp3Year),
                "papers_passed" to binding.spOp3PapersPassed.selectedItem.toString()
            )
            viewModel.getMarsRealEstateProperties(filters)
        }

        binding.btnOp4FetchResults.setOnClickListener {
            val filters = hashMapOf(
                "opt" to "4",
                "level" to selectLevel(binding.spOp4Level),
                "year" to selectYear(binding.spOp4Year),
                "grade_text" to binding.etOp4Grade.text.toString().toUpperCase(),
                "grade" to binding.spOp4PapersPassed.selectedItem.toString()
            )
            viewModel.getMarsRealEstateProperties(filters)
        }

        binding.btnOp5FetchResults.setOnClickListener {
            val filters = hashMapOf(
                "opt" to "5",
                "level" to selectLevel(binding.spOp5Level),
                "year" to selectYear(binding.spOp5Year)
            )
            viewModel.getMarsRealEstateProperties(filters)
        }
    }

    private fun selectYear(spOptYear: Spinner): String {
        return spOptYear.selectedItem.toString()
    }

    private fun selectLevel(spOpt1Level: Spinner): String {
        return when (spOpt1Level.selectedItemId) {
            0L -> "A"
            else -> "O"
        }
    }

    /**
     * Inflates the overflow menu that contains filtering options.
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun setClickListeners() {
        binding.cvMyResults.setOnClickListener {
            toggleVisibility(it)
            binding.llMyResult.visibility = View.VISIBLE
            lastView = binding.llMyResult
            lastActiveView = it
        }

        binding.cvCenterResult.setOnClickListener {
            toggleVisibility(it)
            binding.llCenterResult.visibility = View.VISIBLE
            lastView = binding.llCenterResult
            lastActiveView = it
        }

        binding.cvGcePapers.setOnClickListener {
            toggleVisibility(it)
            binding.llGcePapers.visibility = View.VISIBLE
            lastView = binding.llGcePapers
            lastActiveView = it
        }

        binding.cvGceGrades.setOnClickListener {
            toggleVisibility(it)
            binding.llGceGrades.visibility = View.VISIBLE
            lastView = binding.llGceGrades
            lastActiveView = it
        }

        binding.cvAllResults.setOnClickListener {
            toggleVisibility(it)
            binding.llAllResults.visibility = View.VISIBLE
            lastView = binding.llAllResults
            lastActiveView = it
        }
    }

    private fun toggleVisibility(view: View) {
        lastView.visibility = View.GONE
        view.background = ContextCompat.getDrawable(requireContext(), R.drawable.active_background)
        lastActiveView.background = ContextCompat.getDrawable(requireContext(), R.drawable.active_background)
    }
}
