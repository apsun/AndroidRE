package com.crossbowffs.hackme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLicenseDialog();
            }
        });
    }

    private void onLicenseValidated(boolean valid) {
        if (!valid) {
            new AlertDialog.Builder(this)
                .setTitle(getString(R.string.license_check_title))
                .setMessage(getString(R.string.license_check_fail))
                .setPositiveButton(getString(R.string.ok), null)
                .show();
        } else {
            findViewById(R.id.imageView).setVisibility(View.VISIBLE);
            new AlertDialog.Builder(this)
                .setTitle(getString(R.string.license_check_title))
                .setMessage(getString(R.string.license_check_pass))
                .setPositiveButton(getString(R.string.ok), null)
                .show();
        }
    }

    private void onLicenseEntered(String license) {
        boolean ok = new LicenseValidator(0x13371337).validateLicense(license);
        onLicenseValidated(ok);
    }

    private void showLicenseDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.license_dialog, null);
        final EditText licenseTextBox = (EditText)dialogView.findViewById(R.id.editText);
        AlertDialog dialog = new AlertDialog.Builder(this)
            .setTitle(R.string.enter_license_title)
            .setPositiveButton(R.string.check, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onLicenseEntered(licenseTextBox.getText().toString());
                }
            })
            .setNegativeButton(R.string.cancel, null)
            .setView(dialogView)
            .create();

        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        dialog.show();
    }
}
