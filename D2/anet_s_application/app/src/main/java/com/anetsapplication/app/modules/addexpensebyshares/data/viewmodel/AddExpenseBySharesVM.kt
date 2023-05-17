package com.anetsapplication.app.modules.addexpensebyshares.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.addexpensebyshares.`data`.model.AddExpenseBySharesModel
import com.anetsapplication.app.modules.addexpensebyshares.`data`.model.Listavatars3dav1RowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class AddExpenseBySharesVM : ViewModel(), KoinComponent {
  val addExpenseBySharesModel: MutableLiveData<AddExpenseBySharesModel> =
      MutableLiveData(AddExpenseBySharesModel())

  var navArguments: Bundle? = null

  val listavatars3davList: MutableLiveData<MutableList<Listavatars3dav1RowModel>> =
      MutableLiveData(mutableListOf())
}
