package com.lkb.demo.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.lkb.demo.R;
import com.lkb.demo.databinding.ActivityMainBinding;
import com.lkb.demo.viewmodel.LoginViewModel;
import com.lkb.demo.viewmodel.LoginViewModelFactory;

//this is view:
//view will communicate through the viewModel.
public class LoginActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    binding.setLifecycleOwner(this);
    LoginViewModel loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
        .get(LoginViewModel.class);
    binding.setViewmodel(loginViewModel);
    loginViewModel.updateUi().observe(this, t -> {
      if (t.isEmpty()) {
        Toast.makeText(this, "UserName or Password is invalid", Toast.LENGTH_SHORT).show();
      } else {
        startActivity(new Intent(this, HomeActivity.class));
      }
    });
  }
}
