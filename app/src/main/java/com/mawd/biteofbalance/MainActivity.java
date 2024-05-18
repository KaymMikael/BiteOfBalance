package com.mawd.biteofbalance;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText input_username, input_password;
    private Button button_login, button_guest;

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

        //initialized Edittext
        input_username = findViewById(R.id.input_username);
        input_password = findViewById(R.id.input_password);

        //initialized Button
        button_login = findViewById(R.id.button_login);
        button_guest = findViewById(R.id.button_guest);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = input_username.getText().toString();
                String password = input_password.getText().toString();

                if (username.isEmpty() && password.isEmpty()) {
                    showmessage("No Inputted Username & Password");
                } else if (username.isEmpty()) {
                    showmessage("No Inputted Username");
                } else if (password.isEmpty()) {
                    showmessage("No Inputted Password");
                }

            }
        });

        button_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showmessage("Welcome Anonymous:)");
            }
        });
    }

    private void showmessage (String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}