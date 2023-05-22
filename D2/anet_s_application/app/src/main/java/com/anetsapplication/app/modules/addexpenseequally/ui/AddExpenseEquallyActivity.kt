package com.anetsapplication.app.modules.addexpenseequally.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityAddExpenseEquallyBinding
import com.anetsapplication.app.db.*
import com.anetsapplication.app.modules.addexpensebyshares.ui.AddExpenseBySharesActivity
import com.anetsapplication.app.modules.addexpenseequally.`data`.viewmodel.AddExpenseEquallyVM
import com.anetsapplication.app.modules.addexpenseunequally.ui.AddExpenseUnequallyActivity
import com.anetsapplication.app.modules.create.ui.CreateActivity
import com.anetsapplication.app.modules.expenses.ui.ExpensesActivity
import com.anetsapplication.app.modules.addexpenseequally.data.adapter.AddExpenseEquallyAdapter
import com.anetsapplication.app.modules.addexpenseequally.data.model.AddExpenseEquallyModel
import com.anetsapplication.app.modules.households.ui.HouseholdsActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import java.lang.Double.parseDouble
import kotlin.String
import kotlin.Unit
import kotlin.math.expm1

class AddExpenseEquallyActivity :
    BaseActivity<ActivityAddExpenseEquallyBinding>(R.layout.activity_add_expense_equally) {
  private val viewModel: AddExpenseEquallyVM by viewModels<AddExpenseEquallyVM>()
  private lateinit var recyclerView: RecyclerView
  private var adapter: AddExpenseEquallyAdapter? = null
  private lateinit var expense_name: EditText
  private lateinit var expense_cost: EditText
  private lateinit var currency: EditText
  private lateinit var paidBy: EditText
  private lateinit var addBtn: Button
  private lateinit var expensesDBHelper: ExpensesDBHelper
  private lateinit var householdsHelper: HouseholdDBHelper
  private lateinit var userdataHelper: UserdataDBHelper
  private lateinit var householdUserDBHelper: HouseholdUserDBHelper
  private lateinit var debtDBHelper: DebtDBHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.addExpenseEquallyVM = viewModel

    addBtn = findViewById(R.id.btnAddExpense)
    expense_name = findViewById(R.id.enterExpenseName)
    expense_cost = findViewById(R.id.enterExpenseCost)
    currency = findViewById(R.id.enterCurrency)
    expensesDBHelper = ExpensesDBHelper(this)

    householdsHelper = HouseholdDBHelper(this)
    userdataHelper = UserdataDBHelper(this)
    householdUserDBHelper = HouseholdUserDBHelper(this)
    debtDBHelper = DebtDBHelper(this)

    recyclerView = findViewById(R.id.recyclerMembers)
    initRecyclerView()

    var householdId = intent.getStringExtra("household_id")?.toInt()

    getMembers(householdId)

    val headline: TextView = findViewById(R.id.txtHeadline)
    val stdList = householdsHelper.getDataByHouseholdID(householdId)
    headline.text = stdList[0].household_name

    var members = householdUserDBHelper.getAllMembers(householdId)

    val adapter = recyclerView.adapter as AddExpenseEquallyAdapter
    val checkedList = adapter.getChecked()

    if(intent.getStringExtra("expense_id")?.toInt() != null) {
      addBtn.text = "Edit expense"
      var stdList = expensesDBHelper.getDataByExpenseID(intent.getStringExtra("expense_id")?.toInt())
      expense_name.setText(stdList[0].expense_name)
      expense_cost.setText(stdList[0].expense_cost.toString())
      currency.setText(stdList[0].currency)
    } else {
      addBtn.text = "Add expense"
    }

    addBtn.setOnClickListener {
      val name = expense_name.text.toString()
      val cost = expense_cost.text.toString()
      val currency = currency.text.toString()

      if (TextUtils.isEmpty(name) || TextUtils.isEmpty(cost)  || TextUtils.isEmpty(currency)) {
        Toast.makeText(this, "Fill out all fields.", Toast.LENGTH_SHORT).show()
      } else {
        var numeric = true
        try {
          val num = parseDouble(cost)
        } catch (e: NumberFormatException) {
          numeric = false
        }
        if(!numeric) {
          Toast.makeText(this, "Cost must be a number.", Toast.LENGTH_SHORT).show()
        } else {
          var expenseId = intent.getStringExtra("expense_id")?.toLong()
          if(intent.getStringExtra("expense_id")?.toInt() != null) {
            Toast.makeText(this, "Expense successfully updated.", Toast.LENGTH_SHORT).show()
            expensesDBHelper.editExpense(name, cost.toDouble(), currency, 1, intent.getStringExtra("household_id")?.toInt(), intent.getStringExtra("expense_id")?.toInt());
          } else {
            Toast.makeText(this, "Expense successfully created.", Toast.LENGTH_SHORT).show()
            expenseId = expensesDBHelper.insertData(name, cost.toDouble(), currency, 0, intent.getStringExtra("household_id")?.toInt())
          }

          for (member in members) {
            if (checkedList.contains(member.user_id)) {
              if (expenseId != null) {
                debtDBHelper.insertData(expenseId.toInt(), member.user_id, cost.toDouble()/checkedList.count())
              }
            }
          }

          val destIntent = ExpensesActivity.getIntent(this, null)
          destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
          destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
          startActivity(destIntent)
        }
        }
    }
  }


  override fun setUpClicks(): Unit {
    binding.btnUnequally.setOnClickListener {
      val destIntent = AddExpenseUnequallyActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
      destIntent.putExtra("expense_id", intent.getStringExtra("expense_id"))
      startActivity(destIntent)
    }
    binding.btnByShares.setOnClickListener {
      val destIntent = AddExpenseBySharesActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
      destIntent.putExtra("expense_id", intent.getStringExtra("expense_id"))
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
    binding.imageArrowleft.setOnClickListener {
      val destIntent = ExpensesActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
      startActivity(destIntent)
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
  fun initRecyclerView() {
    recyclerView.layoutManager = LinearLayoutManager(this)
    adapter = AddExpenseEquallyAdapter()
    recyclerView.adapter = adapter
  }

  fun getMembers(household_id: Int?) {
    if (household_id == null)
      throw java.lang.Exception("Error... :]")

    val stdList = householdUserDBHelper.getAllMembers(household_id)

    Log.e("Households length XXXXXX", "${stdList.size}")
    adapter?.addItems(stdList)
  }
}
