package com.anetsapplication.app.modules.addexpenseequally.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityAddExpenseEquallyBinding
import com.anetsapplication.app.db.ExpensesDBHelper
import com.anetsapplication.app.modules.addexpensebyshares.ui.AddExpenseBySharesActivity
import com.anetsapplication.app.modules.addexpenseequally.`data`.viewmodel.AddExpenseEquallyVM
import com.anetsapplication.app.modules.addexpenseequallyerror.ui.AddExpenseEquallyErrorActivity
import com.anetsapplication.app.modules.addexpenseunequally.ui.AddExpenseUnequallyActivity
import com.anetsapplication.app.modules.expenses.ui.ExpensesActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import java.time.LocalDateTime
import java.util.*
import kotlin.String
import kotlin.Unit

class AddExpenseEquallyActivity :
    BaseActivity<ActivityAddExpenseEquallyBinding>(R.layout.activity_add_expense_equally) {
  private val viewModel: AddExpenseEquallyVM by viewModels<AddExpenseEquallyVM>()
  private lateinit var expense_name: EditText
  private lateinit var expense_cost: EditText
  private lateinit var currency: EditText
  private lateinit var paidBy: EditText
  private lateinit var addBtn: Button
  private lateinit var db: ExpensesDBHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.addExpenseEquallyVM = viewModel

    addBtn = findViewById(R.id.btnAddExpense)
    expense_name = findViewById(R.id.enterExpenseName)
    expense_cost = findViewById(R.id.enterExpenseCost)
    currency = findViewById(R.id.enterCurrency)
    paidBy = findViewById(R.id.enterPaidBy)
    db = ExpensesDBHelper(this)

    addBtn.setOnClickListener {
      val name = expense_name.text.toString()
      val cost = expense_cost.text.toString()
      val currency = currency.text.toString()
      val paidBy = paidBy.text.toString()

      val date = LocalDateTime.now().toString()

      if (TextUtils.isEmpty(name) || TextUtils.isEmpty(cost) || TextUtils.isEmpty(currency) || TextUtils.isEmpty(paidBy)) {
        Toast.makeText(this, "Fill out all fields.", Toast.LENGTH_SHORT).show()
      } else {
        db.insertData(name, cost, currency, paidBy)
        Toast.makeText(this, "Expense successfully created.", Toast.LENGTH_SHORT).show()
        val destIntent = ExpensesActivity.getIntent(this, null)
        destIntent.putExtra("username", intent.getStringExtra("username"))
        startActivity(destIntent)
      }
    }
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
