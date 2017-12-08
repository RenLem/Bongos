package omy.boston.bongos.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import omy.boston.bongos.R;

/**
 * Created by LosFrancisco on 06-May-17.
 */

public class SettingsPreferencesFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
