# VangtiChai

A simple Android application for calculating Bangladeshi currency denomination breakdown (Vangti).

## Overview

VangtiChai allows users to enter an amount in Bangladeshi Taka (BDT) and immediately calculates the minimum number of notes and coins required to make up that total amount.

Supported denominations:
- 500 Taka
- 100 Taka
- 50 Taka
- 20 Taka
- 10 Taka
- 5 Taka
- 2 Taka
- 1 Taka

## Features

- Interactive on-screen numeric keypad (0-9 and CLEAR).
- Real-time calculation using a greedy denomination algorithm.
- Responsive layout supporting different screen sizes and orientations.
- Preserves input state across device rotations.

## Tech Stack

- Language: Kotlin
- UI Framework: Android XML Layouts (ConstraintLayout, GridLayout, ScrollView)
- Min SDK: 21 (Android 5.0 Lollipop)
- Target SDK: 36
- Build System: Gradle

## Project Structure

```
app/src/main/
├── AndroidManifest.xml
├── java/com/example/vangtichai/
│   └── MainActivity.kt
└── res/
    ├── layout/
    │   └── activity_main.xml
    └── values/
        ├── colors.xml
        ├── sizes.xml
        ├── strings.xml
        └── themes.xml
```

## How to Build and Run

1. Clone the repository:
   ```bash
   git clone https://github.com/tasmia-tasnim/Vangtichai.git
   ```
2. Open the project in Android Studio.
3. Build the APK or run the app on a connected Android device or emulator.
