package com.example.mobilna;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText    number;
    private EditText    name;
    private EditText   surname;
    private RadioGroup eye_color;
    private Button     submit_button;
    private ImageView  image_person;

    private ImageView  image_touch;
    private TextView log_result;

    private PassportValidator validator;

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

        number        = findViewById(R.id.editNumer);
        name          = findViewById(R.id.editImie);
        surname       = findViewById(R.id.editNazwisko);
        eye_color     = findViewById(R.id.radioGroupKolorOczu);
        submit_button = findViewById(R.id.buttonOk);

        image_person = findViewById(R.id.imageZdjecie);
        image_touch = findViewById(R.id.imageOdcisk);
        log_result = findViewById(R.id.log_result);

        validator = new PassportValidator();

        submit_button.setOnClickListener(v -> {
            String name = this.name.getText().toString();
            String surname = this.surname.getText().toString();
            int selected_id = this.eye_color.getCheckedRadioButtonId();

            RadioButton selectedRadioButton = findViewById(selected_id);
            String eyeColorText = selectedRadioButton.getText().toString();

            show_info(name, surname, eyeColorText);
        });

        number.setOnFocusChangeListener((view, hasFocus) -> {
            if (!number.getText().toString().isEmpty())
            {
                String image_number_prefix =  number.getText().toString();
                change_img(image_number_prefix);
            }
        });
    }
//    **********************************************
//        nazwa funkcji: <change_img>
//        opis funkcji: <funkcja zmienia obraz na podstawie inputa>
//        parametry: <img_prefix -> prefix do zmiany obrazu>
//        zwracany typ i opis: <brak>
//        autor: <777777777777777>
//    ***********************************************
    void change_img(String img_prefix)
    {
        String numberValidator = validator.validate_number(Integer.parseInt(img_prefix));

        if (!numberValidator.isEmpty())
        {
            Toast.makeText(this, numberValidator, Toast.LENGTH_SHORT).show();
            log_result.setText(numberValidator);
            Log.d("KOMUNIKAT", numberValidator);
            return;
        }
        switch(img_prefix)
        {
            case "0":
                image_person.setImageResource(R.drawable.zdjecia0);
                image_touch.setImageResource(R.drawable.odcisk0);
                break;

            case "1":
                image_person.setImageResource(R.drawable.zdjecia1);
                image_touch.setImageResource(R.drawable.odcisk1);
                break;

            case "2":
                image_person.setImageResource(R.drawable.zdjecie2);
                image_touch.setImageResource(R.drawable.odcisk2);
                break;

        }
    }

    void show_info(String name, String surname, String eye_color)
    {
        String nameValidator = validator.validate_input(name);
        String surnameValidator = validator.validate_input(surname);

        if (!nameValidator.isEmpty())
        {
            Toast.makeText(this, nameValidator, Toast.LENGTH_SHORT).show();
            log_result.setText(nameValidator);
            Log.d("KOMUNIKAT", nameValidator);
            return;
        }

        if (!surnameValidator.isEmpty())
        {
            Toast.makeText(this, surnameValidator, Toast.LENGTH_SHORT).show();
            log_result.setText(surnameValidator);
            Log.d("KOMUNIKAT", surnameValidator);
            return;
        }

        String whole_text = String.format("%s %s kolor oczu %s", name, surname, eye_color);
        Toast.makeText(this, whole_text, Toast.LENGTH_SHORT).show();
    }
}