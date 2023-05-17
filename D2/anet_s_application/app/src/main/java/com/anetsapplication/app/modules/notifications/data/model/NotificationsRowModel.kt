package com.anetsapplication.app.modules.notifications.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class NotificationsRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_household_invit)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupportingtext: String? =
      MyApp.getInstance().resources.getString(R.string.msg_you_have_receiv)

)
