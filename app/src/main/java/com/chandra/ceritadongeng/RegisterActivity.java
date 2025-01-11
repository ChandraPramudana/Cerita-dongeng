package com.chandra.ceritadongeng;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    // Deklarasi variabel untuk input dan tombol
    private TextInputEditText inputEmail, inputUser, inputPassword;
    private MaterialButton btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Hubungkan variabel dengan komponen XML
        inputEmail = findViewById(R.id.inputEmail);
        inputUser = findViewById(R.id.inputUser);
        inputPassword = findViewById(R.id.inputPassword);
        btnRegister = findViewById(R.id.btnRegister);

        // Tambahkan aksi ketika tombol Register ditekan
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAndRegister();
            }
        });
    }

    private void validateAndRegister() {
        // Ambil nilai dari input
        String email = inputEmail.getText().toString().trim();
        String username = inputUser.getText().toString().trim();
        String password = inputPassword.getText().toString();

        // Validasi input
        if (email.isEmpty()) {
            inputEmail.setError("Email tidak boleh kosong");
            inputEmail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            inputEmail.setError("Email tidak valid");
            inputEmail.requestFocus();
        } else if (username.isEmpty()) {
            inputUser.setError("Username tidak boleh kosong");
            inputUser.requestFocus();
        } else if (password.isEmpty()) {
            inputPassword.setError("Password tidak boleh kosong");
            inputPassword.requestFocus();
        } else if (password.length() < 6) {
            inputPassword.setError("Password minimal 6 karakter");
            inputPassword.requestFocus();
        } else {
            // Jika semua validasi lolos
            Toast.makeText(RegisterActivity.this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show();

            // Navigasi ke halaman berikutnya (contoh: LoginActivity)
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
