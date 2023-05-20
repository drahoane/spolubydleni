package com.anetsapplication.app.modules.addexpenseequally.`data`.model

import kotlin.String

data class AddExpenseEquallyModel(
  var household_name: String? = "",
  var household_date: String? = "",
  var member_name: String? = "",
  var paidBy: String? = "",
  var username: String? = "",
  var user_id: Int = -1
)
