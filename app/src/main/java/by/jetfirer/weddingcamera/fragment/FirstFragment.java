package by.jetfirer.weddingcamera.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import by.jetfirer.weddingcamera.R;
import by.jetfirer.weddingcamera.activity.MainActivity;
import utils.Utils;

/**
 * Created by Konstantin on 26.07.2017.
 */

public class FirstFragment extends Fragment {

    @BindView(R.id.first_image)
    protected ImageView image;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);

        Utils.loadGif(getContext(), R.drawable.minion_place, image);

        return view;
    }

    @OnClick(R.id.first_button)
    protected void onClick() {
        ((MainActivity) getActivity()).setPage(1, true);
    }
}
