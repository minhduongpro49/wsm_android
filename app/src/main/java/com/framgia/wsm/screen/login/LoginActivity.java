package com.framgia.wsm.screen.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.framgia.wsm.MainApplication;
import com.framgia.wsm.R;
import com.framgia.wsm.databinding.ActivityLoginBinding;
import com.framgia.wsm.screen.BaseActivity;
import javax.inject.Inject;

/**
 * Login Screen.
 */
public class LoginActivity extends BaseActivity {

    @Inject
    LoginContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerLoginComponent.builder()
                .appComponent(((MainApplication) getApplication()).getAppComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

        ActivityLoginBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.setViewModel((LoginViewModel) mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}