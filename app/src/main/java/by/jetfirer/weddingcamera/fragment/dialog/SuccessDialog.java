package by.jetfirer.weddingcamera.fragment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import by.jetfirer.weddingcamera.R;
import utils.Utils;

/**
 * Created by Konstantin on 09.08.2017.
 */

public class SuccessDialog extends DialogFragment {

    @BindView(R.id.success_dialog_secret)
    protected ImageView secret;
    @BindView(R.id.success_dialog_image)
    protected ImageView image;
    @BindView(R.id.success_dialog_title)
    protected TextView title;
    @BindView(R.id.success_dialog_message)
    protected TextView message;
    @BindView(R.id.success_dialog_secret_man)
    protected ImageView secretMan;
    @BindView(R.id.success_dialog_secret_woman)
    protected ImageView secretWoman;

    private boolean isSecredClicked;

    private DialogInterface.OnCancelListener cancelListener;

    public static SuccessDialog getInstance(DialogInterface.OnCancelListener listener) {
        SuccessDialog successDialog = new SuccessDialog();
        successDialog.setCancelListener(listener);
        return successDialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_success, null);
        ButterKnife.bind(this, view);

        Context context = getContext();
        Utils.loadGif(context, Utils.getHappyResource(), image);
        Utils.loadGif(context, R.drawable.minion_secret, secret);

        return new AlertDialog.Builder(getContext())
                .setView(view)
                .show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @OnClick(R.id.success_dialog_image)
    protected void onSecretClick() {
        if (!isSecredClicked) {
            isSecredClicked = true;
            title.setText(R.string.secret_dialog_title);
            message.setText(R.string.secret_dialog_message);
            secret.setVisibility(View.GONE);
            secretMan.setVisibility(View.VISIBLE);
            secretWoman.setVisibility(View.VISIBLE);

            Utils.loadGif(getContext(), R.drawable.minion_secret_success, image);
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (cancelListener != null) {
            cancelListener.onCancel(dialog);
        }
    }

    public void setCancelListener(DialogInterface.OnCancelListener cancelListener) {
        this.cancelListener = cancelListener;
    }
}
