package com.example.energyflexandroid.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.*
import androidx.glance.layout.*
import androidx.glance.text.*
import androidx.glance.unit.ColorProvider
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.text.FontWeight

// Small Widget  (2 × 2)

@Composable
fun SmallWidgetContent(data: EnergyWidgetData) {
    Box(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(WidgetColors.bgDeep)
//            .cornerRadius(16.dp)
            .padding(10.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Column(modifier = GlanceModifier.fillMaxSize()) {

            Row(
                modifier = GlanceModifier.fillMaxWidth(),
                verticalAlignment = Alignment.Vertical.CenterVertically
            ) {
                Column {
                    Row(verticalAlignment = Alignment.Vertical.CenterVertically) {
                        Box(
                            modifier = GlanceModifier
                                .size(14.dp)
//                                .cornerRadius(3.dp)
                                .background((WidgetColors.greenBadgeBg)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("⚡", style = TextStyle(fontSize = 8.sp))
                        }
                        Spacer(GlanceModifier.width(3.dp))
                        Text(
                            text = "ENERGYFLEX",
                            style = TextStyle(
                                color = ColorProvider(WidgetColors.textMuted),
                                fontSize = 7.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    Spacer(GlanceModifier.height(4.dp))
                    RatingBadge(data.rating)
                }

                Spacer(GlanceModifier.defaultWeight())

                Column(horizontalAlignment = Alignment.End) {
                    SourceIconBox(emoji = "☀️")
                    Spacer(GlanceModifier.height(4.dp))
                    SourceIconBox(emoji = "🌿")
                }
            }

            Spacer(GlanceModifier.defaultWeight())

            Row(
                modifier = GlanceModifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    RenewableHero(percent = data.renewablePercent, size = HeroSize.SMALL)
                    Text(
                        text = "renewable",
                        style = TextStyle(
                            color = ColorProvider(WidgetColors.textMuted),
                            fontSize = 8.sp
                        )
                    )
                }
                Spacer(GlanceModifier.defaultWeight())
                CarbonPill(kg = data.carbonKg, compact = true)
            }
        }
    }
}

@Composable
private fun SourceIconBox(emoji: String) {
    Box(
        modifier = GlanceModifier
            .size(28.dp)
//            .cornerRadius(8.dp)
            .background(WidgetColors.bgCard),
        contentAlignment = Alignment.Center
    ) {
        Text(emoji, style = TextStyle(fontSize = 14.sp))
    }
}