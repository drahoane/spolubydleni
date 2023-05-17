package com.anetsapplication.app.modules.overview.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class OverviewModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadline: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_sweet_home)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabel: String? = MyApp.getInstance().resources.getString(R.string.lbl_overview)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOverallyouow: String? =
      MyApp.getInstance().resources.getString(R.string.msg_overall_you_ow)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCristineOlive: String? =
      MyApp.getInstance().resources.getString(R.string.msg_cristine_olive)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtJenifferCloud: String? =
      MyApp.getInstance().resources.getString(R.string.msg_jeniffer_cloud)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHonzaNoviso: String? = MyApp.getInstance().resources.getString(R.string.msg_honza_nov_is_o)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrantiekPolv: String? =
      MyApp.getInstance().resources.getString(R.string.msg_franti_ek_pol_v)
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
