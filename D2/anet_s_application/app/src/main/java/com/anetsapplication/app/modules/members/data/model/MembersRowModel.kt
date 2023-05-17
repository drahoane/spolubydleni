package com.anetsapplication.app.modules.members.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class MembersRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtCristineOlive: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_cristine_olive)

)
