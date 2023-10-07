package com.selin.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.selin.todoapp.R
import com.selin.todoapp.databinding.FragmentHomepageBinding
import com.selin.todoapp.data.entity.Notes
import com.selin.todoapp.ui.adapter.adapter.NotesAdapter
import com.selin.todoapp.utils.transition
import com.selin.todoapp.viewmodel.HomepageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel: HomepageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getNotes.observe(viewLifecycleOwner) {
            val notesAdapter = NotesAdapter(requireContext(), it, viewModel)
            binding.recyclerView.adapter = notesAdapter
        }

        binding.fabAdd.setOnClickListener {
            Navigation.transition(it, R.id.noteUpdateFragment)
        }


        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return false
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomepageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun search(searchWord: String){
        viewModel.search(searchWord)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNotes()
    }
}