package com.example.energyflexandroid.widget

import com.example.energyflexandroid.widget.EnergyWidgetData
import com.example.energyflexandroid.widget.SmallWidgetContent
import com.example.energyflexandroid.widget.MediumWidgetContent
import com.example.energyflexandroid.widget.LargeWidgetContent

import android.content.Context

import androidx.glance.text.*
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent

import androidx.glance.appwidget.SizeMode
import androidx.glance.LocalSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

class EnergyFlexWidget : GlanceAppWidget() {

    companion object {
        val SMALL  = DpSize(120.dp, 120.dp)   // 2 × 2
        val MEDIUM = DpSize(240.dp, 120.dp)   // 4 × 2
        val LARGE  = DpSize(240.dp, 240.dp)   // 4 × 4
    }

    // the sizes we support
    override val sizeMode = SizeMode.Responsive(
        setOf(SMALL, MEDIUM, LARGE)
    )

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        // in the real app, load from DataStore / WorkManager results
        val data = sampleData()

        provideContent {
            WidgetRoot(data)
        }
    }
}

@Composable
private fun WidgetRoot(data: EnergyWidgetData) {
    val size = LocalSize.current
    when {
        size.width  >= EnergyFlexWidget.LARGE.width &&
                size.height >= EnergyFlexWidget.LARGE.height -> LargeWidgetContent(data)

        size.width  >= EnergyFlexWidget.MEDIUM.width -> MediumWidgetContent(data)

        else -> SmallWidgetContent(data)
    }
}

// sample data
private fun sampleData() = EnergyWidgetData(
    renewablePercent = 94.7f,
    carbonKg         = 0.7f,
    renewableMix     = 0.947f,
    vsAvgPercent     = 28,
    dailyCost        = "\$12.91",
    rating           = Rating.EXCELLENT,
    tagline          = "Almost all your energy was clean — great job!",
    proTip           = "Almost all your power came from solar, wind, and hydro. Keep running appliances during daylight for the best results.",
    dateLabel        = "Yesterday",
    sources = listOf(
        EnergySource("Solar",  isFossil = false),
        EnergySource("Wind",   isFossil = false),
        EnergySource("Hydro",  isFossil = false),
        EnergySource("Gas",    isFossil = true)
    )
)