package com.example.prac5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.prac5.databinding.FragmentMainBinding;
import com.example.prac5.databinding.FragmentSongsBinding;


public class SongsFragment extends Fragment {

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSongsBinding binding = FragmentSongsBinding.inflate(inflater, container, false);
        String album = getArguments().getString("album");
        String str = album.toLowerCase().replace(" ", "_");

        int resourceId = getResources().getIdentifier(str, "array", getContext().getPackageName());
        String[] items = getResources().getStringArray(resourceId);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_expandable_list_item_1, items);
        binding.listView.setAdapter(adapter);

        return binding.getRoot();
    }
}