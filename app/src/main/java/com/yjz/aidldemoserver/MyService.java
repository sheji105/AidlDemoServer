package com.yjz.aidldemoserver;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;


public class MyService extends Service {
    public static final String TAG = "AidlDemoServer";
    public static final String VER = "V0.0.1";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return binder;
    }

    Binder binder = new IMyAidlInterface.Stub(){
        public String  GetVersion(){
            Log.i(TAG, "Thread: " + Thread.currentThread().getName());
            Log.i(TAG, "GetVersion "+VER);

            return VER;
        }
        public void basicTypes(int anInt, long aLong, boolean aBoolean,
                               float aFloat, double aDouble, String aString) {
            Log.i(TAG, "Thread: " + Thread.currentThread().getName());
        }
    };
}
