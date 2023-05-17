package com.anetsapplication.app.modules.addexpenseunequally.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.addexpenseunequally.`data`.model.AddExpenseUnequallyModel
import com.anetsapplication.app.modules.addexpenseunequally.`data`.model.Listavatars3davRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class AddExpenseUnequallyVM : ViewModel(), KoinComponent {
  val addExpenseUnequallyModel: MutableLiveData<AddExpenseUnequallyModel> =
      MutableLiveData(AddExpenseUnequallyModel())

  var navArguments: Bundle? = null

  val listavatars3davList: MutableLiveData<MutableList<Listavatars3davRowModel>> =
      MutableLiveData(mutableListOf())
}
