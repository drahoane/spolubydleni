package com.anetsapplication.app.modules.invite.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityInviteBinding
import com.anetsapplication.app.modules.invite.`data`.viewmodel.InviteVM
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import com.anetsapplication.app.modules.overview.ui.OverviewActivity
import kotlin.String
import kotlin.Unit

class InviteActivity : BaseActivity<ActivityInviteBinding>(R.layout.activity_invite) {
  private val viewModel: InviteVM by viewModels<InviteVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.inviteVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnInvite.setOnClickListener {
      val destIntent = OverviewActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearSegment3.setOnClickListener {
      val destIntent = NotificationsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "INVITE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, InviteActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
