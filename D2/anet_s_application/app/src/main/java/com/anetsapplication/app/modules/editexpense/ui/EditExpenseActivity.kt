package com.anetsapplication.app.modules.editexpense.ui

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityEditExpenseBinding
import com.anetsapplication.app.db.ExpensesDBHelper
import com.anetsapplication.app.modules.detail.ui.DetailActivity
import com.anetsapplication.app.modules.editexpense.`data`.viewmodel.EditExpenseVM
import com.anetsapplication.app.modules.expenses.ui.ExpensesActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import kotlin.String
import kotlin.Unit

class EditExpenseActivity : BaseActivity<ActivityEditExpenseBinding>(R.layout.activity_edit_expense) {
  private val viewModel: EditExpenseVM by viewModels<EditExpenseVM>()
  private lateinit var editBtn: Button
  private lateinit var inputName: EditText
  private lateinit var inputCost: EditText
  private lateinit var inputCurrency: EditText
  private lateinit var inputPaidBy: EditText
  private lateinit var db: ExpensesDBHelper


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.editExpenseVM = viewModel

    editBtn = findViewById(R.id.btnEditExpense)
    inputName = findViewById(R.id.enterEditName)
    inputCost = findViewById(R.id.enterEditCost)
    inputCurrency = findViewById(R.id.enterEditCurrency)
    inputPaidBy = findViewById(R.id.enterEditPaidBy)

    editBtn.setOnClickListener {
      val name = inputName.text.toString()
      val cost = inputCost.text.toString()
      val currency = inputCurrency.text.toString()
      val paidBy = inputPaidBy.text.toString()

      val expenseId = intent.getStringExtra("expense_id").toString().toInt()
      val oldData = db.getDataByExpenseID(expenseId)

      if (oldData.isEmpty()) {
        Toast.makeText(this, "Expense with id=${expenseId} does not exist.", Toast.LENGTH_SHORT).show()
      } else {
        Toast.makeText(this, "Expense successfully created.", Toast.LENGTH_SHORT).show()
        db.editExpense(oldData, name, cost.toDouble(), currency, paidBy.toInt(), intent.getStringExtra("household_id")?.toInt());
        val destIntent = ExpensesActivity.getIntent(this, null)
        destIntent.putExtra("username", intent.getStringExtra("username"))
        startActivity(destIntent)
      }
    }
  }

  override fun setUpClicks(): Unit {
    binding.btnEditExpense.setOnClickListener {
      val destIntent = DetailActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearSegment3.setOnClickListener {
      val destIntent = NotificationsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "EDIT_EXPENSE_ACTIVITY"

  }
}
