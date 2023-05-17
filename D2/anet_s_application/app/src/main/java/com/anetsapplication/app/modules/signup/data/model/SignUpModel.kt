package com.anetsapplication.app.modules.signup.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class SignUpModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadline: String? = MyApp.getInstance().resources.getString(R.string.lbl_sign_up)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.lbl_username)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_password)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPlaceholdertex: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_your_pass)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextTwo: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_repeat_password)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPlaceholdertexOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_your_pass2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltextThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_email)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPlaceholdertexTwo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_your_emai)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmation: String? =
      MyApp.getInstance().resources.getString(R.string.msg_already_have_an)

)
