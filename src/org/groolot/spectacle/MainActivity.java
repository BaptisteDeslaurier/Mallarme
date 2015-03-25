package org.groolot.spectacle;


import com.illposed.osc.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Vector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends Activity implements OnTouchListener {
   
    private ImageButton cercleA;
    private ImageButton cercleF;
    private View screen;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
       
        screen = (RelativeLayout) findViewById(R.id.main_screen);
       
        cercleA = (ImageButton) findViewById(R.id.imageButton1);
        cercleA.setOnTouchListener(this);
       
        cercleF = (ImageButton) findViewById(R.id.imageButton2);
        cercleF.setOnTouchListener(this);
    }

    public void OSCSend(final String addr, final int port, final OSCMessage msg) {
        Thread temp = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                OSCPortOut sender = new OSCPortOut(InetAddress.getByName(addr), port);
                sender.send(msg);
            } catch (SocketException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            }
        });
        temp.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

   
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
        case R.id.action_danseuses:
            Toast.makeText(this,"Vous êtes déjà dans ce menu", Toast.LENGTH_LONG).show();
            return true;
        case R.id.action_mesures:
            Toast.makeText(this,"Menu mesures", Toast.LENGTH_LONG).show();
            intent = new Intent(MainActivity.this, MesureActivity.class);
            startActivity(intent);
            return true;
        case R.id.action_escaliers:
            Toast.makeText(this,"Menu escaliers", Toast.LENGTH_LONG).show();
            intent = new Intent(MainActivity.this, EscalierActivity.class);
            startActivity(intent);
            return true;
        case R.id.action_geometries:
            Toast.makeText(this,"Menu geometries", Toast.LENGTH_LONG).show();
            intent = new Intent(MainActivity.this, GeometrieActivity.class);
            startActivity(intent);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
   
    public int limitScreen(int size, float position) {
        int new_position = (int)position - size / 2;
        return new_position;
    }
       
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        if(event.getAction() == MotionEvent.ACTION_UP) {
            if((v.getTop()+v.getHeight()) > screen.getHeight()){
                v.offsetTopAndBottom(- v.getHeight());
            }else if(v.getTop()-v.getHeight() < 0){
                v.offsetTopAndBottom(+ v.getHeight());
            }else if(v.getRight() + v.getWidth() > screen.getWidth()){
                v.offsetLeftAndRight(- v.getHeight());
            }else if(v.getRight() - v.getWidth() < 0){
                v.offsetLeftAndRight(+ v.getHeight());
            }
        }else{
            v.offsetTopAndBottom(limitScreen(v.getHeight(), event.getY()));
        }
        v.offsetLeftAndRight(limitScreen(v.getWidth(), event.getX()));
       
        float X = (float)v.getLeft() / (float)screen.getWidth() + (float)v.getWidth() / 2 / (float)screen.getWidth();
        float Y = (float)v.getTop() / (float)screen.getHeight() + (float)v.getHeight() / 2 / (float)screen.getHeight();
        /*
        Vector send = new Vector(2);
		send.add(X);
		send.add(Y);
		OSCMessage msg = new OSCMessage("/mallarme/masque/"+v.getResources().getResourceEntryName(v.getId()), send);
		OSCSend("172.16.100.176", 12345, msg);
        */
        return false;
    }
   
   
   
}