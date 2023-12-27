package com.example.bible.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.example.bible.FormatBibleText;
import com.example.bible.databinding.FragmentJudeBinding;



public class JudeFragment extends Fragment {

    private FragmentJudeBinding binding;
    public static int chapter = 1;
    public static int totalChapters;
    public static LinearLayout parentLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentJudeBinding.inflate(inflater, container, false);
        parentLayout = binding.parentLayout;
        totalChapters = parentLayout.getChildCount();

        FormatBibleText.format(parentLayout);

        return binding.getRoot();
    }

    public static void prevChapter() {
        if (chapter > 1) {
            chapter--;
            for (int i = 0; i < totalChapters; i++) {
                parentLayout.getChildAt(i).setVisibility(View.GONE);
                if (i == (chapter - 1)) parentLayout.getChildAt(i).setVisibility(View.VISIBLE);
            }
        }
    }

    public static void nextChapter() {
        if (chapter < totalChapters) {
            chapter++;
            for (int i = 0; i < totalChapters; i++) {
                parentLayout.getChildAt(i).setVisibility(View.GONE);
                if (i == (chapter - 1)) parentLayout.getChildAt(i).setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}