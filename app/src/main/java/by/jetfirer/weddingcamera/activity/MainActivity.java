package by.jetfirer.weddingcamera.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.jetfirer.weddingcamera.R;
import by.jetfirer.weddingcamera.adapter.MainPagerAdapter;
import by.jetfirer.weddingcamera.fragment.dialog.SuccessDialog;
import by.jetfirer.weddingcamera.widget.NoScrollViewPager;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnCancelListener {

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
        SuccessDialog.getInstance(this).show(getSupportFragmentManager(), null);
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hide();
            }
        }, 100);
    }

    @Override
    public void onBackPressed() {

    }
}
