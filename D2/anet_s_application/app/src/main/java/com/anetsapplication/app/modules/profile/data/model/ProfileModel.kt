package com.anetsapplication.app.modules.profile.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ProfileModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadline: String? = MyApp.getInstance().resources.getString(R.string.lbl_profile)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNicolThomas: String? = MyApp.getInstance().resources.getString(R.string.lbl_nicol_thomas)

)
