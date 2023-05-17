package com.anetsapplication.app.modules.expenses.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ExpensesRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_rent)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextThree: String? =
      MyApp.getInstance().resources.getString(R.string.msg_honza_nov_paid)

)
