object Deps {
    //Base
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    //Test
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val jUnitTestExt = "androidx.test.ext:junit${Versions.jUnitTestExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"

    //Firebase
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx"
}
