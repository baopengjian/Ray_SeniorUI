package com.example.baopengjian.ray_seniorui.twenty_seventh.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-12-16.
 */
public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView content;
    Snackbar snackbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.navigation_activity);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        content = (TextView) findViewById(R.id.content);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        String string = null;
        switch (id) {
            case R.id.nav_me:
                string = "我";
               /* Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);*/
                Toast.makeText(NavigationActivity.this, string,Toast.LENGTH_SHORT  );
                break;
            case R.id.nav_about:
                string = "关于";

                break;
            case R.id.nav_friend:
                string = "好友";
                snackbar = Snackbar.make(content, "动脑学院", Snackbar.LENGTH_INDEFINITE).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                snackbar.show();
                break;
            case R.id.nav_manage:
                string = "通知";
                snackbar.dismiss();
                break;
            case R.id.nav_message:
                string = "私信";
                Snackbar.make(content, "动脑学院2", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.nav_night:
                string = "夜间模式";
                break;
            case R.id.nav_notification:
                string = "通知";
                break;
            case R.id.nav_setting:
                string = "设置";
                break;
            case R.id.nav_suggestion:
                string = "意见反馈";
                break;
            case R.id.nav_theme:
                string = "主题风格";
                break;
        }
        if (!TextUtils.isEmpty(string))
            content.setText("你点击了" + string);
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}
