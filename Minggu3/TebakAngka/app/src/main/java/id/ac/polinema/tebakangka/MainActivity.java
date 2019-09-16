package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini

	private int acak;
	private EditText num;
	Random random = new Random();
	private Button button;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// TODO: bind layout di sini

		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {

		acak = random.nextInt(100) + 1;

	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka

		num = findViewById(R.id.number_input);

		int masukan = Integer.parseInt(String.valueOf(num.getText()));


		if (masukan > acak){

			Toast.makeText(getApplicationContext(),"Tebakan anda terlalu besar!!!",Toast.LENGTH_LONG).show();


		}
		else if(masukan < acak){

			Toast.makeText(getApplicationContext(),"Tebakan anda terlalu kecil!!!",Toast.LENGTH_LONG).show();

		}
		else {

			Toast.makeText(getApplicationContext(),"Angka tebakan benar!!!",Toast.LENGTH_LONG).show();
			Button btn = (Button) findViewById(R.id.guess_button);
			btn.setEnabled(false);

		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		setContentView(R.layout.activity_main);
		initRandomNumber();
	}
}
