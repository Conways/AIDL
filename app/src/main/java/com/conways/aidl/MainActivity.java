package com.conways.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button connect;
    private Button add;
    private Button del;
    private Button get;
    private Button disConnect;

    private TextView count;

    private Manager manager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        connect = $(R.id.connect);
        add = $(R.id.add);
        del = $(R.id.del);
        get = $(R.id.get);
        disConnect = $(R.id.disconnect);
        count= $(R.id.count);

        connect.setOnClickListener(this);
        add.setOnClickListener(this);
        del.setOnClickListener(this);
        get.setOnClickListener(this);
        disConnect.setOnClickListener(this);

        disConnect.setEnabled(false);
        add.setEnabled(false);
        del.setEnabled(false);
        get.setEnabled(false);
        disConnect.setEnabled(false);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            manager = Manager.Stub.asInterface(service);
            if (manager!=null){
                add.setEnabled(true);
                del.setEnabled(true);
                get.setEnabled(true);
                disConnect.setEnabled(true);
                connect.setEnabled(false);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            add.setEnabled(false);
            del.setEnabled(false);
            get.setEnabled(false);
            disConnect.setEnabled(false);
            connect.setEnabled(true);
        }
    };


    protected <T extends View> T $(int id) {
        return (T) findViewById(id);
    }
    long i=0;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.connect:
                this.bindService(new Intent(this, MyService.class), connection, Context
                        .BIND_AUTO_CREATE);
                break;
            case R.id.add:
                try{
                    manager.addEmployee(++i);
                }catch (Exception e){

                }
                break;
            case R.id.del:
                break;
            case R.id.get:
                try{
                    long i=manager.getEmployee().getId();
                    count.setText(i+"");
                }catch (Exception e){

                }
                break;
            case R.id.disconnect:
                this.unbindService(connection);
                break;

            default:
                break;


        }
    }
}
