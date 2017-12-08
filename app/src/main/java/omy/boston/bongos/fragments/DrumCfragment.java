package omy.boston.bongos.fragments;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import omy.boston.bongos.R;

/**
 * Created by LosFrancisco on 05-May-17.
 */

public class DrumCfragment extends Fragment{

    private SoundPool soundPoolL;
    private SoundPool soundPoolR;
    private int soundIDL;
    private int soundIDR;
    private boolean loadedL = false;
    private boolean loadedR = false;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public DrumCfragment() {
    }

    public static DrumCfragment newInstance(int sectionNumber) {
        DrumCfragment fragment = new DrumCfragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drumc, container, false);

        ImageView leftBongoDrum = (ImageView) rootView.findViewById(R.id.left_bongoDrum);
        leftBongoDrum.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (loadedL){
                    soundPoolL.play(soundIDL, 1.0f, 1.0f, 1, 0, 1.0f);

                }
                return false;
            }
        });
        soundPoolL = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPoolL.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPoolL, int sampleIdL, int status) {
                loadedL = true;
            }
        });

        setDrumSoundL();

        ImageView rightBongoDrum= (ImageView) rootView.findViewById(R.id.right_bongoDrum);
        rightBongoDrum.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (loadedR){
                    soundPoolR.play(soundIDR, 1.0f, 1.0f, 1, 0, 1.0f);

                }
                return false;
            }
        });
        soundPoolR = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPoolR.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPoolR, int sampleIdR, int status) {
                loadedR = true;
            }
        });

        setDrumSoundR();

        return rootView;
    }

    public void setDrumSoundL(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        int musicIDL;

        if(sp.getBoolean("checkedBass", false)){
            musicIDL = R.raw.bass_deep;
        }else {
            musicIDL = R.raw.bongo_deep;
        }

        soundIDL = soundPoolL.load(getActivity(), musicIDL, 1);
    }

    public void setDrumSoundR(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        int musicIDR;

        if(sp.getBoolean("checkedBass", false)){
            musicIDR = R.raw.bass_shalow;
        }else {
            musicIDR = R.raw.bongo_shalow;
        }

        soundIDR = soundPoolR.load(getActivity(), musicIDR, 1);
    }

    @Override
    public void onResume() {
        super.onResume();
        setDrumSoundL();
        setDrumSoundR();
    }
}
