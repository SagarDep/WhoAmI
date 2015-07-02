package kr.co.sangcomz.whoami.ui.main.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.sangcomz.whoami.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyAlbum extends Fragment {


    public MyAlbum() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_album, container, false);
    }


}
