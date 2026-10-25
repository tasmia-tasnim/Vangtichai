package com.example.vangtichai

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentAmount: Long = 0
    private lateinit var tvTotalAmount: TextView

    // Map denominations to their TextViews
    private val denominations = listOf(500, 100, 50, 20, 10, 5, 2, 1)
    private var noteViews = mapOf<Int, TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Initialize the Display and Note Views
        // If 'R' is red here, don't panic. Read the "Final Step" below.
        tvTotalAmount = findViewById(R.id.tvTotalAmount)

        noteViews = mapOf(
            500 to findViewById(R.id.tv500),
            100 to findViewById(R.id.tv100),
            50 to findViewById(R.id.tv50),
            20 to findViewById(R.id.tv20),
            10 to findViewById(R.id.tv10),
            5 to findViewById(R.id.tv5),
            2 to findViewById(R.id.tv2),
            1 to findViewById(R.id.tv1)
        )

        // 2. Setup CLEAR Button
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentAmount = 0
            updateUI()
        }

        // 3. Setup Number Buttons (Explicit Wiring)
        val numberButtonIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        for (id in numberButtonIds) {
            findViewById<Button>(id).setOnClickListener { view ->
                onDigitPressed(view)
            }
        }

        // 4. Restore State (Rotation)
        if (savedInstanceState != null) {
            currentAmount = savedInstanceState.getLong("AMOUNT_KEY")
        }
        updateUI()
    }

    // Logic for when a number is pressed
    private fun onDigitPressed(view: View) {
        if (view is Button) {
            // We use safe logic here to avoid crashing if text isn't a number
            val digitText = view.text.toString()
            // Just in case the button text is "Clear" or something else (safety check)
            if (digitText.all { it.isDigit() }) {
                val digit = digitText.toLong()
                currentAmount = (currentAmount * 10) + digit
                updateUI()
            }
        }
    }

    private fun updateUI() {
        tvTotalAmount.text = getString(R.string.label_taka) + " $currentAmount"

        var remaining = currentAmount
        for (note in denominations) {
            val count = remaining / note
            remaining %= note
            noteViews[note]?.text = "$note: $count" // e.g. "500: 2"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("AMOUNT_KEY", currentAmount)
    }
}