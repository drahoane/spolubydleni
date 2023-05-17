package com.anetsapplication.app.modules.editexpense.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class EditExpenseModel(
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
  var txtLabel: String? = MyApp.getInstance().resources.getString(R.string.lbl_equally)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCristineOlive: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_cristine_olive)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtJenifferCloud: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_jeniffer_cloud)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHonzaNov: String? = MyApp.getInstance().resources.getString(R.string.lbl_honza_nov)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrantiekPolv: String? =
      MyApp.getInstance().resources.getString(R.string.msg_franti_ek_pol_v3)
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
  var txtInputtext: String? = MyApp.getInstance().resources.getString(R.string.lbl_cupcakes)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeZone: String? = MyApp.getInstance().resources.getString(R.string.lbl_cost)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtextOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_150)
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
  var txtInputtextTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_honza_nov)
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
