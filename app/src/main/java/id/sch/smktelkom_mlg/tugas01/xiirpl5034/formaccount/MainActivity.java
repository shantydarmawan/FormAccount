package id.sch.smktelkom_mlg.tugas01.xiirpl5034.formaccount;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNis, etNama, etAlamat;
    Button btSm;
    TextView tvHasil;
    Spinner spKelas;
    RadioButton rbLk, rbPr;
    CheckBox cbGbr, cbNul, cbBc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNis = (EditText) findViewById(R.id.editTextNis);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        rbLk = (RadioButton) findViewById(R.id.radioButtonLk);
        rbPr = (RadioButton) findViewById(R.id.radioButtonPr);
        cbBc = (CheckBox) findViewById(R.id.checkBoxBc);
        cbNul = (CheckBox) findViewById(R.id.checkBoxNul);
        cbGbr = (CheckBox) findViewById(R.id.checkBoxGbr);

        btSm = (Button) findViewById(R.id.buttonSubmit);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        btSm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPocess();
            }

            public void doPocess() {
                String hasil = null;
                String hasil2 = "\nHobi : \n";

                if (rbLk.isChecked()) {
                    hasil = rbLk.getText().toString();
                } else if (rbPr.isChecked()) {
                    hasil = rbPr.getText().toString();
                }

                int startlen = hasil2.length();
                if (cbBc.isChecked()) hasil2 += "- " + cbBc.getText() + "\n";
                if (cbNul.isChecked()) hasil2 += "- " + cbNul.getText() + "\n";
                if (cbGbr.isChecked()) hasil2 += "- " + cbGbr.getText() + "\n";
                if (hasil2.length() == startlen) hasil2 += "Tidak Ada Pilihan";

                if (isValid()) {
                    String nis = etNis.getText().toString();
                    String nama = etNama.getText().toString();
                    String alamat = etAlamat.getText().toString();

                    tvHasil.setText(
                            "NIS : " + nis + "\nKelas : " + spKelas.getSelectedItem().toString() + "\nNama : " + nama + "\nAlamat : " + alamat + "\nJenis Kelamin : " + hasil + hasil2);


                }
            }

            private boolean isValid() {
                boolean valid = true;

                String nis = etNis.getText().toString();
                String nama = etNama.getText().toString();
                String alamat = etAlamat.getText().toString();

                if (nis.isEmpty()) {
                    etNis.setError("NIS belum diisi");
                    valid = false;
                } else if (nis.length() < 2) {
                    etNis.setError("NIS tidak boleh kurang dari 2 karakter");
                    valid = false;
                } else if (nama.length() < 4) {
                    etNama.setError("Nama tidak boleh kurang dari 4 karakter");
                    valid = false;
                } else if (alamat.length() < 5) {
                    etAlamat.setError("Alamat tidak boleh kurang dari 5 karakter");
                    valid = false;
                } else {
                    etNama.setError(null);
                }
                if (nis.isEmpty()) {
                    etNama.setError("NIS belum diisi");
                    valid = false;
                } else {
                    etNama.setError(null);
                }

                return valid;


            }
        });

    }
}
