package com.anetsapplication.app.modules.overview.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityOverviewBinding
import com.anetsapplication.app.db.HouseholdDBHelper
import com.anetsapplication.app.modules.addexpenseequally.ui.AddExpenseEquallyActivity
import com.anetsapplication.app.modules.create.ui.CreateActivity
import com.anetsapplication.app.modules.expenses.ui.ExpensesActivity
import com.anetsapplication.app.modules.households.ui.HouseholdsActivity
import com.anetsapplication.app.modules.members.ui.MembersActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import com.anetsapplication.app.modules.overview.`data`.viewmodel.OverviewVM
import kotlin.String
import kotlin.Unit

class OverviewActivity : BaseActivity<ActivityOverviewBinding>(R.layout.activity_overview) {
  private val viewModel: OverviewVM by viewModels<OverviewVM>()
  private lateinit var householdsHelper: HouseholdDBHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.overviewVM = viewModel

    householdsHelper = HouseholdDBHelper(this)

    val headline: TextView = findViewById(R.id.txtHeadline)
    val stdList = householdsHelper.getDataByHouseholdID(intent.getStringExtra("household_id")?.toInt())
    headline.text = stdList[0].household_name
  }

  override fun setUpClicks(): Unit {
    binding.btnMembers.setOnClickListener {
      val destIntent = MembersActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
      startActivity(destIntent)
    }
    binding.btnExpenses.setOnClickListener {
      val destIntent = ExpensesActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
      startActivity(destIntent)
    }
    binding.btnGrid.setOnClickListener {
      val destIntent = AddExpenseEquallyActivity.getIntent(this, null)
      Log.e("Go to add expense equally as user:", intent.getStringExtra("username").toString())
      Log.e("Go to add expense equally as household_name:", intent.getStringExtra("household_name").toString())
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
      startActivity(destIntent)
    }
    binding.linearSegment1.setOnClickListener {
      val destIntent = CreateActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      startActivity(destIntent)
    }
    binding.linearSegment2.setOnClickListener {
      val destIntent = HouseholdsActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      startActivity(destIntent)
    }
    binding.linearSegment3.setOnClickListener {
      val destIntent = NotificationsActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
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
