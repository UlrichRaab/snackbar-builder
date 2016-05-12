package de.ulrichraab.snackbar;


import android.support.design.widget.Snackbar;
import android.view.View;


/**
 * Builder for {@link Snackbar} instances.
 * @author Ulrich Raab
 */
public class SnackbarBuilder {


   private SnackbarAction action;
   private Snackbar.Callback callback;
   private View container;
   private int duration;
   private String message;
   private SnackbarStyle style;


   public SnackbarBuilder () {
      duration = Snackbar.LENGTH_SHORT;
   }

   public SnackbarBuilder action (SnackbarAction action) {
      this.action = action;
      return this;
   }

   public SnackbarBuilder callback (Snackbar.Callback callback) {
      this.callback = callback;
      return this;
   }

   public SnackbarBuilder container (View container) {
      this.container = container;
      return this;
   }

   public SnackbarBuilder duration (int duration) {
      this.duration = duration;
      return this;
   }

   public SnackbarBuilder message (String message) {
      this.message = message;
      return this;
   }

   public SnackbarBuilder style (SnackbarStyle style) {
      this.style = style;
      return this;
   }

   /**
    * Builds the snackbar if properly configured.
    * @return The snackbar or {@code null} if building the snackbar is not possible.
    */
   public Snackbar build () {
      if (container == null) {
         return null;
      }
      if (message == null || message.isEmpty()) {
         return null;
      }
      // Create a new snackbar
      Snackbar snackbar = Snackbar.make(container, message, duration);
      // Set the action if not null
      if (action != null) {
         snackbar.setAction(action.title(), action.onClickListener());
      }
      // Set the callback if not null
      if (callback != null) {
         snackbar.setCallback(callback);
      }
      // Apply the style if not null
      if (style != null) {
         style.applyOn(snackbar);
      }
      return snackbar;
   }
}
