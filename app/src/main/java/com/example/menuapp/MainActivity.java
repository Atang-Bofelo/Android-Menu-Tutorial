package com.example.menuapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        relativeLayout = new RelativeLayout(this);
        relativeLayout.setOnCreateContextMenuListener(this);
        setContentView(relativeLayout);
    }

    public void showEditTextDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SetUp User");
        builder.setMessage("Enter name");
        EditText usernameInput = new EditText(this);
        usernameInput.setHint("...your name");
        usernameInput.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(usernameInput);
        builder.setPositiveButton("OK", (dialogInterface, i) -> {
            String username = usernameInput.getText().toString();
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });
        builder.setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.cancel());
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.red_bg:
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.red));
                return true;
            case R.id.green_bg:
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.green));
                return true;
            case R.id.blue_bg:
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.blue));
                return true;
            case R.id.user_profile:
                showEditTextDialog();
                return true;
            default:
                return false;
        }
    }

}