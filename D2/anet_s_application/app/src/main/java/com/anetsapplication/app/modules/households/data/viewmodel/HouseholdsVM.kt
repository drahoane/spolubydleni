package com.anetsapplication.app.modules.households.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.households.`data`.model.HouseholdsModel
import org.koin.core.KoinComponent

class HouseholdsVM : ViewModel(), KoinComponent {


  var navArguments: Bundle? = null
}
