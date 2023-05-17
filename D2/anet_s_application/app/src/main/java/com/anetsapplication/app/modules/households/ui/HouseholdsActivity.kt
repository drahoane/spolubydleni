package com.anetsapplication.app.modules.households.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityHouseholdsBinding
import com.anetsapplication.app.modules.households.`data`.viewmodel.HouseholdsVM
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import com.anetsapplication.app.modules.overview.ui.OverviewActivity
import kotlin.String
import kotlin.Unit

class HouseholdsActivity : BaseActivity<ActivityHouseholdsBinding>(R.layout.activity_households) {
  private val viewModel: HouseholdsVM by viewModels<HouseholdsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.householdsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearListitemList.setOnClickListener {
      val destIntent = OverviewActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearSegment3.setOnClickListener {
      val destIntent = NotificationsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "HOUSEHOLDS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HouseholdsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
