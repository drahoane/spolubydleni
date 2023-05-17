package com.anetsapplication.app.modules.addexpensebyshares.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class AddExpenseBySharesModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadline: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_sweet_home)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSplit: String? = MyApp.getInstance().resources.getString(R.string.lbl_split)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabel: String? = MyApp.getInstance().resources.getString(R.string.lbl_unequally)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabelOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_by_shares)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtChooseiconor: String? =
      MyApp.getInstance().resources.getString(R.string.msg_choose_icon_or)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.lbl_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPlaceholdertex: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_expense_n)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeZone: String? = MyApp.getInstance().resources.getString(R.string.lbl_cost)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPlaceholdertexOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_the_cost)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_currency)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_czk)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_paid_by)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtext: String? = MyApp.getInstance().resources.getString(R.string.lbl_honza_nov)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_create)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_households)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBadge: String? = MyApp.getInstance().resources.getString(R.string.lbl_4)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextFive: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_notifications)

)
