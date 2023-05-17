package com.anetsapplication.app.modules.create.ui

import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityCreateBinding
import com.anetsapplication.app.modules.create.`data`.viewmodel.CreateVM
import com.anetsapplication.app.modules.invite.ui.InviteActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import kotlin.String
import kotlin.Unit

class CreateActivity : BaseActivity<ActivityCreateBinding>(R.layout.activity_create) {
  private val viewModel: CreateVM by viewModels<CreateVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.createVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearSegment3.setOnClickListener {
      val destIntent = NotificationsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnCreate.setOnClickListener {
      val destIntent = InviteActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "CREATE_ACTIVITY"

  }
}
