package com.anetsapplication.app.modules.expenses.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.expenses.`data`.model.ExpensesModel
import com.anetsapplication.app.modules.expenses.`data`.model.ExpensesRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ExpensesVM : ViewModel(), KoinComponent {
  val expensesModel: MutableLiveData<ExpensesModel> = MutableLiveData(ExpensesModel())

  var navArguments: Bundle? = null

  val expensesList: MutableLiveData<MutableList<ExpensesRowModel>> =
      MutableLiveData(mutableListOf())
}
