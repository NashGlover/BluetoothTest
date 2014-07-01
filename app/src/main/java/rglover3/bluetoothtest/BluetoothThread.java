package rglover3.bluetoothtest;

import android.bluetooth.BluetoothAdapter;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by rglover3 on 7/1/2014.
 */
public class BluetoothThread implements Runnable {

    BluetoothAdapter adapter;
    public BluetoothThread () {
    }

    public void run() {
        System.out.println("In a thread!");
        adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter != null) {
            System.out.println("Success!");
        }
        else {
            System.out.println("Failure!");
        }
        if (adapter.isEnabled()) {
            System.out.println("It's enabled!");
        }
    }
}
