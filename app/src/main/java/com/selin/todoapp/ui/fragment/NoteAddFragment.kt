package com.selin.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.selin.todoapp.databinding.FragmentNoteAddBinding
import com.selin.todoapp.viewmodel.HomepageViewModel
import com.selin.todoapp.viewmodel.NoteAddViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteAddFragment : Fragment() {
    private lateinit var binding: FragmentNoteAddBinding
    private lateinit var viewModel: NoteAddViewModel
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteAddBinding.inflate(layoutInflater)

        binding.fabOkeyUpdate.setOnClickListener{
            val note_title = binding.tvTitle.text.toString()
            save(note_title)
            Toast.makeText(requireContext(), "Note Saved", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: NoteAddViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun save(note_title: String){
        viewModel.save(note_title)
    }
}