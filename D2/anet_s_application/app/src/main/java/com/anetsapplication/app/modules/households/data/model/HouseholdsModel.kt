package com.anetsapplication.app.modules.households.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class HouseholdsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadline: String? = MyApp.getInstance().resources.getString(R.string.lbl_households)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_sweet_home)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtext: String? =
      MyApp.getInstance().resources.getString(R.string.msg_last_update_30)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeZone: String? = MyApp.getInstance().resources.getString(R.string.msg_shared_apartmen)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_last_update_26)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineTwo: String? = MyApp.getInstance().resources.getString(R.string.msg_another_one_65)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextTwo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_last_update_13)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineThree: String? =
      MyApp.getInstance().resources.getString(R.string.msg_another_one_65)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextThree: String? =
      MyApp.getInstance().resources.getString(R.string.msg_last_update_13)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineFour: String? =
      MyApp.getInstance().resources.getString(R.string.msg_temporary_home)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextFour: String? =
      MyApp.getInstance().resources.getString(R.string.msg_last_update_2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeZoneOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_25_west_valley)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtextFive: String? =
      MyApp.getInstance().resources.getString(R.string.msg_last_update_13)
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
