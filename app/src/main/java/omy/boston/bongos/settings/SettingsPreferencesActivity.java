package omy.boston.bongos.settings;
import android.os.Bundle;
import android.preference.PreferenceActivity;


/**
 * Created by LosFrancisco on 06-May-17.
 */

public class SettingsPreferencesActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new SettingsPreferencesFragment())
                .commit();
    }

}
