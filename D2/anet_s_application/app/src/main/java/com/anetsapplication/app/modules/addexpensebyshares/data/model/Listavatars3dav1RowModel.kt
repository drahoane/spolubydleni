package com.anetsapplication.app.modules.addexpensebyshares.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class Listavatars3dav1RowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtCristineOlive: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_cristine_olive)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInput: String? = MyApp.getInstance().resources.getString(R.string.lbl_0)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtShares: String? = MyApp.getInstance().resources.getString(R.string.lbl_shares)

)
