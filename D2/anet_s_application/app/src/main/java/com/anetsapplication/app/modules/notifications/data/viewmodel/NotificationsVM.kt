package com.anetsapplication.app.modules.notifications.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anetsapplication.app.modules.notifications.`data`.model.NotificationsModel
import com.anetsapplication.app.modules.notifications.`data`.model.NotificationsRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class NotificationsVM : ViewModel(), KoinComponent {
  val notificationsModel: MutableLiveData<NotificationsModel> =
      MutableLiveData(NotificationsModel())

  var navArguments: Bundle? = null

  val notificationsList: MutableLiveData<MutableList<NotificationsRowModel>> =
      MutableLiveData(mutableListOf())
}
