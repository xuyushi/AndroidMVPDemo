package io.github.xuyushi.androidmvpdemo.Login.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.xuyushi.androidmvpdemo.Login.presenter.ILoginPresenter;
import io.github.xuyushi.androidmvpdemo.Login.presenter.LoginPresenter;
import io.github.xuyushi.androidmvpdemo.R;

public class LoginActivity extends AppCompatActivity
        implements ILoginView, View.OnClickListener {

    private ILoginPresenter mLoginPresenter;

    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_passwrod)
    EditText etPasswrod;
    @Bind(R.id.bt_enter)
    Button btEnter;
    @Bind(R.id.bt_clear)
    Button btClear;
    @Bind(R.id.progress)
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenter(this);
        btEnter.setOnClickListener(this);
        btClear.setOnClickListener(this);
    }

    @Override
    public void clearEditText() {
        etPasswrod.setText("");
        etUsername.setText("");
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        etUsername.setError("username error");
    }

    @Override
    public void setPasswordError() {
        etPasswrod.setError("password error");

    }

    @Override
    public String getUsername() {
        return etUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPasswrod.getText().toString();
    }

    @Override
    public void loginSuccess() {
        //start act Main
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_clear:
                mLoginPresenter.clear();
                break;
            case R.id.bt_enter:
                mLoginPresenter.doLogin(etUsername.getText().toString(),
                        etPasswrod.getText().toString());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        mLoginPresenter.onDestroy();
        super.onDestroy();
    }
}
