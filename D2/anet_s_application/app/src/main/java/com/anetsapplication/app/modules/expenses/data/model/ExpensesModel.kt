package com.anetsapplication.app.modules.expenses.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ExpensesModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadline: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_sweet_home)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_groceries)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtext: String? =
      MyApp.getInstance().resources.getString(R.string.msg_cristine_olive2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabel: String? = MyApp.getInstance().resources.getString(R.string.lbl_expenses)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineTwo: String? = MyApp.getInstance().resources.getString(R.string.msg_water_electri)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_cristine_olive3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineThree: String? =
      MyApp.getInstance().resources.getString(R.string.msg_water_electri)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextTwo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_franti_ek_pol_v2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineEight: String? =
      MyApp.getInstance().resources.getString(R.string.msg_water_electri)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextSeven: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_you_owe_630_k)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineNine: String? = MyApp.getInstance().resources.getString(R.string.lbl_rent)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextNine: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_supporting_text)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.lbl_create)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_households)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBadge: String? = MyApp.getInstance().resources.getString(R.string.lbl_4)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_notifications)

)
