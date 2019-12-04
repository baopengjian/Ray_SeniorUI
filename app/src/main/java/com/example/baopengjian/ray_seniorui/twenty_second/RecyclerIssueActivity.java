package com.example.baopengjian.ray_seniorui.twenty_second;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.example.baopengjian.ray_seniorui.R;
import com.jakewharton.rxbinding.widget.RxCompoundButton;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Ray on 2019-12-4.
 */
public class RecyclerIssueActivity extends AppCompatActivity {


    private static final String TAG = "RecyclerIssueActivity";
    final static int NORMAL = 0;
    final static int BETTER = 1;

    final static int FEED_ROOT = 2;
    RecyclerView rvNormal;
    BetterRecyclerView rvBetter;
    FeedRootRecyclerView rvFeedRoot;

    CheckBox cbAngle;
    CheckBox cbIgnore;
    SectionAdapter adapter;
    CompositeSubscription viewSubscriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_issue_activity);

        setUpDrawer();
        adapter = new SectionAdapter();
        rvNormal = (RecyclerView) findViewById(R.id.rv_normal);
        rvBetter = (BetterRecyclerView) findViewById(R.id.rv_better);
        rvFeedRoot = (FeedRootRecyclerView) findViewById(R.id.rv_feed);

        cbAngle = (CheckBox) findViewById(R.id.cb_consider_angle);
        cbIgnore = (CheckBox) findViewById(R.id.cb_ignore_child_requests);

        rvNormal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvBetter.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvFeedRoot.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        rvNormal.setAdapter(adapter);
        rvBetter.setAdapter(adapter);
        rvFeedRoot.setAdapter(adapter);
    }

    private void setUpDrawer() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.consider_angle, R.string.ignore_child_requests);
        drawerToggle.syncState();
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewSubscriptions = new CompositeSubscription();
        setup();
    }

    private void setup() {
        Observable<Boolean> angleChanges = angleChecks().share();
        viewSubscriptions.add(
                Observable.combineLatest(angleChanges, ignoreChecks(), new Func2<Boolean, Boolean, Integer>() {
                    @Override
                    public Integer call(Boolean angle, Boolean ignore) {
                        Log.d(TAG, "Angle: " +  angle + " Ignore: " + ignore);
                        if (!angle) {
                            return NORMAL;
                        } else {
                            if (ignore) {
                                return FEED_ROOT;
                            } else {
                                return BETTER;
                            }
                        }
                    }
                }).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer setting) {
                        Log.d(TAG, "Integer: " + setting);
                        rvNormal.setVisibility(setting == NORMAL ? View.VISIBLE : View.GONE);
                        rvBetter.setVisibility(setting == BETTER ? View.VISIBLE : View.GONE);
                        rvFeedRoot.setVisibility(setting == FEED_ROOT ? View.VISIBLE : View.GONE);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
//                        Timber.e(throwable, "combined changes");
                    }
                })
        );
        viewSubscriptions.add(angleChanges.subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean enable) {
                Log.d(TAG, "enable: " + enable);
                cbIgnore.setEnabled(enable);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e(TAG, throwable + "angle Changes");
            }
        }));
    }

    private Observable<Boolean> angleChecks() {
        return RxCompoundButton.checkedChanges(cbAngle);
    }

    private Observable<Boolean> ignoreChecks() {
        return RxCompoundButton.checkedChanges(cbIgnore);
    }

    private void enableIgnore(boolean enable) {
        cbIgnore.setEnabled(enable);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unSubscribe();
    }

    private void unSubscribe() {
        if (viewSubscriptions.isUnsubscribed()) {
            viewSubscriptions.unsubscribe();
        }
    }
}
