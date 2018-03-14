package com.sas_apps.contactdialog;
/*
 * Created by Shashank Shinde.
 */

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactDialog {

    private static final String TAG = "ContactDialog";
    private Button buttonOption1, buttonOption2;
    private TextView textName, textSubtext;
    private LinearLayout layoutBackground;
    private CircleImageView imageContact;
    private OnDialogClickListener onOption1Click;
    private OnDialogClickListener onOption2Click;
    private Dialog dialog;


    public ContactDialog(Context context, String name, String subText, String option1, String option2, int option1Drawable,
                         int option2Drawable, int imageResource, int backgroundColor, boolean cancelable) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_dialog);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        init();
        dialog.setCanceledOnTouchOutside(cancelable);
        setName(name);
        setSubText(subText);
        setOptionDrawables(option1Drawable,option2Drawable);
        setOption1Text(option1);
        setOption2Text(option2);
        setContactImageResource(imageResource);
        setBackgroundColor(backgroundColor);
        initEvents();
    }


    public ContactDialog(Context context, String name, String subText, String option1, String option2, int option1Drawable,
                         int option2Drawable, Bitmap imageBitmap, int
                                 backgroundColor, boolean cancelable) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_dialog);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        init();
        dialog.setCanceledOnTouchOutside(cancelable);
        setName(name);
        setSubText(subText);
        setOption1Text(option1);
        setOption2Text(option2);
        setOptionDrawables(option1Drawable,option2Drawable);
        setContactImageBitmap(imageBitmap);
        setBackgroundColor(backgroundColor);
    }

    public ContactDialog(Context context, String name, String subText, String option1, String option2, int option1Drawable,
                         int option2Drawable, Drawable imageDrawable, int
                                 backgroundColor, boolean cancelable) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_dialog);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        init();
        dialog.setCanceledOnTouchOutside(cancelable);
        setName(name);
        setSubText(subText);
        setOption1Text(option1);
        setOption2Text(option2);
        setOptionDrawables(option1Drawable,option2Drawable);
        setContactImageDrawable(imageDrawable);
        setBackgroundColor(backgroundColor);
    }

    public ContactDialog(Context context, String name, String subText, String option1, String option2, int option1Drawable,
                         int option2Drawable, Uri imageUri, int
                                 backgroundColor, boolean cancelable) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_dialog);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        init();
        dialog.setCanceledOnTouchOutside(cancelable);
        setName(name);
        setSubText(subText);
        setOption1Text(option1);
        setOption2Text(option2);
        setContactImageUri(imageUri);
        setBackgroundColor(backgroundColor);
    }

    public void init() {
        buttonOption1 = dialog.findViewById(R.id.button_dialogOption1);
        buttonOption2 = dialog.findViewById(R.id.button_dialogOption2);
        textName = dialog.findViewById(R.id.text_dialogName);
        textSubtext = dialog.findViewById(R.id.text_dialogNumber);
        layoutBackground = dialog.findViewById(R.id.linearLayout_background);
        imageContact = dialog.findViewById(R.id.image_dialogContact);
    }

    public void initEvents() {
        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onOption1Click != null) {
                    onOption1Click.OnClickListener(ContactDialog.this);
                }
            }
        });

        buttonOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onOption2Click != null) {
                    onOption2Click.OnClickListener(ContactDialog.this);
                }
            }
        });
    }

    public void setName(String name) {
        this.textName.setText(name);
    }

    public void setSubText(String subText) {
        this.textSubtext.setText(subText);
    }

    public void setOption1Text(String option1) {
        this.buttonOption1.setText(option1);
    }

    public void setOption2Text(String option2) {
        this.buttonOption2.setText(option2);
    }

    public void setContactImageResource(int imageResource) {
        this.imageContact.setImageResource(imageResource);
    }


    private void setOptionDrawables(int drawable1,int drawable2) {
        buttonOption1.setCompoundDrawablesWithIntrinsicBounds(drawable1, 0, 0, 0);
        buttonOption2.setCompoundDrawablesWithIntrinsicBounds(drawable2, 0, 0, 0);
    }

    public void setContactImageBitmap(Bitmap imageBitmap) {
        this.imageContact.setImageBitmap(imageBitmap);
    }

    public void setContactImageUri(Uri imageUri) {
        this.imageContact.setImageURI(imageUri);
    }

    public void setContactImageDrawable(Drawable imageDrawable) {
        this.imageContact.setImageDrawable(imageDrawable);
    }

    public void setBackgroundColor(int backgroundColor) {
        this.layoutBackground.setBackgroundColor(backgroundColor);
    }

    public void setOption1Click(OnDialogClickListener clickListener) {
        this.onOption1Click = clickListener;
    }

    public void setOption2Click(OnDialogClickListener clickListener) {
        this.onOption2Click = clickListener;
    }

    public void show() {
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }
}
