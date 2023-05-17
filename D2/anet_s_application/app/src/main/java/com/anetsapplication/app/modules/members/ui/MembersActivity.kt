package com.anetsapplication.app.modules.members.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityMembersBinding
import com.anetsapplication.app.modules.addexpenseequally.ui.AddExpenseEquallyActivity
import com.anetsapplication.app.modules.expenses.ui.ExpensesActivity
import com.anetsapplication.app.modules.invite.ui.InviteActivity
import com.anetsapplication.app.modules.members.`data`.model.MembersRowModel
import com.anetsapplication.app.modules.members.`data`.viewmodel.MembersVM
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import com.anetsapplication.app.modules.overview.ui.OverviewActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class MembersActivity : BaseActivity<ActivityMembersBinding>(R.layout.activity_members) {
  private val viewModel: MembersVM by viewModels<MembersVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val membersAdapter = MembersAdapter(viewModel.membersList.value?:mutableListOf())
    binding.recyclerMembers.adapter = membersAdapter
    membersAdapter.setOnItemClickListener(
    object : MembersAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : MembersRowModel) {
        onClickRecyclerMembers(view, position, item)
      }
    }
    )
    viewModel.membersList.observe(this) {
      membersAdapter.updateData(it)
    }
    binding.membersVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnExpenses.setOnClickListener {
      val destIntent = ExpensesActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearSegment3.setOnClickListener {
      val destIntent = NotificationsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnOverview.setOnClickListener {
      val destIntent = OverviewActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnGrid.setOnClickListener {
      val destIntent = AddExpenseEquallyActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.etButton.setOnClickListener {
      val destIntent = InviteActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerMembers(
    view: View,
    position: Int,
    item: MembersRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "MEMBERS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MembersActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
