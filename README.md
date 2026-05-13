# EnergyFlex Android Widget

Native Android widget for the EnergyFlex Energy Usage Recommendation Widget.

Built with Kotlin and Jetpack Glance.

Developed as part of the ICT Capstone Project courses at Adelaide University.

Project Team: **2026-S1-31**

## Features

Work in progress:

* Daily energy usage recommendations
* Three widget sizes: Small (2x2), Medium (2x4), and Large (4x4)
* Live updates every 30 minutes

## Project Structure

```
EnergyFlexAndroid/
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com.example.energyflexandroid/
│           │       ├── ui.theme/                           # app colors, theme, and type
│           │       ├── widget/
│           │       │   ├── EnergyFlexWidget.kt             # main widget entry point
│           │       │   ├── EnergyFlexComponents.kt         # shared reusable UI components
│           │       │   ├── SmallWidgetContent.kt           # small widget layout
│           │       │   ├── MediumWidgetContent.kt          # medium widget layout
│           │       │   ├── LargeWidgetContent.kt           # large widget layout
│           │       │   ├── EnergyFlexWidgetData.kt         # mock data for testing and previews 
│           │       │   └── EnergyFlexWidgetReceiver.kt
│           │       └── MainActivity.kt                     # launcher activity
│           ├── res/
│           │   ├── drawable/                               # widget icons, backgrounds, and graphic assets
│           │   ├── layout/
│           │   │   └── widget_loading.xml                  # initial loading layout shown before widget content loads
│           │   ├── values/                                 # app strings, colors, and resource values
│           │   └── xml/
│           │       └── energyflexandroid_widget_info.xml   # widget metadata and sizing configuration
│           └── AndroidManifest.xml                         # app configuration and widget registration
└── README.md
```

## Prerequisites

* Android Studio
* Android emulator

## Installation

### 1. Clone the repository

```
git clone https://github.com/ngongochan/EnergyFlexAndroid.git
```

### 2. Open in Android Studio

Open the cloned folder directly in Android Studio.

### 3. Sync Gradle

Allow Android Studio to download dependencies and build the project.

### 4. Run the project

Choose:
* an Android emulator
* or any physical Android device with widget support

Then hit `Run 'app'`.