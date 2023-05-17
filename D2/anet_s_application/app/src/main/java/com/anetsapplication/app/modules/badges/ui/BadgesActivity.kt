package com.anetsapplication.app.modules.badges.ui

import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityBadgesBinding
import com.anetsapplication.app.modules.badges.`data`.viewmodel.BadgesVM
import kotlin.String
import kotlin.Unit

class BadgesActivity : BaseActivity<ActivityBadgesBinding>(R.layout.activity_badges) {
  private val viewModel: BadgesVM by viewModels<BadgesVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.badgesVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "BADGES_ACTIVITY"

  }
}
