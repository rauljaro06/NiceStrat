package com.example.nicestrat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        WebView myContext = findViewById(R.id.visitaweb);
        registerForContextMenu(myContext);

        swipeLayout = findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        miVisorWeb = (WebView) findViewById(R.id.visitaweb);
        //String html2 = "<html><body><h1>Hola Mundo</h1><br><br><br><br><br><p>Esto es una prueba de WebView</p><img alt='NO CARGA NI MIERDA' src='https://thispersondoesnotexist.com' /></body></html>";
        //miVisorWeb.loadDataWithBaseURL(null, html2, "text/html", "UTF-8", null);
        String html = "<html>" +
                "<head><style>" +
                "html, body { margin:0; padding:0; height:100%; overflow:hidden; }" +
                "img { width:100%; height:100%; object-fit:cover; }" +   // ❤️ el equivalente a centerCrop
                "</style></head>" +
                "<body>" +
                "<img src='https://thispersondoesnotexist.com' />" +
                "</body></html>";
        String html2 = "<html><body><h1>Hola Mundo</h1><br><br><p>Esto es una prueba de WebView</p><iframe src='https://thispersondoesnotexist.com' width='100%' height='300'></iframe></body></html>";
        miVisorWeb.loadDataWithBaseURL("https://", html, "text/html", "UTF-8", null);
    }

    public void showAlertDialogButtonClicked(MainActivity mainActivity) {


        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);


        builder.setTitle("Dialogo");
        builder.setMessage("¿What u want?");
        builder.setIcon(R.drawable.usericon);
        builder.setCancelable(true);



        builder.setPositiveButton("Scrolling", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Nothing", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, MainBar.class);
                startActivity(intent);
            }
        });

        builder.setNeutralButton("Other", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    public boolean onContextItemSelected(MenuItem item){
        if (item.getItemId() == R.id.item1) {
            Toast toast= Toast.makeText(this, "Item copied", Toast.LENGTH_SHORT);
            toast.show();
        } else if (item.getItemId() == R.id.item2) {
            Toast toast2= Toast.makeText(this, "Downloading item", Toast.LENGTH_SHORT);
            toast2.show();
        }
        return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Toast toast= Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
            toast.show();
        } else if (id == R.id.item2) {
            Toast toast2= Toast.makeText(this, "Copy", Toast.LENGTH_SHORT);
            toast2.show();
        } else if (id == R.id.item4)
        {
            Intent intent = new Intent(MainActivity.this, MainBar.class);
            startActivity(intent);
        }

        if (id == R.id.item3)
        {
            showAlertDialogButtonClicked(MainActivity.this);
        }
        return super.onOptionsItemSelected(item);
    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        public void onRefresh() {
            //Toast toast0 = Toast.makeText(MainActivity.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
            //toast0.show();

            final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);


            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_SHORT)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();

            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };
}