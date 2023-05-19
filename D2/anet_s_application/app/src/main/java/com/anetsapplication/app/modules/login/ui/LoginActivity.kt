package com.anetsapplication.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.anetsapplication.app.R
import com.anetsapplication.app.appcomponents.base.BaseActivity
import com.anetsapplication.app.databinding.ActivityLoginBinding
import com.anetsapplication.app.modules.households.ui.HouseholdsActivity
import com.anetsapplication.app.db.UserdataDBHelper
import com.anetsapplication.app.modules.login.`data`.viewmodel.LoginVM
import com.anetsapplication.app.modules.signup.ui.SignUpActivity
import kotlin.String
import kotlin.Unit

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login)  {
  private val viewModel: LoginVM by viewModels<LoginVM>()
  private lateinit var username: EditText
  private lateinit var password: EditText
  private lateinit var loginBtn: Button
  private lateinit var db: UserdataDBHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loginVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = SignUpActivity.getIntent(this, null)
      //startActivity(destIntent)
      //finish()
      }, 3000)

    username = findViewById(R.id.enterUsername)
    password = findViewById(R.id.enterPassword)
    loginBtn = findViewById(R.id.btnLogin)
    db = UserdataDBHelper(this)

    loginBtn.setOnClickListener {
      val usernameText = username.text.toString();
      val passwordText = password.text.toString();

      if(TextUtils.isEmpty(usernameText) || TextUtils.isEmpty(passwordText)) {
        Toast.makeText(this, "Fill out all inputs", Toast.LENGTH_SHORT).show()
      } else {
        val checkUser = db.checkUserLogin(usernameText, passwordText)
        if(checkUser) {
          Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
          val destIntent = HouseholdsActivity.getIntent(this, null)
          destIntent.putExtra("username", usernameText)
          startActivity(destIntent)
        } else {
          Toast.makeText(this, "Password & username don't match", Toast.LENGTH_SHORT).show()
        }
      }
    }
  }
  override fun setUpClicks(): Unit {
    binding.btnSignUp.setOnClickListener {
      val destIntent = SignUpActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "LOGIN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, LoginActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
