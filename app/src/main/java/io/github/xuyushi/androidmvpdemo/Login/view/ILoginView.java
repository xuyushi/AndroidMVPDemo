package io.github.xuyushi.androidmvpdemo.Login.view;

/**
 * Created by xuyushi on 16/2/28.
 */
public interface ILoginView {
    void clearEditText();

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    String getUsername();

    String getPassword();

    void loginSuccess();

}
