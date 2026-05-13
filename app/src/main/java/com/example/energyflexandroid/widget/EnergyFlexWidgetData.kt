package com.example.energyflexandroid.widget

import androidx.compose.ui.graphics.Color

data class EnergyWidgetData(
    val renewablePercent: Float,        // 0–100
    val carbonKg: Float,
    val renewableMix: Float,            // 0–1 fraction for progress bar
    val vsAvgPercent: Int,              // e.g. +28
    val dailyCost: String,              // e.g. "$12.91"
    val rating: Rating,
    val tagline: String,                // short headline
    val proTip: String,                 // longer callout shown in large widget
    val dateLabel: String,              // e.g. "Yesterday"
    val sources: List<EnergySource>
)

data class EnergySource(val label: String, val isFossil: Boolean)

enum class Rating(val label: String) {
    EXCELLENT("Excellent"),
    GOOD("Good"),
    AVERAGE("Average"),
    POOR("Poor")
}

object WidgetColors {
    // Backgrounds
    val bgDeep   = Color(0xFF0D2226)   // darkest navy-teal
    val bgCard   = Color(0xFF132C31)   // card surface
    val bgHighlight = Color(0xFF1A3840)

    // Accents
    val green        = Color(0xFF3DDB84)   // primary green
    val greenDim     = Color(0xFF2CAF69)
    val greenBadgeBg = Color(0xFF1E4D35)

    // Fossil / warning
    val fossil   = Color(0xFFE8644A)

    // Text
    val textPrimary   = Color(0xFFE8F5F0)
    val textSecondary = Color(0xFF7AADA0)
    val textMuted     = Color(0xFF4A7A70)

    // Misc
    val divider  = Color(0xFF1F4040)
}