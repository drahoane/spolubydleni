package com.anetsapplication.app.modules.invite.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.invite.`data`.model.InviteModel
import org.koin.core.KoinComponent

class InviteVM : ViewModel(), KoinComponent {
  val inviteModel: MutableLiveData<InviteModel> = MutableLiveData(InviteModel())

  var navArguments: Bundle? = null
}
