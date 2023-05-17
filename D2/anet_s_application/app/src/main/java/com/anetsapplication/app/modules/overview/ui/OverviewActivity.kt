package com.anetsapplication.app.modules.overview.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityOverviewBinding
import com.anetsapplication.app.modules.addexpenseequally.ui.AddExpenseEquallyActivity
import com.anetsapplication.app.modules.expenses.ui.ExpensesActivity
import com.anetsapplication.app.modules.members.ui.MembersActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import com.anetsapplication.app.modules.overview.`data`.viewmodel.OverviewVM
import kotlin.String
import kotlin.Unit

class OverviewActivity : BaseActivity<ActivityOverviewBinding>(R.layout.activity_overview) {
  private val viewModel: OverviewVM by viewModels<OverviewVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.overviewVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnGrid.setOnClickListener {
      val destIntent = AddExpenseEquallyActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearSegment3.setOnClickListener {
      val destIntent = NotificationsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnMembers.setOnClickListener {
      val destIntent = MembersActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnExpenses.setOnClickListener {
      val destIntent = ExpensesActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "OVERVIEW_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OverviewActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
