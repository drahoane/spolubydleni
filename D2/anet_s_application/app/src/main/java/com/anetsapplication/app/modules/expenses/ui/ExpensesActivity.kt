package com.anetsapplication.app.modules.expenses.ui


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityExpensesBinding
import com.anetsapplication.app.db.ExpensesDBHelper
import com.anetsapplication.app.db.HouseholdDBHelper
import com.anetsapplication.app.db.UserdataDBHelper
import com.anetsapplication.app.modules.addexpenseequally.ui.AddExpenseEquallyActivity
import com.anetsapplication.app.modules.create.ui.CreateActivity
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
  private lateinit var household_name: EditText
  private lateinit var floatBtn: Button
  private lateinit var db: ExpensesDBHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val expensesAdapter = ExpensesAdapter(viewModel.expensesList.value?:mutableListOf())
    binding.recyclerExpenses.adapter = expensesAdapter

    val headline:TextView = findViewById(R.id.txtHeadline)
    headline.text = intent.getStringExtra("household_name")

    expensesAdapter.setOnItemClickListener(
    object : ExpensesAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ExpensesRowModel) {
        onClickRecyclerExpenses(view, position, item)
      }
    })

    viewModel.expensesList.observe(this) {
      expensesAdapter.updateData(it)
    }
    binding.expensesVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnMembers.setOnClickListener {
      val destIntent = MembersActivity.getIntent(this, null)
      destIntent.putExtra("username", intent.getStringExtra("username"))
      destIntent.putExtra("household_name", intent.getStringExtra("household_name"))
      startActivity(destIntent)
    }
    binding.btnOverview.setOnClickListener {
      val destIntent = OverviewActivity.getIntent(this, null)
      destIntent.putExtra("username", intent.getStringExtra("username"))
      destIntent.putExtra("household_name", intent.getStringExtra("household_name"))
      startActivity(destIntent)
    }
    binding.btnGrid.setOnClickListener {
      val destIntent = AddExpenseEquallyActivity.getIntent(this, null)
      Log.e("Go to add expense equally as user:", intent.getStringExtra("username").toString())
      Log.e("Go to add expense equally as household_name:", intent.getStringExtra("household_name").toString())
      destIntent.putExtra("username", intent.getStringExtra("username"))
      destIntent.putExtra("household_name", intent.getStringExtra("household_name"))
      startActivity(destIntent)
    }
    binding.linearSegment1.setOnClickListener {
      val destIntent = CreateActivity.getIntent(this, null)
      destIntent.putExtra("username", intent.getStringExtra("username"))
      destIntent.putExtra("household_name", intent.getStringExtra("household_name"))
      startActivity(destIntent)
    }
    binding.linearSegment2.setOnClickListener {
      val destIntent = HouseholdsActivity.getIntent(this, null)
      destIntent.putExtra("username", intent.getStringExtra("username"))
      destIntent.putExtra("household_name", intent.getStringExtra("household_name"))
      startActivity(destIntent)
    }
    binding.linearSegment3.setOnClickListener {
      val destIntent = NotificationsActivity.getIntent(this, null)
      destIntent.putExtra("username", intent.getStringExtra("username"))
      destIntent.putExtra("household_name", intent.getStringExtra("household_name"))
      startActivity(destIntent)
    }
    binding.btnGrid.setOnClickListener {
      val destIntent = AddExpenseEquallyActivity.getIntent(this, null)
      destIntent.putExtra("username", intent.getStringExtra("username"))
      destIntent.putExtra("household_name", intent.getStringExtra("household_name"))
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerExpenses(
    view: View,
    position: Int,
    item: ExpensesRowModel
  ): Unit {
    when(view.id) {
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
}
