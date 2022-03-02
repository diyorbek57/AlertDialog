package com.ayizor.alertdialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

public class Utils {

    public static void showAlertDialog(Context context, String title, String description, OnAlertDialogAction dialogAction) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        View view1 = LayoutInflater.from(context).inflate(R.layout.alert_dialog_background,
                (CardView) alertDialog.findViewById(R.id.alert_dialog_card));
        alertDialog.setView(view1);
        ((TextView) view1.findViewById(R.id.alert_dialog_big_title)).setText(title);
        ((TextView) view1.findViewById(R.id.alert_dialog_title)).setText(description);
        ((TextView) view1.findViewById(R.id.alert_dialog_cencel_text)).setText(R.string.cencel);
        ((TextView) view1.findViewById(R.id.alert_dialog_ok_text)).setText(R.string.ok);

        view1.findViewById(R.id.alert_dialog_cencel).setOnClickListener(v12 -> {

            dialogAction.alertActionListener(false);
            alertDialog.dismiss();
        });
        view1.findViewById(R.id.alert_dialog_ok).setOnClickListener(v1 -> {
            dialogAction.alertActionListener(true);
            alertDialog.dismiss();
        });
        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    public interface OnAlertDialogAction {
        void alertActionListener(boolean action);
    }

    public static void fireToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
