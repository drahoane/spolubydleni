package com.anetsapplication.app.modules.editexpense.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.editexpense.`data`.model.EditExpenseModel
import org.koin.core.KoinComponent

class EditExpenseVM : ViewModel(), KoinComponent {
  val editExpenseModel: MutableLiveData<EditExpenseModel> = MutableLiveData(EditExpenseModel())

  var navArguments: Bundle? = null
}
