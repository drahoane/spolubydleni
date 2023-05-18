package com.anetsapplication.app.modules.signup.ui

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
import com.anetsapplication.app.databinding.ActivitySignUpBinding
import com.anetsapplication.app.db.UserdataDBHelper
import com.anetsapplication.app.modules.login.ui.LoginActivity
import com.anetsapplication.app.modules.signup.`data`.viewmodel.SignUpVM
import kotlin.String
import kotlin.Unit

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
  private val viewModel: SignUpVM by viewModels<SignUpVM>()
  private lateinit var username: EditText
  private lateinit var password: EditText
  private lateinit var controlPassword: EditText
  private lateinit var email: EditText
  private lateinit var signupBtn: Button
  private lateinit var db: UserdataDBHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUpVM = viewModel

    username = findViewById(R.id.editUsername)
    password = findViewById(R.id.editPassword)
    controlPassword = findViewById(R.id.editControlPassword)
    email = findViewById(R.id.editEmail)
    signupBtn = findViewById(R.id.btnSingUp)
    db = UserdataDBHelper(this)

    signupBtn.setOnClickListener {
      val usernameText = username.text.toString();
      val passwordText = password.text.toString();
      val controlPasswordText = controlPassword.text.toString();
      val email = email.text.toString();
      val saveData = db.insertData(usernameText, passwordText, email)

      if(TextUtils.isEmpty(usernameText) || TextUtils.isEmpty(passwordText) || TextUtils.isEmpty(controlPasswordText) || TextUtils.isEmpty(email)) {
        Toast.makeText(this, "Fill out all inputs", Toast.LENGTH_SHORT).show()
      } else {
        if(passwordText == controlPasswordText) {
          if(saveData) {
            Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show()
            val destIntent = LoginActivity.getIntent(this, null)
            startActivity(destIntent)
          } else {
            Toast.makeText(this, "User exists", Toast.LENGTH_SHORT).show()
          }
        }
        else {
          Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show()
        }
      }
    }
  }

  override fun setUpClicks(): Unit {
    binding.btnLogin.setOnClickListener {
      val destIntent = LoginActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGN_UP_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUpActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
