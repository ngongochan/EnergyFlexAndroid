package com.example.energyflexandroid.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.*
import androidx.glance.action.clickable
import androidx.glance.appwidget.action.actionStartActivity
import androidx.glance.color.ColorProvider
import androidx.glance.layout.*
import androidx.glance.text.*
import androidx.glance.unit.ColorProvider
import com.example.energyflexandroid.MainActivity

// ─────────────────────────────────────────────────────────────────────────────
// Shared composable primitives for EnergyFlex widgets
// ─────────────────────────────────────────────────────────────────────────────

/** Pill badge: "⚡ EXCELLENT" */
@Composable
fun RatingBadge(rating: Rating) {
    val icon = when (rating) {
        Rating.EXCELLENT -> "⚡"
        Rating.GOOD      -> "✓"
        Rating.AVERAGE   -> "~"
        Rating.POOR      -> "!"
    }
    Row(
        modifier = GlanceModifier
            .background(ColorProvider(WidgetColors.greenBadgeBg))
//            .cornerRadius(20.dp)
            .padding(horizontal = 8.dp, vertical = 3.dp),
        verticalAlignment = Alignment.Vertical.CenterVertically
    ) {
        Text(
            text = "$icon ${rating.label.uppercase()}",
            style = TextStyle(
                color = ColorProvider(WidgetColors.green),
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

/** "94.7%" hero number */
@Composable
fun RenewableHero(
    percent: Float,
    size: HeroSize = HeroSize.LARGE
) {
    val (numberSp, labelSp) = when (size) {
        HeroSize.SMALL  -> 32.sp to 11.sp
        HeroSize.MEDIUM -> 42.sp to 13.sp
        HeroSize.LARGE  -> 48.sp to 13.sp
    }
    Row(verticalAlignment = Alignment.Bottom) {
        Text(
            text = "${percent.let { "%.1f".format(it) }}",
            style = TextStyle(
                color = ColorProvider(WidgetColors.green),
                fontSize = numberSp,
                fontWeight = FontWeight.Bold
            )
        )
        Column(modifier = GlanceModifier.padding(start = 2.dp, bottom = 6.dp)) {
            Text(
                text = "%",
                style = TextStyle(
                    color = ColorProvider(WidgetColors.green),
                    fontSize = labelSp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "renewable",
                style = TextStyle(
                    color = ColorProvider(WidgetColors.textSecondary),
                    fontSize = 8.sp
                )
            )
        }
    }
}

enum class HeroSize { SMALL, MEDIUM, LARGE }

/** Carbon pill: "0.7 kg CO₂" */
@Composable
fun CarbonPill(kg: Float, compact: Boolean = false) {
    Row(
        modifier = GlanceModifier
            .background(ColorProvider(WidgetColors.bgHighlight))
//            .cornerRadius(12.dp)
            .padding(horizontal = 6.dp, vertical = 3.dp),
        verticalAlignment = Alignment.Vertical.CenterVertically
    ) {
        Text(
            text = "🌿 ${"%.1f".format(kg)} kg CO₂",
            style = TextStyle(
                color = ColorProvider(WidgetColors.textSecondary),
                fontSize = if (compact) 8.sp else 9.sp
            )
        )
    }
}

@Composable
fun RenewableBar(
    renewableFraction: Float,
    modifier: GlanceModifier = GlanceModifier
) {
    val totalWidth = LocalSize.current.width
    val renewableWidth = totalWidth * renewableFraction

    Row(
        modifier = modifier
            .height(5.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = GlanceModifier
                .width(renewableWidth)
                .fillMaxHeight()
                .background((WidgetColors.green))
        ) {}
        Box(
            modifier = GlanceModifier
                .fillMaxWidth()   // takes remaining space
                .fillMaxHeight()
                .background((WidgetColors.fossil))
        ) {}
    }
}

/** "● Renewable  ● Fossil" legend row */
@Composable
fun BarLegend() {
    Row(horizontalAlignment = Alignment.Start) {
        LegendDot(WidgetColors.green, "Renewable")
        Spacer(GlanceModifier.width(10.dp))
        LegendDot(WidgetColors.fossil, "Fossil")
    }
}

@Composable
private fun LegendDot(color: Color, label: String) {
    Row(verticalAlignment = Alignment.Vertical.CenterVertically) {
        Box(
            modifier = GlanceModifier
                .size(5.dp)
//                .cornerRadius(3.dp)
                .background((color))
        ) {}
        Spacer(GlanceModifier.width(3.dp))
        Text(
            text = label,
            style = TextStyle(
                color = ColorProvider(WidgetColors.textMuted),
                fontSize = 8.sp
            )
        )
    }
}

/** Stat column: value + sub-label (used in large widget stat row) */
@Composable
fun StatColumn(value: String, label: String, valueColor: Color = WidgetColors.textPrimary) {
    Column {
        Text(
            text = value,
            style = TextStyle(
                color = ColorProvider(valueColor),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = label,
            style = TextStyle(
                color = ColorProvider(WidgetColors.textMuted),
                fontSize = 8.sp
            )
        )
    }
}

/** Thin horizontal divider */
@Composable
fun WidgetDivider() {
    Box(
        modifier = GlanceModifier
            .fillMaxWidth()
            .height(1.dp)
            .background(ColorProvider(WidgetColors.divider))
    ) {}
}

/** App name header row shared by medium + large */
@Composable
fun AppHeader(dateLabel: String = "") {
    Row(
        modifier = GlanceModifier.fillMaxWidth(),
        verticalAlignment = Alignment.Vertical.CenterVertically,
        horizontalAlignment = Alignment.Start
    ) {
        // Logo mark
        Box(
            modifier = GlanceModifier
                .size(16.dp)
//                .cornerRadius(4.dp)
                .background((WidgetColors.greenBadgeBg)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "⚡",
                style = TextStyle(fontSize = 9.sp)
            )
        }
        Spacer(GlanceModifier.width(5.dp))
        Text(
            text = "ENERGYFLEX",
            style = TextStyle(
                color = ColorProvider(WidgetColors.textSecondary),
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(GlanceModifier.defaultWeight())
        if (dateLabel.isNotEmpty()) {
            Text(
                text = dateLabel,
                style = TextStyle(
                    color = ColorProvider(WidgetColors.textMuted),
                    fontSize = 8.sp
                )
            )
        }
    }
}