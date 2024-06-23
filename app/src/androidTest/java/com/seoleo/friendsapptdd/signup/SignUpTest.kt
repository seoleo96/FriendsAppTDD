package com.seoleo.friendsapptdd.signup

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.seoleo.friendsapptdd.MainActivity
import org.junit.Rule
import org.junit.Test


class SignUpTest {

    @get:Rule
    val signUpTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun performSignUp() {
        launchSignUpScreen(signUpTestRule) {
            typeEmail("email@friends.app")
            typePassword("password")
            submit()
        } verify {
            timelineScreenIsPresent()
        }
    }
}