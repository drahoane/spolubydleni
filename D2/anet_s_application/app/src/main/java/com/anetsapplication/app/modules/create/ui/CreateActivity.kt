package com.anetsapplication.app.modules.create.ui

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
import com.anetsapplication.app.databinding.ActivityCreateBinding
import com.anetsapplication.app.db.HouseholdDBHelper
import com.anetsapplication.app.db.UserdataDBHelper
import com.anetsapplication.app.modules.create.`data`.viewmodel.CreateVM
import com.anetsapplication.app.modules.households.data.model.HouseholdsModel
import com.anetsapplication.app.modules.households.ui.HouseholdsActivity
import com.anetsapplication.app.modules.invite.ui.InviteActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.String
import kotlin.Unit

class CreateActivity : BaseActivity<ActivityCreateBinding>(R.layout.activity_create) {
  private val viewModel: CreateVM by viewModels<CreateVM>()
  private lateinit var household_name: EditText
  private lateinit var createBtn: Button
  private lateinit var db: HouseholdDBHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.createVM = viewModel

    household_name = findViewById(R.id.enterHousehold)
    createBtn = findViewById(R.id.btnCreate)
    db = HouseholdDBHelper(this)

    createBtn.setOnClickListener {
      val householdText = household_name.text.toString();
      val date = LocalDateTime.now().toString()

      if(TextUtils.isEmpty(householdText)) {
        Toast.makeText(this, "Fill out Household name.", Toast.LENGTH_SHORT).show()
      } else {
        val std = HouseholdsModel(household_name = householdText, household_date = date)
        db.insertData(std, intent.getStringExtra("user_id")?.toInt())
        Toast.makeText(this, "Household successfully created.", Toast.LENGTH_SHORT).show()
        val destIntent = HouseholdsActivity.getIntent(this, null)
        destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
        startActivity(destIntent)
      }
    }
  }

  override fun setUpClicks(): Unit {
    binding.linearSegment3.setOnClickListener {
      val destIntent = NotificationsActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      startActivity(destIntent)
    }
    binding.linearSegment2.setOnClickListener {
      val destIntent = HouseholdsActivity.getIntent(this, null)
      destIntent.putExtra("user_id", intent.getStringExtra("user_id"))
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "CREATE_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, CreateActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
