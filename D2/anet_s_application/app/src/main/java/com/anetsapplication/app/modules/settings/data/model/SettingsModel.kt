package com.anetsapplication.app.modules.settings.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class SettingsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadline: String? = MyApp.getInstance().resources.getString(R.string.lbl_settings)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_appearence)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_sounds)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_timezone)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_privacy)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineFive: String? = MyApp.getInstance().resources.getString(R.string.lbl_others)

)
