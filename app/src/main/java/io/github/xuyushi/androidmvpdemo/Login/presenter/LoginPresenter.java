package io.github.xuyushi.androidmvpdemo.Login.presenter;

import android.os.Handler;

import io.github.xuyushi.androidmvpdemo.Login.model.User;
import io.github.xuyushi.androidmvpdemo.Login.view.ILoginView;

/**
 * Created by xuyushi on 16/2/28.
 */
public class LoginPresenter implements ILoginPresenter {
    private ILoginView mLoginView;
    private User mUser;

    public LoginPresenter(ILoginView loginView) {
        this.mLoginView = loginView;
        initUser();
    }

    private void initUser() {
        mUser = new User(mLoginView.getUsername(), mLoginView.getPassword());
    }

    @Override
    public void doLogin(String username, String password) {
        mLoginView.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoginView.hideProgress();
                int code = mUser.checkUserValidity(mLoginView.getUsername(), mLoginView.getPassword());
                if (code == -1) {
                    mLoginView.setPasswordError();
                } else if (code == 0) {
                    mLoginView.loginSuccess();
                }
            }
        }, 2000);
    }

    @Override
    public void clear() {
        mLoginView.clearEditText();
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
    }
}
