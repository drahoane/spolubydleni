package com.anetsapplication.app.modules.expenses.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityExpensesBinding
import com.anetsapplication.app.modules.addexpenseequally.ui.AddExpenseEquallyActivity
import com.anetsapplication.app.modules.detail.ui.DetailActivity
import com.anetsapplication.app.modules.expenses.`data`.model.ExpensesRowModel
import com.anetsapplication.app.modules.expenses.`data`.viewmodel.ExpensesVM
import com.anetsapplication.app.modules.members.ui.MembersActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import com.anetsapplication.app.modules.overview.ui.OverviewActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ExpensesActivity : BaseActivity<ActivityExpensesBinding>(R.layout.activity_expenses) {
  private val viewModel: ExpensesVM by viewModels<ExpensesVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val expensesAdapter = ExpensesAdapter(viewModel.expensesList.value?:mutableListOf())
    binding.recyclerExpenses.adapter = expensesAdapter
    expensesAdapter.setOnItemClickListener(
    object : ExpensesAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ExpensesRowModel) {
        onClickRecyclerExpenses(view, position, item)
      }
    }
    )
    viewModel.expensesList.observe(this) {
      expensesAdapter.updateData(it)
    }
    binding.expensesVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnMembers.setOnClickListener {
      val destIntent = MembersActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnGrid.setOnClickListener {
      val destIntent = AddExpenseEquallyActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnOverview.setOnClickListener {
      val destIntent = OverviewActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearStatelayer.setOnClickListener {
      val destIntent = DetailActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearSegment3.setOnClickListener {
      val destIntent = NotificationsActivity.getIntent(this, null)
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
