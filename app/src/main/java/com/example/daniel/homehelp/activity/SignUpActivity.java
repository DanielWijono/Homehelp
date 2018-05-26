package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.daniel.homehelp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone_number)
    EditText etPhoneNumber;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.tv_sign_up)
    TextView tvSignUp;

    String name, phoneNumber, email;

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            name = etName.getText().toString();
            phoneNumber = etPhoneNumber.getText().toString();
            email = etEmail.getText().toString();
            validateAlphaText();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        etName.addTextChangedListener(textWatcher);
        etPhoneNumber.addTextChangedListener(textWatcher);
        etEmail.addTextChangedListener(textWatcher);
    }

    private void validateAlphaText() {
        if (name.length() > 0) {
            etName.setAlpha(1);
        }
        if (phoneNumber.length() > 0) {
            etPhoneNumber.setAlpha(1);
        }
        if (email.length() > 0) {
            etEmail.setAlpha(1);
        }
        if (name.startsWith(" ")) {
            etName.setText("");
        }
        if (phoneNumber.startsWith(" ")) {
            etPhoneNumber.setText("");
        }
        if (email.startsWith(" ")) {
            etEmail.setText("");
        }
    }

    @OnClick(R.id.tv_sign_up)
    public void onViewClicked() {
        startActivity(new Intent(this, DashBoardActivity.class));
        finish();
    }
}
