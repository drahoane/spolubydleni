package com.anetsapplication.app.modules.addexpenseunequally.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class Listavatars3davRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtCristineOlive: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_cristine_olive)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtK: String? = MyApp.getInstance().resources.getString(R.string.lbl_k)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInput: String? = MyApp.getInstance().resources.getString(R.string.lbl_0_00)

)
