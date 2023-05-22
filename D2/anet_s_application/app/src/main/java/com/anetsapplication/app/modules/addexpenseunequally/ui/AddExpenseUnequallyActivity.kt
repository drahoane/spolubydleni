package com.anetsapplication.app.modules.addexpenseunequally.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityAddExpenseUnequallyBinding
import com.anetsapplication.app.db.ExpensesDBHelper
import com.anetsapplication.app.modules.addexpensebyshares.ui.AddExpenseBySharesActivity
import com.anetsapplication.app.modules.addexpenseequally.ui.AddExpenseEquallyActivity
import com.anetsapplication.app.modules.addexpenseunequally.`data`.model.Listavatars3davRowModel
import com.anetsapplication.app.modules.addexpenseunequally.`data`.viewmodel.AddExpenseUnequallyVM
import com.anetsapplication.app.modules.create.ui.CreateActivity
import com.anetsapplication.app.modules.expenses.ui.ExpensesActivity
import com.anetsapplication.app.modules.households.ui.HouseholdsActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AddExpenseUnequallyActivity :
    BaseActivity<ActivityAddExpenseUnequallyBinding>(R.layout.activity_add_expense_unequally) {
  private val viewModel: AddExpenseUnequallyVM by viewModels<AddExpenseUnequallyVM>()
  private lateinit var expense_name: EditText
  private lateinit var expense_cost: EditText
  private lateinit var currency: EditText
  private lateinit var paidBy: EditText
  private lateinit var addBtn: Button
  private lateinit var expensesDBHelper: ExpensesDBHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listavatars3davAdapter =
    Listavatars3davAdapter(viewModel.listavatars3davList.value?:mutableListOf())
    /*binding.recyclerListavatars3dav.adapter = listavatars3davAdapter
    listavatars3davAdapter.setOnItemClickListener(
    object : Listavatars3davAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listavatars3davRowModel) {
        onClickRecyclerListavatars3dav(view, position, item)
      }
    }
    )
    viewModel.listavatars3davList.observe(this) {
      listavatars3davAdapter.updateData(it)
    }
    binding.addExpenseUnequallyVM = viewModel*/

    expensesDBHelper = ExpensesDBHelper(this)

    addBtn = findViewById(R.id.btnAddExpense)
    expense_name = findViewById(R.id.enterExpenseName)
    expense_cost = findViewById(R.id.enterExpenseCost)
    currency = findViewById(R.id.enterCurrency)

    if(intent.getStringExtra("expense_id")?.toInt() != null) {
      addBtn.text = "Edit expense"
      var stdList = expensesDBHelper.getDataByExpenseID(intent.getStringExtra("expense_id")?.toInt())
      expense_name.setText(stdList[0].expense_name)
      expense_cost.setText(stdList[0].expense_cost.toString())
      currency.setText(stdList[0].currency)
    } else {
      addBtn.text = "Add expense"
    }
  }

  override fun setUpClicks(): Unit {
    binding.linearTab1.setOnClickListener {
      val destIntent = AddExpenseEquallyActivity.getIntent(this, null)
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

  fun onClickRecyclerListavatars3dav(
    view: View,
    position: Int,
    item: Listavatars3davRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "ADD_EXPENSE_UNEQUALLY_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AddExpenseUnequallyActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
