package com.anetsapplication.app.modules.settings.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.settings.`data`.model.SettingsModel
import org.koin.core.KoinComponent

class SettingsVM : ViewModel(), KoinComponent {
  val settingsModel: MutableLiveData<SettingsModel> = MutableLiveData(SettingsModel())

  var navArguments: Bundle? = null
}
