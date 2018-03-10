package mx.com.utng.colvera.loginregister;

import android.app.Application;

import com.facebook.appevents.AppEventsLogger;


public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppEventsLogger.activateApp(this);
    }
}
