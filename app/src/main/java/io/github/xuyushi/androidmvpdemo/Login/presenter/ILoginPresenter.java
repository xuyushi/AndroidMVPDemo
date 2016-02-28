package io.github.xuyushi.androidmvpdemo.Login.presenter;

/**
 * Created by xuyushi on 16/2/28.
 */
public interface ILoginPresenter {
    void doLogin(String username, String password);

    void clear();

    void onDestroy();
}
