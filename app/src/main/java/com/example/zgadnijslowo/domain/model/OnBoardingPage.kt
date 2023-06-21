package com.example.zgadnijslowo.domain.model

import androidx.annotation.DrawableRes
import com.example.zgadnijslowo.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val description: String
) {
    object First: OnBoardingPage(
        image = R.drawable.onboarding_first,
        description = "Zgadnij słowo jest niezwykle prostą grą, polegającą na zgadywaniu słów. Kwadraty, które to uzupełnia się literami, zmieniają kolory — nie bez powodu:"
    )

    object Second: OnBoardingPage(
        image = R.drawable.onboarding_second,
        description = "Szary oznacza, że danej litery nie ma w słowie."
    )

    object Third: OnBoardingPage(
        image = R.drawable.onboarding_third,
        description = "Zielony to nic innego, jak strzał w dziesiątkę – litera jest tam, gdzie trzeba."
    )

    object Fourth: OnBoardingPage(
        image = R.drawable.onboarding_fourth,
        description = "Źółty sygnalizuje, że litera znajduje się w słowie, ale w innym miejscu,"
    )
}
