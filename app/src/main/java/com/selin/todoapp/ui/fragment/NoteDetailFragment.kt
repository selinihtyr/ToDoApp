package com.selin.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.selin.todoapp.R
import com.selin.todoapp.databinding.FragmentNoteDetailBinding
import com.selin.todoapp.utils.transition
import com.selin.todoapp.viewmodel.HomepageViewModel
import com.selin.todoapp.viewmodel.NoteDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteDetailFragment : Fragment() {
    private lateinit var binding: FragmentNoteDetailBinding
    private lateinit var viewModel: NoteDetailViewModel
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteDetailBinding.inflate(layoutInflater)

         val bundle: NoteDetailFragmentArgs by navArgs()
         val incomingNote = bundle.note
         binding.tvTitle.setText(incomingNote.note_title)

        binding.fabOkeyDetail.setOnClickListener {
            val note_title = binding.tvTitle.text.toString()
            update(incomingNote.note_id, note_title)
            Toast.makeText(requireContext(), "Note updated", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: NoteDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun update(note_id:Int, note_title: String){
        viewModel.update(note_id, note_title)
    }
}