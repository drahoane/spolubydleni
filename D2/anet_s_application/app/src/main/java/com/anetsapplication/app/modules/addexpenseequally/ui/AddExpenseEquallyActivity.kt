package com.anetsapplication.app.modules.addexpenseequally.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityAddExpenseEquallyBinding
import com.anetsapplication.app.modules.addexpensebyshares.ui.AddExpenseBySharesActivity
import com.anetsapplication.app.modules.addexpenseequally.`data`.viewmodel.AddExpenseEquallyVM
import com.anetsapplication.app.modules.addexpenseequallyerror.ui.AddExpenseEquallyErrorActivity
import com.anetsapplication.app.modules.addexpenseunequally.ui.AddExpenseUnequallyActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import kotlin.String
import kotlin.Unit

class AddExpenseEquallyActivity :
    BaseActivity<ActivityAddExpenseEquallyBinding>(R.layout.activity_add_expense_equally) {
  private val viewModel: AddExpenseEquallyVM by viewModels<AddExpenseEquallyVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.addExpenseEquallyVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnAddExpense.setOnClickListener {
      val destIntent = AddExpenseEquallyErrorActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnUnequally.setOnClickListener {
      val destIntent = AddExpenseUnequallyActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnByShares.setOnClickListener {
      val destIntent = AddExpenseBySharesActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearSegment3.setOnClickListener {
      val destIntent = NotificationsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "ADD_EXPENSE_EQUALLY_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AddExpenseEquallyActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
