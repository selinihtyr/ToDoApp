package com.selin.todoapp.ui.adapter.adapter

import android.content.Context
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.selin.todoapp.R
import com.selin.todoapp.databinding.CardDesignBinding
import com.selin.todoapp.data.entity.Notes
import com.selin.todoapp.ui.fragment.HomepageFragment
import com.selin.todoapp.ui.fragment.HomepageFragmentDirections
import com.selin.todoapp.ui.fragment.NoteDetailFragment
import com.selin.todoapp.utils.transition
import com.selin.todoapp.viewmodel.HomepageViewModel

class NotesAdapter (var mContext: Context, var notesList: List<Notes>, var viewModel:HomepageViewModel) : RecyclerView.Adapter<NotesAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val note = notesList.get(position)
        val d = holder.design
        d.tvTitle.text = note.note_title

        d.checkBox.setOnClickListener {
            Snackbar.make(it, "${note.note_title} delete it?", Snackbar.LENGTH_SHORT).setAction("delete") {
                delete(note.note_id)
            }.show()
        }

        d.tvTitle.setOnClickListener {
            val gecis = HomepageFragmentDirections.detayGecis(note)
            Navigation.transition(it, gecis)
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    fun delete(note_id: Int){
        viewModel.delete(note_id)
    }
}