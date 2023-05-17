package com.anetsapplication.app.modules.overview.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.overview.`data`.model.OverviewModel
import org.koin.core.KoinComponent

class OverviewVM : ViewModel(), KoinComponent {
  val overviewModel: MutableLiveData<OverviewModel> = MutableLiveData(OverviewModel())

  var navArguments: Bundle? = null
}
