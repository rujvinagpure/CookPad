package com.example.cookpad.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.cookpad.R


class FragmentOne : Fragment() {

    lateinit var tv_fragment_name: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_one, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        tv_fragment_name = view.findViewById(R.id.tv_fragment_name)

      tv_fragment_name.text="Fragment One"
    }

    }
