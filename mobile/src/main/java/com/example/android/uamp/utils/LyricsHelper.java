package com.example.android.uamp.utils;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import com.example.android.uamp.R;

import java.util.ArrayList;

/**
 * Created by nils on 11/6/2016.
 */

public class LyricsHelper extends ListActivity {
    private ArrayList<String> lyrics = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    public LyricsHelper(){
//        setContentView(R.layout.activity_full_player);
        adapter = new ArrayAdapter<String>(this, R.layout.activity_full_player, lyrics);
        setListAdapter(adapter);
//        lyrics.add("something");
//        adapter.notifyDataSetChanged();
    }

}
