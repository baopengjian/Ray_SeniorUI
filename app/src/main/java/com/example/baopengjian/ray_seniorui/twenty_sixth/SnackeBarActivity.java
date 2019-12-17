package com.example.baopengjian.ray_seniorui.twenty_sixth;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-12-13.
 */
public class SnackeBarActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    TextInputLayout textInputLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snake_bar_activity);
        button = (Button) findViewById(R.id.btn);

        editText = (EditText) findViewById(R.id.et_name);
        textInputLayout = (TextInputLayout) findViewById(R.id.tliayout);
        textInputLayout.setErrorEnabled(true);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkName(s.toString());
            }
        });

    }

    private void checkName(String s) {
        if (s.length() < 4) {
            textInputLayout.setError("名字长度太短");
        }else {
            textInputLayout.setError(null);
        }
    }

    long time;

    public void click(View v) {
        Snackbar snackbar = Snackbar.make(button, "点击了button", Snackbar.LENGTH_INDEFINITE)
                .setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SnackeBarActivity.this,"确定了 ",Toast.LENGTH_LONG).show();
                    }
                }).setCallback(new Snackbar.Callback(){
                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        time=System.currentTimeMillis();
                    }

                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        time=System.currentTimeMillis()-time;
                        Toast.makeText(SnackeBarActivity.this,"  时间" +time,Toast.LENGTH_SHORT).show();
                        super.onDismissed(transientBottomBar, event);
                    }
                }).setActionTextColor(Color.YELLOW);
        View view1=snackbar.getView();
        TextView textView= (TextView) view1.findViewById(R.id.snackbar_text);
        textView.setText("内容");
        snackbar.show();
    }
}
