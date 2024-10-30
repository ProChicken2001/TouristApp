package com.api.touristapp.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat

@Composable
fun RequestPermissions(
    permissions: Array<String>,
    onPermissionsGranted : () -> Unit,
    onPermissionsFailed: () -> Unit
){
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        result ->
        val isGranted = result.values.all { it }
        if(isGranted){
            onPermissionsGranted()
        }else{
            onPermissionsFailed()
        }
    }

    permissionLauncher.launch(permissions)
}

@Composable
fun CheckPermissions(
    context: Context,
    permissions: Array<String>,
){
    val allPermissionsGranted = permissions.all {
        permission ->
        ContextCompat
            .checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
    }

    if(allPermissionsGranted){
        Toast.makeText(context, "PERMISOS CONCEDIDOS", Toast.LENGTH_SHORT).show()
    }else{
        Toast.makeText(context, "PERMISOS DENEGADOS", Toast.LENGTH_SHORT).show()
    }
}
