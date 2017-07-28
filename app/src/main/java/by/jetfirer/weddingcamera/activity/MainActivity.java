package by.jetfirer.weddingcamera.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.jetfirer.weddingcamera.R;
import by.jetfirer.weddingcamera.adapter.MainPagerAdapter;
import by.jetfirer.weddingcamera.widget.NoScrollViewPager;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_root)
    protected View root;
    @BindView(R.id.main_view_pager)
    protected NoScrollViewPager viewPager;

    private MainPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setPagingEnable(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        hide();
    }

    private void hide() {
        root.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    public void setPage(int page, boolean animate) {
        viewPager.setCurrentItem(page, animate);
        viewPager.setPagingEnable(page != 0);
    }

    public void showSuccessDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_success, null);
        final TextView title = view.findViewById(R.id.success_dialog_title);
        final ImageView image = view.findViewById(R.id.success_dialog_image);
        final ImageView secret = view.findViewById(R.id.success_dialog_secret);
        final ImageView secretMan = view.findViewById(R.id.success_dialog_secret_man);
        final ImageView secretWoman = view.findViewById(R.id.success_dialog_secret_woman);
        final TextView message = view.findViewById(R.id.success_dialog_message);

        Glide.with(this)
                .load(getHappyResource())
                .into(image);

        Glide.with(this)
                .load(R.drawable.minion_secret)
                .into(secret);

        secret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.setText(R.string.success_dialog_secret_title);
                message.setText(R.string.success_dialog_secret_message);
                secret.setVisibility(View.GONE);
                secretMan.setVisibility(View.VISIBLE);
                secretWoman.setVisibility(View.VISIBLE);

                Glide.with(MainActivity.this)
                        .load(R.drawable.minion_secret_success)
                        .into(image);
            }
        });

        new AlertDialog.Builder(this)
                .setView(view)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                hide();
                            }
                        }, 100);
                    }
                })
                .show();
    }

    private int getHappyResource() {
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

    @Override
    public void onBackPressed() {

    }
}
