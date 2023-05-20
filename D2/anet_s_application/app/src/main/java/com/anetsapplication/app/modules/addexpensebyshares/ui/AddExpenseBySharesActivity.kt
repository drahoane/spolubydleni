package com.anetsapplication.app.modules.addexpensebyshares.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityAddExpenseBySharesBinding
import com.anetsapplication.app.modules.addexpensebyshares.`data`.model.Listavatars3dav1RowModel
import com.anetsapplication.app.modules.addexpensebyshares.`data`.viewmodel.AddExpenseBySharesVM
import com.anetsapplication.app.modules.addexpenseequally.ui.AddExpenseEquallyActivity
import com.anetsapplication.app.modules.addexpenseunequally.ui.AddExpenseUnequallyActivity
import com.anetsapplication.app.modules.create.ui.CreateActivity
import com.anetsapplication.app.modules.expenses.ui.ExpensesActivity
import com.anetsapplication.app.modules.households.ui.HouseholdsActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AddExpenseBySharesActivity :
    BaseActivity<ActivityAddExpenseBySharesBinding>(R.layout.activity_add_expense_by_shares) {
  private val viewModel: AddExpenseBySharesVM by viewModels<AddExpenseBySharesVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listavatars3davAdapter =
    Listavatars3davAdapter(viewModel.listavatars3davList.value?:mutableListOf())
    /*binding.recyclerListavatars3dav.adapter = listavatars3davAdapter
    listavatars3davAdapter.setOnItemClickListener(
    object : Listavatars3davAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listavatars3dav1RowModel) {
        onClickRecyclerListavatars3dav(view, position, item)
      }
    }
    )
    viewModel.listavatars3davList.observe(this) {
      listavatars3davAdapter.updateData(it)
    }*/
    binding.addExpenseBySharesVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnEqually.setOnClickListener {
      val destIntent = AddExpenseEquallyActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
      destIntent.putExtra("expense_id", intent.getStringExtra("expense_id"))
      startActivity(destIntent)
    }
    binding.linearTab2.setOnClickListener {
      val destIntent = AddExpenseUnequallyActivity.getIntent(this, null)
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
    item: Listavatars3dav1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "ADD_EXPENSE_BY_SHARES_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AddExpenseBySharesActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
