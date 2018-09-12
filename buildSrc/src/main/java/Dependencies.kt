object ApplicationId {
    val application_id = "io.throwable.eventschedule"
}
object Urls{
    val BASE_URL = ""
}

object Releases {
    val version_code = 1
    val version = "1.0"
}

object Modules {
    val domain = ":domain"
    val data = ":data"
}

object Versions {
    const val gradle = "3.1.3"

    const val versions = "0.17.0"

    const val compile_sdk = 28
    const val min_sdk = 23
    const val target_sdk = 28

    const val inject = "1"

    const val support = "28.0.0-beta01"
    const val maps = "15.0.1"
    const val constrainst_layout = "2.0.0-alpha2"

    const val kotlin = "1.2.51"
    const val anko = "0.10.4"
    const val timber = "4.7.0"
    const val rxandroid = "2.0.2"
    const val rxkotlin = "2.2.0"
    const val retrofit = "2.4.0"
    const val logging_interceptor = "3.10.0"
    const val dagger = "2.15"
    const val glide = "4.6.1"
    const val rxpaper = "1.2.0"
    const val moshi = "1.4.0"
    const val lifecycle = "1.1.1"
    const val room = "1.1.1"
    const val rxroom = "1.0.0"
    const val circle_image = "2.2.0"

    const val junit = "4.12"
    const val assertj_core = "3.9.1"
    const val mockito_kotlin = "1.5.0"
    const val runner = "1.0.2"
    const val espresso = "3.0.2"
    const val crashlytics = "2.9.3"
    const val firebase_core = "12.0.0"
    const val firebase_firestore = "17.1.0"
    const val flexbox = "1.0.0"
}

object Libraries {
    val inject = "javax.inject:javax.inject:${Versions.inject}"

    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val anko_commons = "org.jetbrains.anko:anko-commons:${Versions.anko}"

    val maps = "com.google.android.gms:play-services-maps:${Versions.maps}"

    val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"

    val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"

    val circleImage = "de.hdodenhof:circleimageview:${Versions.circle_image}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"

    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    val lifecycle_extensions = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
    val lifecycle_compiler = "android.arch.lifecycle:compiler:${Versions.lifecycle}"

    val room_runtime = "android.arch.persistence.room:runtime:${Versions.room}"
    val room_complier = "android.arch.persistence.room:compiler:${Versions.room}"
    val rxroom = "android.arch.persistence.room:rxjava2:${Versions.rxroom}"

    val firebase_crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"
    val firebase_core = "com.google.firebase:firebase-core:${Versions.firebase_core}"
    val firebase_firestore = "com.google.firebase:firebase-firestore:${Versions.firebase_firestore}"

    val flexbox = "com.google.android:flexbox:${Versions.flexbox}"

}

object SupportLibraries {
    val appcompat_v7 = "com.android.support:appcompat-v7:${Versions.support}"
    val design = "com.android.support:design:${Versions.support}"
    val cardview_v7 = "com.android.support:cardview-v7:${Versions.support}"
    val recyclerview_v7 = "com.android.support:recyclerview-v7:${Versions.support}"
    val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constrainst_layout}"
    val vectorDrawables = "com.android.support:support-vector-drawable:${Versions.support}"
}

object TestLibraries {
    val junit = "junit:junit:${Versions.junit}"
    val assertj_core = "org.assertj:assertj-core:${Versions.assertj_core}"
    val runner = "com.android.support.test:runner:${Versions.runner}"
    val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    val mockito_kotlin = "com.nhaarman:mockito-kotlin:${Versions.mockito_kotlin}"
    val lifecycle_testing = "android.arch.core:core-testing:${Versions.lifecycle}"
    val room ="android.arch.persistence.room:testing:${Versions.room}"
}

object Config {
    val testRunner = "android.support.test.runner.AndroidJUnitRunner"
}