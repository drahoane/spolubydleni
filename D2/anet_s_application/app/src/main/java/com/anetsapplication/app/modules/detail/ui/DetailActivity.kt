package com.anetsapplication.app.modules.detail.ui

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityDetailBinding
import com.anetsapplication.app.db.CommentDBHelper
import com.anetsapplication.app.db.ExpensesDBHelper
import com.anetsapplication.app.db.HouseholdDBHelper
import com.anetsapplication.app.modules.addexpenseequally.ui.AddExpenseEquallyActivity
import com.anetsapplication.app.modules.create.ui.CreateActivity
import com.anetsapplication.app.modules.detail.data.model.DetailModel
import com.anetsapplication.app.modules.detail.`data`.viewmodel.DetailVM
import com.anetsapplication.app.modules.editexpense.ui.EditExpenseActivity
import com.anetsapplication.app.modules.expenses.ui.ExpensesActivity
import com.anetsapplication.app.modules.households.data.adapter.HouseholdsAdapter
import com.anetsapplication.app.modules.households.data.model.HouseholdsModel
import com.anetsapplication.app.modules.households.ui.HouseholdsActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import java.time.LocalDateTime
import kotlin.String
import kotlin.Unit

class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {
  private val viewModel: DetailVM by viewModels<DetailVM>()
  private lateinit var expensesHelper: ExpensesDBHelper
  private lateinit var householdsHelper: HouseholdDBHelper
  private lateinit var db: CommentDBHelper
  private lateinit var recyclerView: RecyclerView
  private var adapter: DetailAdapter? = null

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.detailVM = viewModel

    expensesHelper = ExpensesDBHelper(this)
    householdsHelper = HouseholdDBHelper(this)

    val name: TextView = findViewById(R.id.txtCupcakes)
    val price: TextView = findViewById(R.id.txtKCounter)
    val stdList2 = expensesHelper.getDataByExpenseID(intent.getStringExtra("expense_id")?.toInt())
    name.text = stdList2[0].expense_name
    price.text = stdList2[0].expense_cost.toString() + " " + stdList2[0].currency

    val headline: TextView = findViewById(R.id.txtHeadline)
    val stdList = householdsHelper.getDataByHouseholdID(intent.getStringExtra("household_id")?.toInt())
    headline.text = stdList[0].household_name
    db = CommentDBHelper(this)

    recyclerView = findViewById(R.id.recyclerMessages)
    initRecyclerView()
    getHouseholds()

    val sendComment = findViewById<FrameLayout>(R.id.commentBtn)
    sendComment.setOnClickListener {
      val message: TextView = findViewById(R.id.textMessage)
      if(TextUtils.isEmpty(message.text.toString())) {
        Toast.makeText(this, "Fill out Comment message.", Toast.LENGTH_SHORT).show()
      } else {
        var date = LocalDateTime.now().toString();
        val std = DetailModel(comment_text = message.text.toString(), created_at = date, intent.getStringExtra("expense_id")?.toInt(), intent.getStringExtra("user_id")?.toInt())
        db.insertData(std)
        Toast.makeText(this, "Comment successfully created.", Toast.LENGTH_SHORT).show()
        val destIntent = DetailActivity.getIntent(this, null)
        destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
        destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
        destIntent.putExtra("expense_id", intent.getStringExtra("expense_id"))
        startActivity(destIntent)
      }
    }
  }

  override fun setUpClicks(): Unit {
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
    binding.imageEdit.setOnClickListener {
      Log.e("EDIT", "activity")
      val destIntent = AddExpenseEquallyActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
      destIntent.putExtra("expense_id", intent.getStringExtra("expense_id"))
      startActivity(destIntent)
    }
    binding.imageTrash.setOnClickListener {
      var builder = AlertDialog.Builder(this)
      builder.setTitle("Expense remove")
      builder.setMessage("Do you really want to delete this expense?")
      builder.setCancelable(true)
      builder.setPositiveButton("Delete") { dialog, _ ->
        expensesHelper.deleteDataById(intent.getStringExtra("expense_id")?.toInt() ?: 0)
        dialog.dismiss()
        val destIntent = ExpensesActivity.getIntent(this, null)
        destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
        destIntent.putExtra("household_id", intent.getStringExtra("household_id"))
        startActivity(destIntent)
      }
      builder.setNegativeButton("Cancel") { dialog, _ ->
        dialog.dismiss()
      }

      var alert = builder.create()
      alert.show()
    }
  }

  companion object {
    const val TAG: String = "DETAIL_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DetailActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }

  fun initRecyclerView() {
    recyclerView.layoutManager = LinearLayoutManager(this)
    adapter = DetailAdapter()
    recyclerView.adapter = adapter
  }

  fun getHouseholds() {
    val expense_id = intent.getStringExtra("expense_id")
    val stdList = db.getDataByExpenseID(expense_id?.toInt())
    Log.e("Messages count", "${stdList.size}")
    if(stdList.size == 0) {
      val noFound = findViewById<RelativeLayout>(R.id.noMessagesFound)
      noFound.visibility = View.VISIBLE;
    } else {
      adapter?.addItems(stdList)
    }
  }
}
