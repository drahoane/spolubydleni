package com.anetsapplication.app.modules.expenses.`data`.model

import kotlin.String

data class ExpensesModel(
  var username: String? = "",
  var expense_id: Int? = -1,
  var expense_name: String? = "",
  var expense_cost: Double? = -1.0,
  var currency: String? = "",
  var paid_by_id: Int? = -1,
)
