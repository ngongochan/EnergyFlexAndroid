package com.example.energyflexandroid.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.*
import androidx.glance.layout.*
import androidx.glance.text.*
import androidx.glance.unit.ColorProvider

// Large Widget  (4 × 4)

@Composable
fun LargeWidgetContent(data: EnergyWidgetData) {
    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(WidgetColors.bgDeep)
//            .cornerRadius(16.dp)
            .padding(12.dp)
    ) {

        AppHeader(dateLabel = data.dateLabel)

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
                    color = ColorProvider(WidgetColors.textPrimary),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(GlanceModifier.defaultWeight())
            CarbonPill(kg = data.carbonKg)
        }

        Spacer(GlanceModifier.height(8.dp))

        RenewableHero(percent = data.renewablePercent, size = HeroSize.LARGE)

        Spacer(GlanceModifier.height(6.dp))

        Row(
            modifier = GlanceModifier.fillMaxWidth(),
            verticalAlignment = Alignment.Vertical.CenterVertically
        ) {
            Text(
                text = "YOUR RENEWABLE MIX",
                style = TextStyle(
                    color = ColorProvider(WidgetColors.textMuted),
                    fontSize = 7.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(GlanceModifier.defaultWeight())
            val renewPct = (data.renewableMix * 100).toInt()
            val fossilPct = 100 - renewPct
            Text(
                text = "$renewPct% clean · $fossilPct% fossil",
                style = TextStyle(
                    color = ColorProvider(WidgetColors.textMuted),
                    fontSize = 7.sp
                )
            )
        }

        Spacer(GlanceModifier.height(4.dp))

        // progress bar
        RenewableBar(
            renewableFraction = data.renewableMix,
            modifier = GlanceModifier.fillMaxWidth()
        )

        Spacer(GlanceModifier.height(3.dp))
        BarLegend()

        Spacer(GlanceModifier.height(10.dp))
        WidgetDivider()
        Spacer(GlanceModifier.height(10.dp))

        Row(
            modifier = GlanceModifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Column {
                Text(
                    text = "CARBON",
                    style = TextStyle(
                        color = ColorProvider(WidgetColors.textMuted),
                        fontSize = 7.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(GlanceModifier.height(2.dp))
                StatColumn(
                    value = "${"%.1f".format(data.carbonKg)} kg",
                    label = "daily total"
                )
            }

            Spacer(GlanceModifier.defaultWeight())

            Column {
                Text(
                    text = "VS AVERAGE",
                    style = TextStyle(
                        color = ColorProvider(WidgetColors.textMuted),
                        fontSize = 7.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(GlanceModifier.height(2.dp))
                StatColumn(
                    value = "+${data.vsAvgPercent}%",
                    label = "above avg",
                    valueColor = WidgetColors.green
                )
            }

            Spacer(GlanceModifier.defaultWeight())

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "DAILY COST",
                    style = TextStyle(
                        color = ColorProvider(WidgetColors.textMuted),
                        fontSize = 7.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(GlanceModifier.height(2.dp))
                StatColumn(
                    value = data.dailyCost,
                    label = "yesterday"
                )
            }
        }

        Spacer(GlanceModifier.height(10.dp))

        ProTipCard(tip = data.proTip)

        Spacer(GlanceModifier.defaultWeight())

        WidgetDivider()
        Spacer(GlanceModifier.height(6.dp))
        Row(
            modifier = GlanceModifier.fillMaxWidth(),
            verticalAlignment = Alignment.Vertical.CenterVertically
        ) {
            data.sources.take(3).forEach { src ->
                SourceTag(src)
                Spacer(GlanceModifier.width(4.dp))
            }
            Spacer(GlanceModifier.defaultWeight())
            Text(
                text = "Open app →",
                style = TextStyle(
                    color = ColorProvider(WidgetColors.green),
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}


@Composable
private fun ProTipCard(tip: String) {
    Row(
        modifier = GlanceModifier
            .fillMaxWidth()
            .background(WidgetColors.bgHighlight)
//            .cornerRadius(10.dp)
            .padding(horizontal = 10.dp, vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = "⚡",
            style = TextStyle(fontSize = 12.sp)
        )
        Spacer(GlanceModifier.width(6.dp))
        Column {
            Text(
                text = "AMAZING DAY FOR RENEWABLES!",
                style = TextStyle(
                    color = ColorProvider(WidgetColors.green),
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(GlanceModifier.height(2.dp))
            Text(
                text = tip,
                style = TextStyle(
                    color = ColorProvider(WidgetColors.textSecondary),
                    fontSize = 8.sp
                ),
                maxLines = 2
            )
        }
    }
}


@Composable
private fun SourceTag(source: EnergySource) {
    Box(
        modifier = GlanceModifier
            .background(
                ColorProvider(
                    if (source.isFossil) WidgetColors.bgCard else WidgetColors.greenBadgeBg
                )
            )
//            .cornerRadius(8.dp)
            .padding(horizontal = 5.dp, vertical = 2.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = source.label,
            style = TextStyle(
                color = ColorProvider(
                    if (source.isFossil) WidgetColors.textMuted else WidgetColors.green
                ),
                fontSize = 7.sp
            )
        )
    }
}