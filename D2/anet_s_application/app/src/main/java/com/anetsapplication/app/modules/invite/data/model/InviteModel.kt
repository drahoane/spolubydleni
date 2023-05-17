package com.anetsapplication.app.modules.invite.`data`.model

import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class InviteModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadline: String? = MyApp.getInstance().resources.getString(R.string.lbl_invite)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLabeltext: String? = MyApp.getInstance().resources.getString(R.string.lbl_thomas_rell)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInputtext: String? = MyApp.getInstance().resources.getString(R.string.lbl_jos)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBuildingBlocks: String? = MyApp.getInstance().resources.getString(R.string.lbl_j)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_joseph_m_ller)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBuildingBlocksOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_j)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_joshua_bassett)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBuildingBlocksTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_j)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_josie_white)
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
