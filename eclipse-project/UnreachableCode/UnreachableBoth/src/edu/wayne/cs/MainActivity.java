package edu.wayne.cs;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name UnreachableBoth
 * @author Wayne State University,
 * @author_mail zhenyu.ning@wayne.edu
 * 
 * @description Both source and sink are unreachable.
 * @dataflow
 * @number_of_leaks 0
 * @challenges The analysis should detect that some branches are unreachable.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();
        String id = "none";
        if (r.nextInt(30) > 40) {
            TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
            id = tm.getDeviceId(); // unreachable source
        } else {
            id = "None";
        }

        switch (r.nextInt(10)) {
        case 21:
            Log.d("DroidBench", id); // unreachable sink
            break;
        }
    }
}
