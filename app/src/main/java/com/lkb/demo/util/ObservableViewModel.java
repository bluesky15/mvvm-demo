package com.lkb.demo.util;

import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.ViewModel;
// for now this is not required - it is required for some cases
// do not know yet
public class ObservableViewModel extends ViewModel implements Observable {

  PropertyChangeRegistry callbacks = new PropertyChangeRegistry();

  @Override
  public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
    callbacks.add(callback);
  }

  @Override
  public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
    callbacks.remove(callback);
  }

  /**
   * Notifies listeners that all properties of this instance have changed.
   */
  public void notifyChange() {
    callbacks.notifyCallbacks(this, 0, null);
  }

  /**
   * Notifies listeners that a specific property has changed. The getter for the property
   * that changes should be marked with [Bindable] to generate a field in
   * `BR` to be used as `fieldId`.
   *
   * @param fieldId The generated BR id for the Bindable field.
   */
  public void notifyPropertyChanged(int fieldId) {
    callbacks.notifyCallbacks(this, fieldId, null);
  }
}
