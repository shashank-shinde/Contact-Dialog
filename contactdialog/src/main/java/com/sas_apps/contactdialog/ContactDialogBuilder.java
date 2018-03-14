package com.sas_apps.contactdialog;
/*
 * Created by Shashank Shinde.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

public class ContactDialogBuilder {

    private Context context;
    private OnDialogClickListener onOption1Click;
    private OnDialogClickListener onOption2Click;
    private boolean cancelable;
    private int color, imageResource, option1Drawable, option2Drawable;
    private Bitmap imageBitmap;
    private Uri imageUri;
    private Drawable imageDrawable;
    private String name, subText, option1Text, option2Text;

    public ContactDialogBuilder(Context context) {
        this.context = context;
    }

    public ContactDialogBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ContactDialogBuilder setSubText(String SubText) {
        this.subText = SubText;
        return this;
    }

    public ContactDialogBuilder setOption1Text(String text) {
        this.option1Text = text;
        return this;
    }

    public ContactDialogBuilder setOption2Text(String text) {
        this.option2Text = text;
        return this;
    }

    public ContactDialogBuilder setBackgroundColor(int color) {
        this.color = color;
        return this;
    }

    public ContactDialogBuilder setImageResource(int resource) {
        this.imageResource = resource;
        return this;
    }

    public ContactDialogBuilder setOption1Drawable(int drawable) {
        this.option1Drawable = drawable;
        return this;
    }

    public ContactDialogBuilder setOption2Drawable(int drawable) {
        this.option2Drawable = drawable;
        return this;
    }

    public ContactDialogBuilder setImageUri(Uri uri) {
        this.imageUri = uri;
        return this;
    }


    public ContactDialogBuilder setImageBitmap(Bitmap bitmap) {
        this.imageBitmap = bitmap;
        return this;
    }

    public ContactDialogBuilder setImageDrawable(Drawable drawable) {
        this.imageDrawable = drawable;
        return this;
    }

    public ContactDialogBuilder setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        return this;
    }

    public ContactDialogBuilder setOnOption1ClickListener(OnDialogClickListener dialogClickListener1) {
        this.onOption1Click = dialogClickListener1;
        return this;
    }

    public ContactDialogBuilder setOnOption2ClickListener(OnDialogClickListener dialogClickListener) {
        this.onOption2Click = dialogClickListener;
        return this;
    }

    public ContactDialog build() {
        ContactDialog dialog = null;
        if (imageResource != 0) {
            dialog = new ContactDialog(context, name, subText, option1Text, option2Text, option1Drawable, option2Drawable,
                    imageResource, color, cancelable);
        } else if (imageDrawable != null) {
            dialog = new ContactDialog(context, name, subText, option1Text, option2Text, option1Drawable, option2Drawable,
                    imageDrawable, color, cancelable);
        } else if (imageUri != null) {
            dialog = new ContactDialog(context, name, subText, option1Text, option2Text, option1Drawable, option2Drawable,
                    imageUri, color, cancelable);
        } else if (imageBitmap != null) {
            dialog = new ContactDialog(context, name, subText, option1Text, option2Text, option1Drawable, option2Drawable,
                    imageBitmap, color, cancelable);
        }

        assert dialog != null;
        dialog.setOption1Click(onOption1Click);
        dialog.setOption2Click(onOption2Click);

        return dialog;
    }
}
