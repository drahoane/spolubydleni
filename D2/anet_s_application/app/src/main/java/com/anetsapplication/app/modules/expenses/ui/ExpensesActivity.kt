package com.anetsapplication.app.modules.expenses.ui


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityExpensesBinding
import com.anetsapplication.app.db.ExpensesDBHelper
import com.anetsapplication.app.db.HouseholdDBHelper
import com.anetsapplication.app.db.UserdataDBHelper
import com.anetsapplication.app.modules.addexpenseequally.ui.AddExpenseEquallyActivity
import com.anetsapplication.app.modules.create.ui.CreateActivity
import com.anetsapplication.app.modules.detail.ui.DetailActivity
import com.anetsapplication.app.modules.expenses.data.model.ExpensesRowModel
import com.anetsapplication.app.modules.expenses.data.viewmodel.ExpensesVM
import com.anetsapplication.app.modules.households.data.adapter.HouseholdsAdapter
import com.anetsapplication.app.modules.households.data.model.HouseholdsModel
import com.anetsapplication.app.modules.households.ui.HouseholdsActivity
import com.anetsapplication.app.modules.members.ui.MembersActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import com.anetsapplication.app.modules.overview.ui.OverviewActivity
import java.time.LocalDateTime


class ExpensesActivity : BaseActivity<ActivityExpensesBinding>(R.layout.activity_expenses) {
  private val viewModel: ExpensesVM by viewModels<ExpensesVM>()
  private lateinit var recyclerView: RecyclerView
  private var adapter: ExpensesAdapter? = null
  private lateinit var expensesHelper: ExpensesDBHelper
  private lateinit var householdsHelper: HouseholdDBHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.expensesVM = viewModel

    recyclerView = findViewById(R.id.recyclerExpenses)
    initRecyclerView()
    expensesHelper = ExpensesDBHelper(this)
    householdsHelper = HouseholdDBHelper(this)
    getHouseholds()

    val headline: TextView = findViewById(R.id.txtHeadline)
    val stdList = householdsHelper.getDataByHouseholdID(intent.getStringExtra("household_id")?.toInt())
    headline.text = stdList[0].household_name

    adapter?.setOnClickItem {
      Log.e("Went into Expense detail ID", it.expense_id.toString())
      val destIntent = DetailActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
      destIntent.putExtra("expense_id", it.expense_id.toString())
      startActivity(destIntent)
    }
  }

  override fun setUpClicks(): Unit {
    binding.btnMembers.setOnClickListener {
      val destIntent = MembersActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
      startActivity(destIntent)
    }
    binding.btnOverview.setOnClickListener {
      val destIntent = OverviewActivity.getIntent(this, null)
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
    binding.btnGrid.setOnClickListener {
      val destIntent = AddExpenseEquallyActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "EXPENSES_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ExpensesActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }

  fun initRecyclerView() {
    recyclerView.layoutManager = LinearLayoutManager(this)
    adapter = ExpensesAdapter()
    recyclerView.adapter = adapter
  }

  fun getHouseholds() {
    expensesHelper.insertData("new shoes", 2.85, "CZK", 1, 1)
    val household_id = intent.getStringExtra("household_id")
    val stdList = expensesHelper.getDataByHouseholdID(household_id?.toInt())
    Log.e("Expenses count", "${stdList.size}")
    if(stdList.size == 0) {
      val noFound = findViewById<RelativeLayout>(R.id.noExpensesFound)
      noFound.visibility = View.VISIBLE;
    } else {
      adapter?.addItems(stdList)
    }
  }
}
