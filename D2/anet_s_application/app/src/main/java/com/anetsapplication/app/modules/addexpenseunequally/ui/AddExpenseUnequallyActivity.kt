package com.anetsapplication.app.modules.addexpenseunequally.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityAddExpenseUnequallyBinding
import com.anetsapplication.app.modules.addexpensebyshares.ui.AddExpenseBySharesActivity
import com.anetsapplication.app.modules.addexpenseequally.ui.AddExpenseEquallyActivity
import com.anetsapplication.app.modules.addexpenseunequally.`data`.model.Listavatars3davRowModel
import com.anetsapplication.app.modules.addexpenseunequally.`data`.viewmodel.AddExpenseUnequallyVM
import com.anetsapplication.app.modules.expenses.ui.ExpensesActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AddExpenseUnequallyActivity :
    BaseActivity<ActivityAddExpenseUnequallyBinding>(R.layout.activity_add_expense_unequally) {
  private val viewModel: AddExpenseUnequallyVM by viewModels<AddExpenseUnequallyVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listavatars3davAdapter =
    Listavatars3davAdapter(viewModel.listavatars3davList.value?:mutableListOf())
    binding.recyclerListavatars3dav.adapter = listavatars3davAdapter
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
    binding.addExpenseUnequallyVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnAddExpense.setOnClickListener {
      val destIntent = ExpensesActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearSegment3.setOnClickListener {
      val destIntent = NotificationsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnByShares.setOnClickListener {
      val destIntent = AddExpenseBySharesActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearTab1.setOnClickListener {
      val destIntent = AddExpenseEquallyActivity.getIntent(this, null)
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
