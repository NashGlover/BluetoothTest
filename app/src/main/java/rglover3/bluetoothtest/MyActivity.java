package rglover3.bluetoothtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MyActivity extends Activity {

    BluetoothThread blueThread = null;
    public Handler _handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            System.out.println("Handling message thread : " + Thread.currentThread().getName());
            Bundle bundle = msg.getData();
            System.out.println(String.format("Handler.handleMessage(): msg=%s", bundle.getString("Test")));
            // This is where main activity thread receives messages
            // Put here your handling of incoming messages posted by other threads
            super.handleMessage(msg);
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //(new Thread(new BluetoothThread())).start();
        System.out.println("Current thread = " + Thread.currentThread().getName());
        blueThread = new BluetoothThread(_handler);
        blueThread.start();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendString(View view) {
        blueThread.sendString();
    }
}
