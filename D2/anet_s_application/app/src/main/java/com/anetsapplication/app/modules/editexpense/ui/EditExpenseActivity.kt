package com.anetsapplication.app.modules.editexpense.ui

import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityEditExpenseBinding
import com.anetsapplication.app.modules.detail.ui.DetailActivity
import com.anetsapplication.app.modules.editexpense.`data`.viewmodel.EditExpenseVM
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import kotlin.String
import kotlin.Unit

class EditExpenseActivity : BaseActivity<ActivityEditExpenseBinding>(R.layout.activity_edit_expense)
    {
  private val viewModel: EditExpenseVM by viewModels<EditExpenseVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.editExpenseVM = viewModel
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
