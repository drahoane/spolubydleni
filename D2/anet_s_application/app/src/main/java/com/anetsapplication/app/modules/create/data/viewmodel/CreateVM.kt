package com.anetsapplication.app.modules.create.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.create.`data`.model.CreateModel
import org.koin.core.KoinComponent

class CreateVM : ViewModel(), KoinComponent {
  val createModel: MutableLiveData<CreateModel> = MutableLiveData(CreateModel())

  var navArguments: Bundle? = null
}
