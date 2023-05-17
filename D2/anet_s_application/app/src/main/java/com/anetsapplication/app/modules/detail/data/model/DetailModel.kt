package com.anetsapplication.app.modules.detail.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class DetailModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadline: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_sweet_home)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCupcakes: String? = MyApp.getInstance().resources.getString(R.string.lbl_cupcakes)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtKCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_150_k)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAddedbyyouon: String? =
      MyApp.getInstance().resources.getString(R.string.msg_added_by_you_on)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_17_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtUMMthosewere: String? =
      MyApp.getInstance().resources.getString(R.string.msg_umm_those_were)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtIndeedJana: String? = MyApp.getInstance().resources.getString(R.string.lbl_indeed_jana)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtext: String? =
      MyApp.getInstance().resources.getString(R.string.msg_type_to_write_c)
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
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupThreeValue: String? = null
)
