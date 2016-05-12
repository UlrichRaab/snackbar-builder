package de.ulrichraab.snackbar;


import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;


/**
 * TODO Write javadoc
 * @author Ulrich Raab
 */
public class SnackbarStyle {

   private static final int VIEW_ID_ACTION = android.support.design.R.id.snackbar_action;
   private static final int VIEW_ID_MESSAGE = android.support.design.R.id.snackbar_text;
   private static final String TYPEFACE_ROBOTO_MEDIUM = "Roboto-Medium.ttf";

   private int actionBgColorId;
   private int snackbarBgColorId;
   private int textColorId;

   /**
    * Creates a new {@link SnackbarStyle} instance.
    * @param snackbarBgColorId The id of the background color.
    * @param actionBgColorId The id of the action background color.
    * @param textColorId The text color of the message text and action text.
    */
   public SnackbarStyle (int snackbarBgColorId, int actionBgColorId, int textColorId) {
      this.snackbarBgColorId = snackbarBgColorId;
      this.actionBgColorId = actionBgColorId;
      this.textColorId = textColorId;
   }

   /**
    * Applies this style on the specified snackbar.
    * @param snackbar The snackbar on which to apply the style.
    */
   @SuppressWarnings("deprecation")
   public void applyOn (@NonNull Snackbar snackbar) {
      // Get the views
      View snackbarView = snackbar.getView();
      TextView actionView = (TextView) snackbarView.findViewById(VIEW_ID_ACTION);
      TextView messageView = (TextView) snackbarView.findViewById(VIEW_ID_MESSAGE);
      // Get the context
      Context context = snackbarView.getContext();
      // Set the typeface ot the action view to Roboto Medium if API < 21
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
         Typeface actionTypeface = getActionTypeface(context);
         actionView.setTypeface(actionTypeface);
      }
      // Update the background colors
      snackbarView.setBackgroundResource(snackbarBgColorId);
      actionView.setBackgroundResource(actionBgColorId);
      // Update the text colors
      Resources res = context.getResources();
      ColorStateList textColor = res.getColorStateList(textColorId);
      actionView.setTextColor(textColor);
      messageView.setTextColor(textColor);
   }

   /**
    * Returns the action typeface (Roboto Medium).
    */
   private Typeface getActionTypeface (@NonNull Context context) {
      AssetManager assetManager = context.getAssets();
      return Typeface.createFromAsset(assetManager, TYPEFACE_ROBOTO_MEDIUM);
   }
}
