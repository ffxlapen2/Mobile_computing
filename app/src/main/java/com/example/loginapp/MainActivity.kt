package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var isPasswordVisible = false // 🔧 DITAMBAHKAN

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up padding to avoid system bars
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Firebase Auth initialization
        firebaseAuth = FirebaseAuth.getInstance()

        // Force logout when app is opened
        firebaseAuth.signOut() // 🔧 DITAMBAHKAN: Paksa logout saat aplikasi dibuka

        // Implementasi untuk toggle password visibility saat icon diklik
        binding.etPassword.setOnTouchListener { v, event ->
            val drawableEnd = 2
            if (event.action == MotionEvent.ACTION_UP &&
                event.rawX >= (binding.etPassword.right - binding.etPassword.compoundDrawables[drawableEnd].bounds.width())
            ) {
                v.performClick() // 👈 Penting: tambahkan ini untuk menghindari warning

                isPasswordVisible = !isPasswordVisible
                if (isPasswordVisible) {
                    binding.etPassword.inputType = android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    binding.etPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility_24dp, 0)
                } else {
                    binding.etPassword.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
                    binding.etPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility_off_24dp, 0)
                }
                binding.etPassword.setSelection(binding.etPassword.text.length)
                true
            } else {
                false
            }
        }

        // Login button click listener
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

        // Forget password button
        binding.LupaPW.setOnClickListener {
            startActivity(Intent(this, ForgotPW_App::class.java))
        }

        // Register button
        binding.Mendaftar.setOnClickListener {
            startActivity(Intent(this, RegisterApp::class.java))
        }
    }

    // Method untuk login user menggunakan Firebase
    private fun loginUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, HalamanDashboard::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Login gagal: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    // Mengecek apakah user sudah login atau belum
    override fun onStart() {
        super.onStart()
        // 🔧 DIHAPUS: auto-login ke dashboard di sini sebelumnya, tapi sekarang di-nonaktifkan agar user wajib login dulu
    }
}
