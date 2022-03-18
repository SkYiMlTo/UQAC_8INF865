package com.example.project_uqac.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.project_uqac.R

class PostFragmentDescriptionObjet : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_post_description_objet, container, false)

        val buttonPrev : ImageButton = view.findViewById(R.id.imageButtonprevdescriptionObjet)
        buttonPrev.setOnClickListener(){
            val fragment = PostFragmentType()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.post_fragment_navigation, fragment)?.commit()
        }

        val buttonNext : ImageButton = view.findViewById(R.id.imageButtonnextdescriptionObjet)
        buttonNext.setOnClickListener(){
            val fragment = PostFragmentDateObjet()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.post_fragment_navigation, fragment)?.commit()
        }

        return view
    }
}