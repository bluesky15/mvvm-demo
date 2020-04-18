package com.lkb.demo.viewmodel;

import android.text.Editable;
import android.util.Log;

import android.view.View;
import androidx.databinding.Bindable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lkb.demo.model.repository.LoginRepository;
import com.lkb.demo.util.ObservableViewModel;

//this is viewModel:
//View model will not know anything about the view
public class LoginViewModel extends ObservableViewModel {

  MutableLiveData<Integer> visibilityType = new MutableLiveData<>();
  MutableLiveData token = new MutableLiveData();

  public LoginViewModel() {
    visibilityType.setValue(View.GONE);
    init();
  }

  public LiveData<Integer> getVisibilityType() {
    return visibilityType;
  }

  public void doLogin(String userName, String password) {
    visibilityType.setValue(View.VISIBLE);
    LoginRepository.getInstance().validateUser(userName, password);
  }


  public LiveData<String> updateUi() {
    return token;
  }

  public void init() {
    LoginRepository.getInstance().subscribe().observeForever(t -> {
      token.setValue(t);
      visibilityType.setValue(View.GONE);
    });
  }
}
