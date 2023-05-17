package com.anetsapplication.app.modules.addexpenseequallyerror.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.addexpenseequallyerror.`data`.model.AddExpenseEquallyErrorModel
import org.koin.core.KoinComponent

class AddExpenseEquallyErrorVM : ViewModel(), KoinComponent {
  val addExpenseEquallyErrorModel: MutableLiveData<AddExpenseEquallyErrorModel> =
      MutableLiveData(AddExpenseEquallyErrorModel())

  var navArguments: Bundle? = null
}
