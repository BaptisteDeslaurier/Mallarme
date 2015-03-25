package org.groolot.spectacle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class GeometrieActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_geometrie);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {
		case R.id.action_danseuses:
			Toast.makeText(this,"Menu danseuses", Toast.LENGTH_LONG).show();
			intent = new Intent(GeometrieActivity.this, MainActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_mesures:
			Toast.makeText(this,"Menu mesures", Toast.LENGTH_LONG).show();
			intent = new Intent(GeometrieActivity.this, MesureActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_escaliers:
			Toast.makeText(this,"Menu escaliers", Toast.LENGTH_LONG).show();
			intent = new Intent(GeometrieActivity.this, EscalierActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_geometries:
			Toast.makeText(this,"Vous êtes déjà dans ce menu", Toast.LENGTH_LONG).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}