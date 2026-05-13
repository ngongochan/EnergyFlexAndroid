package com.example.energyflexandroid.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.*
import androidx.glance.layout.*
import androidx.glance.text.*
import androidx.glance.unit.ColorProvider

// Medium Widget  (4 × 2)

@Composable
fun MediumWidgetContent(data: EnergyWidgetData) {
    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background((WidgetColors.bgDeep))
//            .cornerRadius(16.dp)
            .padding(12.dp)
    ) {

        AppHeader()

        Spacer(GlanceModifier.height(6.dp))

        Row(
            modifier = GlanceModifier.fillMaxWidth(),
            verticalAlignment = Alignment.Vertical.CenterVertically
        ) {
            RatingBadge(data.rating)
            Spacer(GlanceModifier.width(6.dp))
            Text(
                text = "Almost all green energy",
                style = TextStyle(
                    color = ColorProvider(WidgetColors.textSecondary),
                    fontSize = 9.sp
                )
            )
            Spacer(GlanceModifier.defaultWeight())
            CarbonPill(kg = data.carbonKg)
        }

        Spacer(GlanceModifier.height(8.dp))

        RenewableHero(percent = data.renewablePercent, size = HeroSize.MEDIUM)

        Spacer(GlanceModifier.height(6.dp))

        RenewableBar(
            renewableFraction = data.renewableMix,
            modifier = GlanceModifier.fillMaxWidth()
        )

        Spacer(GlanceModifier.height(3.dp))

        Row(
            modifier = GlanceModifier.fillMaxWidth(),
            verticalAlignment = Alignment.Vertical.CenterVertically
        ) {
            BarLegend()
            Spacer(GlanceModifier.defaultWeight())
            Text(
                text = "very low emissions",
                style = TextStyle(
                    color = ColorProvider(WidgetColors.textMuted),
                    fontSize = 7.sp
                )
            )
        }

        Spacer(GlanceModifier.defaultWeight())

        WidgetDivider()
        Spacer(GlanceModifier.height(5.dp))
        Text(
            text = data.tagline,
            style = TextStyle(
                color = ColorProvider(WidgetColors.textSecondary),
                fontSize = 9.sp
            )
        )
    }
}