package com.chandra.ceritadongeng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // Menggunakan layout untuk ProfileActivity

        // Menemukan Toolbar dari layout
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Menetapkan Toolbar sebagai ActionBar
        setSupportActionBar(toolbar);

        // Menambahkan aksi untuk klik pada ikon back di toolbar
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi kembali ke MainActivity
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class); // Ganti MainActivity dengan halaman utama yang sesuai
                startActivity(intent);
                finish(); // Menutup ProfileActivity agar tidak bisa kembali ke halaman ini dengan tombol back
            }
        });
    }
}
