package com.adityagupta.gdsc_nie.presentation.main.home.bug

import android.content.ClipDescription
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.adityagupta.gdsc_nie.R
import com.adityagupta.gdsc_nie.databinding.ActivityBugReportBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class BugReportActivity : AppCompatActivity() {

    lateinit var binding: ActivityBugReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_bug_report)

        binding.brSubmitBug.setOnClickListener {
            launchEmailIntent()
        }

    }

    private fun launchEmailIntent() {

        val name = binding.brNameEditText.editText?.text
        val des = binding.brBugDesEditText.editText?.text

        if(name.isNullOrEmpty()){
            MaterialAlertDialogBuilder(this,
                R.style.ThemeOverlay_MaterialComponents_Dialog_Alert)
                .setMessage("Hey! We need your name!!\n")
                .setNegativeButton("Try Again") { _, _ ->
                }
                .show()
        }else if(des.isNullOrEmpty()){
            MaterialAlertDialogBuilder(this,
                R.style.ThemeOverlay_MaterialComponents_Dialog_Alert)
                .setMessage("Umm\n" +
                        "The Description Field can't be empty!!!\n" +
                        ":|")
                .setNegativeButton("Try Again") { _, _ ->
                    // Respond to negative button press
                }
                .show()
        }else{
            val intent = Intent(Intent.ACTION_VIEW)
            val data: Uri = Uri.parse(
                "mailto:"
                        + "dsc@nioe.ac.in"
                        + "?subject=" + name + "&body=" + des
            )
            intent.data = data
            startActivity(intent)
        }
    }
}