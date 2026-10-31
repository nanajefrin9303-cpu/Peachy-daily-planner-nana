
package com.peachy.dailyplanner

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bg = Color.rgb(248, 243, 255)
        val purple = Color.rgb(185, 155, 232)
        val dark = Color.rgb(75, 57, 100)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 32, 24, 24)
            setBackgroundColor(bg)
        }

        val title = TextView(this).apply {
            text = "🌷 Peachy Daily Planner"
            textSize = 27f
            setTextColor(dark)
            gravity = Gravity.CENTER
        }
        layout.addView(title)

        val subtitle = TextView(this).apply {
            text = "A little plan for a lovely day 💜"
            textSize = 16f
            gravity = Gravity.CENTER
            setTextColor(dark)
        }
        layout.addView(subtitle)

        val input = EditText(this).apply {
            hint = "Write your task here..."
            setSingleLine()
        }
        layout.addView(input)

        val add = Button(this).apply {
            text = "＋ Add Task"
            setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(purple)
            )
        }
        layout.addView(add)

        val tasks = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }
        layout.addView(tasks)

        add.setOnClickListener {
            val text = input.text.toString().trim()
            if (text.isNotEmpty()) {
                val check = CheckBox(this)
                check.text = text
                check.textSize = 17f
                check.setTextColor(dark)
                tasks.addView(check)
                input.text.clear()
            }
        }

        setContentView(layout)
    }
}
