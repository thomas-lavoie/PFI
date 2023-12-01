// Par Thomas Lavoie et Philip Zeng

package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pfi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Client[] clients = CreateClients();

        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean validLogin = false;
                for (int i = 0; i < clients.length; i++) {
                    if (clients[i].ValidateLogin(binding.usernameText.getText().toString(), binding.passwordText.getText().toString())) {
                        validLogin = true;
                    }
                }
                if (validLogin) {
                    Intent intent = new Intent(MainActivity.this, ProductsActivity.class);
                    intent.putExtra("username", binding.usernameText.getText().toString());
                    intent.putExtra("password", binding.passwordText.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.invalidLogin), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Crée un tableau de clients.
     * @return Un tableau de clients.
     */
    Client[] CreateClients() {
        Client[] clients = new Client[3];
        clients[0] = new Client("Thomas", "abc");
        clients[1] = new Client("Eric", "qwerty123456");
        clients[2] = new Client("Joe", "Joe");
        return clients;
    }
}