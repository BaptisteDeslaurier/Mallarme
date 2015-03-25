package org.groolot.spectacle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class EscalierActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escalier);
		
		ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton1);
		final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar1);
		final EditText editText = (EditText) findViewById(R.id.editText1);
		
		editText.setEnabled(false);
		seekBar.setEnabled(false);
		
		toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		        if (isChecked) {
		            seekBar.setEnabled(true);
		            editText.setEnabled(true);
		        } else {
		        	seekBar.setEnabled(false);
		        	editText.setEnabled(false);
		        }
		    }
		});
		
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

			@Override 
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { 
				// TODO Auto-generated method stub 
				editText.setText(String.valueOf(progress)); 
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
				if ((txt != null) && (txt.trim().length() > 0)) {
					seekBar.setProgress(Integer.parseInt(s.toString()));
				}else{ 
					editText.setText("0");
					seekBar.setProgress(Integer.parseInt(s.toString()));
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
}
