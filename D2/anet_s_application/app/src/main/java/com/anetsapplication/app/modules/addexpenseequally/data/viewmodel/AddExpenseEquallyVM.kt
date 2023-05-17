package com.anetsapplication.app.modules.addexpenseequally.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.addexpenseequally.`data`.model.AddExpenseEquallyModel
import org.koin.core.KoinComponent

class AddExpenseEquallyVM : ViewModel(), KoinComponent {
  val addExpenseEquallyModel: MutableLiveData<AddExpenseEquallyModel> =
      MutableLiveData(AddExpenseEquallyModel())

  var navArguments: Bundle? = null
}
