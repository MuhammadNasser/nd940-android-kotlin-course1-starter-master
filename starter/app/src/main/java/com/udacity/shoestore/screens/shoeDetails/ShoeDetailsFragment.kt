package com.udacity.shoestore.screens.shoeDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailsFragment : Fragment() {

    private lateinit var viewModel: MainActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)


        with(binding) {
            shoe = Shoe("", 0.0, "", "")

            saveButton.setOnClickListener {
                val name = binding.shoe?.name ?: ""
                val size = binding.shoe?.size.toString()
                val company = binding.shoe?.company ?: ""
                val description = binding.shoe?.description ?: ""

                if (name.isEmpty()) {
                    nameEditText.error = "Please add the name"
                    return@setOnClickListener
                }

                if (company.isEmpty()) {
                    companyEditText.error = "Please add the company"
                    return@setOnClickListener
                }

                if (size.isEmpty()) {
                    sizeEditText.error = "Please add the size"
                    return@setOnClickListener
                }

                if (description.isEmpty()) {
                    descriptionEditText.error = "Please add the description"
                    return@setOnClickListener
                }

                viewModel.addShoe(name, size.toDouble(), company, description)
                Toast.makeText(activity, "Shoe $name added successfully", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }

            cancelButton.setOnClickListener {
                findNavController().navigateUp()
            }
        }
        return binding.root
    }
}