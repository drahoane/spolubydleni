package com.anetsapplication.app.modules.households.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityHouseholdsBinding
import com.anetsapplication.app.db.HouseholdDBHelper
import com.anetsapplication.app.modules.create.ui.CreateActivity
import com.anetsapplication.app.modules.households.data.adapter.HouseholdsAdapter
import com.anetsapplication.app.modules.households.`data`.viewmodel.HouseholdsVM
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import com.anetsapplication.app.modules.overview.ui.OverviewActivity
import kotlin.String
import kotlin.Unit

class HouseholdsActivity : BaseActivity<ActivityHouseholdsBinding>(R.layout.activity_households) {
  private val viewModel: HouseholdsVM by viewModels<HouseholdsVM>()
  private lateinit var recyclerView: RecyclerView
  private var adapter: HouseholdsAdapter? = null
  private lateinit var householdHelper: HouseholdDBHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.householdsVM = viewModel

    householdHelper = HouseholdDBHelper(this)
    recyclerView = findViewById(R.id.recyclerHouseholds)
    initRecyclerView()
  }

  override fun setUpClicks(): Unit {
    binding.linearSegment1.setOnClickListener {
      val destIntent = CreateActivity.getIntent(this, null)
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

  fun initRecyclerView() {
    recyclerView.layoutManager = LinearLayoutManager(this)
    adapter = HouseholdsAdapter()
    recyclerView.adapter = adapter
  }

  fun getHouseholds() {
    val stdList = householdHelper.getData()
    adapter?.addItems(stdList)
  }
}
