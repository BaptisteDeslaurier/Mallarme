package org.groolot.spectacle;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Vector;

import com.illposed.osc.*;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class EscalierActivity extends Activity implements OnTouchListener {
	
	Vector send = new Vector(1);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_escalier);
		
		final ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton1);
		final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar1);
		final EditText editText = (EditText) findViewById(R.id.editText1);
		final ToggleButton toggle2 = (ToggleButton) findViewById(R.id.toggleButton2);
		final SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
		final EditText editText2 = (EditText) findViewById(R.id.editText2);
		final ToggleButton toggle3 = (ToggleButton) findViewById(R.id.toggleButton3);
		final SeekBar seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
		final EditText editText3 = (EditText) findViewById(R.id.editText3);
		final ToggleButton toggle4 = (ToggleButton) findViewById(R.id.toggleButton4);
		final SeekBar seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
		final EditText editText4 = (EditText) findViewById(R.id.editText4);

		toggle.setOnTouchListener(this);
        
		editText.setEnabled(false);
		seekBar.setEnabled(false);
		editText2.setEnabled(false);
		seekBar2.setEnabled(false);
		editText3.setEnabled(false);
		seekBar3.setEnabled(false);
		editText4.setEnabled(false);
		seekBar4.setEnabled(false);
		
		toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		        if (isChecked) {
		            seekBar.setEnabled(true);
		            editText.setEnabled(true);
		    		send.add(1);
		            OSCMessage msg = new OSCMessage("/mallarme/xenakis/droite", send);
		    		OSCSend("172.16.101.65", 2727, msg);
		    		send.clear();
		        } else {
		        	seekBar.setEnabled(false);
		        	editText.setEnabled(false);
		    		send.add(0);
		            OSCMessage msg = new OSCMessage("/mallarme/xenakis/droite", send);
		    		OSCSend("172.16.101.65", 2727, msg);
		    		send.clear();
		        }
		    }
		});
		
		toggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		        if (isChecked) {
		            seekBar2.setEnabled(true);
		            editText2.setEnabled(true);
		    		send.add(1);
		            OSCMessage msg = new OSCMessage("/mallarme/xenakis/baton", send);
		    		OSCSend("172.16.101.65", 2727, msg);
		    		send.clear();
		        } else {
		        	seekBar2.setEnabled(false);
		        	editText2.setEnabled(false);
		    		send.add(0);
		            OSCMessage msg = new OSCMessage("/mallarme/xenakis/baton", send);
		    		OSCSend("172.16.101.65", 2727, msg);
		    		send.clear();
		        }
		    }
		});
		
		toggle3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		        if (isChecked) {
		            seekBar3.setEnabled(true);
		            editText3.setEnabled(true);
		    		send.add(1);
		            OSCMessage msg = new OSCMessage("/mallarme/xenakis/data", send);
		    		OSCSend("172.16.101.65", 2727, msg);
		    		send.clear();
		        } else {
		        	seekBar3.setEnabled(false);
		        	editText3.setEnabled(false);
		    		send.add(0);
		            OSCMessage msg = new OSCMessage("/mallarme/xenakis/data", send);
		    		OSCSend("172.16.101.65", 2727, msg);
		    		send.clear();
		        }
		    }
		});
		
		toggle4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		        if (isChecked) {
		            seekBar4.setEnabled(true);
		            editText4.setEnabled(true);
		    		send.add(1);
		            OSCMessage msg = new OSCMessage("/mallarme/xenakis/cercle", send);
		    		OSCSend("172.16.101.65", 2727, msg);
		    		send.clear();
		        } else {
		        	seekBar4.setEnabled(false);
		        	editText4.setEnabled(false);
		    		send.add(0);
		            OSCMessage msg = new OSCMessage("/mallarme/xenakis/cercle", send);
		    		OSCSend("172.16.101.65", 2727, msg);
		    		send.clear();
		        }
		    }
		});
		
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

			@Override 
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
				// TODO Auto-generated method stub 
				editText.setText(String.valueOf(progress));
				send.add(progress);
				OSCMessage msg = new OSCMessage("/mallarme/xenakis/droite", send);
	    		OSCSend("172.16.101.65", 2727, msg);
	    		send.clear();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			} 
		});	
		
		editText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				String txt = editText.getText().toString();
				
				// Position du curseur à la fin de la chaine de caractères
				editText.setSelection(txt.length());
				
				// Test pour voir si une CdC est présente sinon on met 0
				if(!txt.equals("") && txt.trim().length() > 0){
					seekBar.setProgress(Integer.parseInt(s.toString()));
					// Si la CdC dépasse 100 on l'a remet à 100
					if(Integer.parseInt(s.toString()) > 100){
						editText.setText("100");
						seekBar.setProgress(100);
					}
				}else{
					editText.setText("0");
					seekBar.setProgress(0);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
		
		seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

			@Override 
			public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) { 
				// TODO Auto-generated method stub 
				editText2.setText(String.valueOf(progress)); 
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar2) {
				// TODO Auto-generated method stub
				
			} 
		});	
		
		editText2.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				String txt = editText2.getText().toString();
				
				// Position du curseur à la fin de la chaine de caractères
				editText2.setSelection(txt.length());
				
				// Test pour voir si une CdC est présente sinon on met 0
				if(!txt.equals("") && txt.trim().length() > 0){
					seekBar2.setProgress(Integer.parseInt(s.toString()));
					// Si la CdC dépasse 100 on l'a remet à 100
					if(Integer.parseInt(s.toString()) > 100){
						editText2.setText("100");
						seekBar2.setProgress(100);
					}
				}else{
					editText2.setText("0");
					seekBar2.setProgress(0);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
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
			Toast.makeText(this,"Menu danseuses", Toast.LENGTH_LONG).show();
			intent = new Intent(EscalierActivity.this, MainActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_mesures:
			Toast.makeText(this,"Menu mesures", Toast.LENGTH_LONG).show();
			intent = new Intent(EscalierActivity.this, MesureActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_escaliers:
			Toast.makeText(this,"Vous êtes déjà dans ce menu", Toast.LENGTH_LONG).show();
			return true;
		case R.id.action_geometries:
			Toast.makeText(this,"Menu geometries", Toast.LENGTH_LONG).show();
			intent = new Intent(EscalierActivity.this, GeometrieActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}
}
