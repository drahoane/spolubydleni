package com.anetsapplication.app.modules.create.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class CreateModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadline: String? = MyApp.getInstance().resources.getString(R.string.lbl_create)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.lbl_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_create)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_households)
  ,
  var txtPlaceholdertex: String? = MyApp.getInstance().resources.getString(R.string.lbl_households)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBadge: String? = MyApp.getInstance().resources.getString(R.string.lbl_4)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextThree: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_notifications)

)
