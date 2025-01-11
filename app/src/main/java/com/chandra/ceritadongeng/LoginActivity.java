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

public class LoginActivity extends AppCompatActivity {

    // Deklarasi variabel untuk input dan tombol
    private TextInputEditText inputUser, inputPassword;
    private MaterialButton btnLogin, btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Hubungkan variabel dengan komponen XML
        inputUser = findViewById(R.id.inputUser);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        // Tambahkan aksi untuk tombol Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAndLogin();
            }
        });

        // Tambahkan aksi untuk tombol Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToRegister();
            }
        });
    }

    private void validateAndLogin() {
        // Ambil nilai dari input
        String username = inputUser.getText().toString().trim();
        String password = inputPassword.getText().toString();

        // Validasi input
        if (username.isEmpty()) {
            inputUser.setError("Username tidak boleh kosong");
            inputUser.requestFocus();
        } else if (password.isEmpty()) {
            inputPassword.setError("Password tidak boleh kosong");
            inputPassword.requestFocus();
        } else if (password.length() < 6) {
            inputPassword.setError("Password minimal 6 karakter");
            inputPassword.requestFocus();
        } else {
            // Jika validasi berhasil
            Toast.makeText(LoginActivity.this, "Login berhasil!", Toast.LENGTH_SHORT).show();

            // Navigasi ke halaman utama (contoh: MainActivity)
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Mengakhiri aktivitas Login
        }
    }

    private void navigateToRegister() {
        // Navigasi ke halaman Register
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
