package de.ulrichraab.snackbar.app;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import de.ulrichraab.snackbar.SnackbarBuilder;
import de.ulrichraab.snackbar.SnackbarStyle;


public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate (Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
   }

   @Override
   protected void onResume () {
      super.onResume();
      View snackbarContainer = findViewById(android.R.id.content);
      SnackbarStyle errorStyle = createErrorSnackbarStyle();
      new SnackbarBuilder().container(snackbarContainer)
                           .message("test")
                           .style(errorStyle)
                           .duration(Snackbar.LENGTH_INDEFINITE)
                           .build()
                           .show();
   }


   private SnackbarStyle createErrorSnackbarStyle () {
      return new SnackbarStyle(R.color.red, R.color.red, R.color.white);
   }
}
