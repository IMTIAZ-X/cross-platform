package org.libsdl.app;

import android.app.Activity;

public class SDLActivity extends Activity {
    static {
        System.loadLibrary("main");
    }
}
