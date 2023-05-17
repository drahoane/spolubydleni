package com.anetsapplication.app.modules.members.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.members.`data`.model.MembersModel
import com.anetsapplication.app.modules.members.`data`.model.MembersRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class MembersVM : ViewModel(), KoinComponent {
  val membersModel: MutableLiveData<MembersModel> = MutableLiveData(MembersModel())

  var navArguments: Bundle? = null

  val membersList: MutableLiveData<MutableList<MembersRowModel>> = MutableLiveData(mutableListOf())
}
