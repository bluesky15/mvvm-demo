package com.lkb.demo.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LoginViewModelFactory implements ViewModelProvider.Factory {

  @NonNull
  @Override
  public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
    if (modelClass.isAssignableFrom(LoginViewModel.class)) {
      return (T) new LoginViewModel();
    }
    throw new IllegalArgumentException("Unknown ViewModel class");
  }
}
