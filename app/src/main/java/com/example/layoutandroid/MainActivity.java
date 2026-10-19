package com.example.layoutandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false); // diseño a pantalla completa
        setContentView(R.layout.activity_main);

        // Respeta la barra de estado y la de navegación
        View root = findViewById(R.id.guideCard).getRootView();
        ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(0, bars.top - 40, 0, bars.bottom); // ajusta el -40 a tu gusto
            return insets;
        });

        findViewById(R.id.btnBell).setOnClickListener(v -> toast("Notificaciones"));
        findViewById(R.id.btnUrgent).setOnClickListener(v -> toast("Urgent Care"));
        findViewById(R.id.svcConsultation).setOnClickListener(v -> toast("Consultation"));
        findViewById(R.id.svcMedicines).setOnClickListener(v -> toast("Medicines"));
        findViewById(R.id.svcAmbulance).setOnClickListener(v -> toast("Ambulance"));
        findViewById(R.id.tvSeeAll).setOnClickListener(v -> toast("See All"));
        findViewById(R.id.btnMore).setOnClickListener(v -> toast("Más opciones"));
        findViewById(R.id.navAdd).setOnClickListener(v -> toast("Nueva cita"));
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
