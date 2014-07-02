package rglover3.bluetoothtest;

import android.bluetooth.BluetoothAdapter;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by rglover3 on 7/1/2014.
 */
public class BluetoothThread implements Runnable {

    BluetoothAdapter adapter;

    ArrayList<BluetoothAdapter> adapterArray;

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

        Set<BluetoothDevice> pairedDevices = adapter.getBondedDevices();
        if (pairedDevices.size() > 0) {
            // Loop through paired devices
            for (BluetoothDevice device : pairedDevices) {
                System.out.println(device.getName());
            }
        }
    }

}
