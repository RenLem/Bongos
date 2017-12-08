package omy.boston.bongos.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import omy.boston.bongos.R;

public class DrumFfragment extends Fragment {

    private TextView tvMessage;
    private String name;
    private ImageView infoPicture;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public DrumFfragment() {
    }


    public static DrumFfragment newInstance(int sectionNumber) {
        DrumFfragment fragment = new DrumFfragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drumf, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        infoPicture = (ImageView) rootView.findViewById(R.id.imageView_infoPicture);
        infoPicture.setVisibility(View.INVISIBLE);
        tvMessage = (TextView) rootView.findViewById(R.id.textView_message);
        tvMessage.setText(R.string.to_easter_egg);
        getPreferences();

        return rootView;

    }

    public void getPreferences(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());

        if (sp.contains("editYourName")){
                name = sp.getString("editYourName", "");
                tvMessage.setText(getString(R.string.Before) + name + getString(R.string.after) +
                        (char)13 + (char)10 + (char)13 + (char)10 + getString(R.string.Bongo_info));
            //qLog(name);
        }

        if (name == null) {
            tvMessage.setText(R.string.to_easter_egg);
            tvMessage.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            infoPicture.setVisibility(View.INVISIBLE);
        } else {
            infoPicture.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferences();
    }

    private void qLog(String logTekst){
        Log.d("napravi Log", logTekst);
    }
}
