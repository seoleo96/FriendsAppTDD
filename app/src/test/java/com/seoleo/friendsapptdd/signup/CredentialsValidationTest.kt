package com.seoleo.friendsapptdd.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantTaskExecutorExtension::class)
class CredentialsValidationTest {

    @Test
    fun invalidEmail() {
        val viewModel = SignUpViewModel()
        println("state - ${viewModel.signUpState.value}")
        viewModel.createAccount("email", "password", "about me")
        println("state - ${viewModel.signUpState.value}")
        assertEquals(SignUpState.BadEmail, viewModel.signUpState.value)
    }


    class SignUpViewModel {
        private val _signUpState = MutableLiveData<SignUpState>()
        val signUpState: LiveData<SignUpState> = _signUpState
        fun createAccount(email: String, password: String, about: String) {
            _signUpState.value = SignUpState.BadEmail
        }

    }

    sealed class SignUpState {

        object BadEmail : SignUpState()
        object BadPassword : SignUpState()
    }
}