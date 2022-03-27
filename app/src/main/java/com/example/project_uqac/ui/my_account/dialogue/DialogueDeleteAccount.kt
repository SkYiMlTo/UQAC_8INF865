package com.example.project_uqac.ui.my_account.dialogue

import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.example.project_uqac.R
import com.example.project_uqac.ui.my_account.MyAccountLogged
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DialogueDeleteAccount:DialogFragment() {

    private lateinit var mMyAccountLogged : MyAccountLogged

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)

        var builder : AlertDialog.Builder = AlertDialog.Builder(activity)

        builder.setMessage(R.string.verification_suppression_message)
        builder.setTitle(R.string.verification_suppression)

        builder.setCancelable(false)
        builder.setNegativeButton(getString(R.string.annuler), null)
        builder.setPositiveButton(getString(R.string.confirmer)) { _: DialogInterface, _: Int ->

            // TODO Delete Account here
            val user = Firebase.auth.currentUser!!
            user.delete()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "User account deleted.")
                        // Show back login page
                        mMyAccountLogged.goBackLogin()
                    }
                }
        }

        return builder.create()
    }

    fun arguments(elem : MyAccountLogged) {
        mMyAccountLogged = elem
    }
}