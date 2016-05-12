package de.ulrichraab.snackbar;


import android.view.View;


/**
 * TODO Write javadoc
 * @author Ulrich Raab
 */
public class SnackbarAction {

   private String title;
   private View.OnClickListener onClickListener;

   public SnackbarAction (String title, View.OnClickListener onClickListener) {
      this.title = title;
      this.onClickListener = onClickListener;
   }

   public String title () {
      return title;
   }

   public View.OnClickListener onClickListener () {
      return onClickListener;
   }
}
