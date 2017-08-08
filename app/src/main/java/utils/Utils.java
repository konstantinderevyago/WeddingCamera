package utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Random;

import by.jetfirer.weddingcamera.R;

/**
 * Created by Konstantin on 08.08.2017.
 */

public class Utils {

    public static void loadGif(Context context, int res, ImageView image) {
        Glide.with(context)
                .load(res)
                .apply(RequestOptions.placeholderOf(res))
                .into(image);
    }

    public static int getHappyResource() {
        switch (new Random().nextInt(7)) {
            case 0:
                return R.drawable.minions_happy_1;
            case 1:
                return R.drawable.minions_happy_2;
            case 2:
                return R.drawable.minions_happy_3;
            case 3:
                return R.drawable.minions_happy_4;
            case 4:
                return R.drawable.minions_happy_5;
            case 5:
                return R.drawable.minions_happy_6;
            default:
                return R.drawable.minions_happy_6;
        }
    }
}
