package com.anetsapplication.app.modules.badges.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class BadgesModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtComponentname: String? = MyApp.getInstance().resources.getString(R.string.lbl_badges)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLink: String? = MyApp.getInstance().resources.getString(R.string.msg_see_design_guid)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_badges_are_used)

)
