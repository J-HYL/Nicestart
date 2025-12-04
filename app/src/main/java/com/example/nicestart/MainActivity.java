package com.example.nicestart;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //TextView mycontext = findViewById(R.id.tv_dashboard_title);
        //registerForContextMenu(mycontext);

        WebView mycontextWeb = findViewById(R.id.vistaweb);

        registerForContextMenu(mycontextWeb);

        swipeLayout = findViewById(R.id.sr_main_swipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);


        //  Webview cargando HTML para que la imagen ocupe todò el activity

        miVisorWeb = (WebView) findViewById(R.id.vistaweb);

        String html = "<html>" +
                "<head><style>" +
                "html, body { margin:0; padding:0; height:100%; overflow:hidden; }" +
                "img { width:100%; height:100%; object-fit:cover; }" +
                "</style></head>" +
                "<body>" +
                "<img src='https://thispersondoesnotexist.com' />" +
                "</body></html>";

        miVisorWeb.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
            toast.show();
        } else if (item.getItemId() == R.id.item2) {
            Toast toast2 = Toast.makeText(this, "Downloading item...", Toast.LENGTH_LONG);
            toast2.show();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resource_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.camera) {
            showAlertDialogButtonClicked(MainActivity.this);
        }
        return super.onOptionsItemSelected(item);
    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(MainActivity.this, "Imagen cambiada!", Toast.LENGTH_LONG);
            toast0.show();
            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    // ALERT DIALOG
    public void showAlertDialogButtonClicked(MainActivity view) {
        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

        builder.setTitle("Achtung!");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.ic_action_name);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                dialog.dismiss();
                Toasty.success(MainActivity.this, "Success!", Toast.LENGTH_SHORT, true).show();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                dialog.dismiss();
                finishAffinity();
            }
        });
        builder.setNeutralButton("Can’t say", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
