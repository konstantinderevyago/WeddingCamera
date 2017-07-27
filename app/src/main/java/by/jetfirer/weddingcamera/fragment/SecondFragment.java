package by.jetfirer.weddingcamera.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import by.jetfirer.weddingcamera.R;
import by.jetfirer.weddingcamera.activity.MainActivity;

/**
 * Created by Konstantin on 26.07.2017.
 */

public class SecondFragment extends Fragment {

    private static final int VIDEO_REQUEST_CODE = 1;

    @BindView(R.id.second_image)
    protected ImageView image;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ButterKnife.bind(this, view);

        Glide.with(this)
                .load(R.drawable.minion_camera)
                .into(image);

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VIDEO_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            Log.i("Test", "uri = " + uri);
            ((MainActivity) getActivity()).setPage(0, false);
            ((MainActivity) getActivity()).showSuccessDialog();
        }
    }

    @OnClick(R.id.second_button)
    protected void onClick() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivityForResult(intent, VIDEO_REQUEST_CODE);
        }
    }

}
