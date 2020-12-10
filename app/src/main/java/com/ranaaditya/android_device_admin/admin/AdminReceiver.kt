package com.ranaaditya.android_device_admin.admin

import android.annotation.SuppressLint
import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent
import android.os.UserHandle
import android.widget.Toast
import com.ranaaditya.android_device_admin.R

class AdminReceiver : DeviceAdminReceiver() {

    @SuppressLint("StringFormatInvalid")
    private fun showToast(context: Context, msg: String) {
        context.getString(R.string.admin_receiver_status, msg).let { status ->
            Toast.makeText(context, status, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onEnabled(context: Context, intent: Intent) =
        showToast(context, context.getString(R.string.admin_receiver_status_enabled))

    override fun onDisableRequested(context: Context, intent: Intent): CharSequence =
        context.getString(R.string.admin_receiver_status_disable_warning)

    override fun onDisabled(context: Context, intent: Intent) =
        showToast(context, context.getString(R.string.admin_receiver_status_disabled))

    override fun onPasswordChanged(context: Context, intent: Intent, userHandle: UserHandle) =
        showToast(context, context.getString(R.string.admin_receiver_status_pw_changed))

}