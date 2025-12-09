// java
package com.example.nicestrat;

import android.annotation.SuppressLint;
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

    @SuppressLint("MissingInflatedId")
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
        String html = "<html>" +
                "<head><style>" +
                "html, body { margin:0; padding:0; height:100%; overflow:hidden; }" +
                "img { width:100%; height:100%; object-fit:cover; }" +   // ❤️ el equivalente a centerCrop
                "</style></head>" +
                "<body>" +
                "<img src='https://thispersondoesnotexist.com' />" +
                "</body></html>";
        miVisorWeb.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);


    }

    public void showAlertDialogButtonClicked(MainActivity mainActivity) {


        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);


        builder.setTitle("Dialogo");
        builder.setMessage("¿Que quieres hacer?");
        builder.setIcon(R.drawable.usericon);
        builder.setCancelable(true);



        builder.setPositiveButton("Scrolling", new DialogInterface.OnClickListener()  {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Nada", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.setNeutralButton("Otro", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Elemento")
                    .setMessage("Item copiado")
                    .setPositiveButton("OK", null)
                    .show();
            return true;
        } else if (item.getItemId() == R.id.item2) {
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Descarga")
                    .setMessage("Downloading item...")
                    .setPositiveButton("OK", null)
                    .show();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item2) {
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Ajustes")
                    .setMessage("Abrir ajustes")
                    .setPositiveButton("Abrir", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Aquí puedes abrir la actividad de ajustes si procede
                        }
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
            return true;
        } else if (id == R.id.item1) {
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Copiar")
                    .setMessage("¿Deseas copiar el elemento?")
                    .setPositiveButton("Copiar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Acción de copiar si procede
                        }
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        public void onRefresh() {
            final ConstraintLayout mLayout = findViewById(R.id.myswipe);

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