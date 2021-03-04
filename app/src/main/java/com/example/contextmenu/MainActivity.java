package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;

public class MainActivity extends AppCompatActivity {

    ImageView btnclick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnclick=findViewById(R.id.btnclick);

        registerForContextMenu(btnclick);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu,menu);
        menu.setHeaderTitle("select option");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int menuId = item.getItemId();
        switch (menuId){
            case R.id.call:
                Toast.makeText(this,"call clicked",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
                break;

            case R.id.sms:
                Toast.makeText(this,"sms clicked", Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(Intent.ACTION_SEND);
                intent1.setType("message/rfc822");
                startActivity(Intent.createChooser(intent1,"select email app"));
                break;
            case R.id.website:
                Toast.makeText(this, "website is clicked", Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("https://"));
                startActivity(intent2);
        }
        return super.onContextItemSelected(item);
    }

}