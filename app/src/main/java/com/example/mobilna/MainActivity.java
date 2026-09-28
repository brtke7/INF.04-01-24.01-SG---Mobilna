package com.example.mobilna;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText number;
    private EditText name;
    private EditText surname;
    private RadioGroup eye_color;
    private Button submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.editImie);
        surname = findViewById(R.id.editNazwisko);
        eye_color = findViewById(R.id.radioGroupKolorOczu);
        submit_button = findViewById(R.id.buttonOk);

        submit_button.setOnClickListener(v -> {
            String name = this.name.getText().toString();
            String surname = this.surname.getText().toString();
            int selected_id = this.eye_color.getCheckedRadioButtonId();

            RadioButton selectedRadioButton = findViewById(selected_id);
            String eyeColorText = selectedRadioButton.getText().toString();

            show_info(name, surname, eyeColorText);
        });
    }

    void show_info(String name, String surname, String eye_color)
    {
        String whole_text = String.format("%s %s kolor oczu %s", name, surname, eye_color);
        Toast.makeText(this, whole_text, Toast.LENGTH_SHORT).show();
    }
}