package com.anetsapplication.app.modules.badges.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.badges.`data`.model.BadgesModel
import org.koin.core.KoinComponent

class BadgesVM : ViewModel(), KoinComponent {
  val badgesModel: MutableLiveData<BadgesModel> = MutableLiveData(BadgesModel())

  var navArguments: Bundle? = null
}
