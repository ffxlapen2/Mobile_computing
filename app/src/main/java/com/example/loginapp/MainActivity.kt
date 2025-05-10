package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogin1.setOnClickListener {
            val email = binding.Email.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.Email.error = "Input Email"
                binding.Email.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.Email.error = "Invalid Email"
                binding.Email.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6) {
                binding.etPassword.error = "Password harus lebih dari 6 karakter"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            loginUser(email, password)
        }

        binding.LupaPW.setOnClickListener {
            startActivity(Intent(this, ForgotPW_App::class.java))
        }

        binding.Mendaftar.setOnClickListener {
            startActivity(Intent(this, RegisterApp::class.java))
        }
    }

    private fun loginUser(email: String, password: String) {
        // Tambahkan logika login Firebase di sini
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, HalamanDashboard::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // tampilkan error (misalnya via Toast)
                }
            }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            val intent = Intent(this, HalamanDashboard::class.java)
            startActivity(intent)
        }
    }
}
