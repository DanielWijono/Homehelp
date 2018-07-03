package com.example.daniel.homehelp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerificationCodeActivity extends AppCompatActivity {

    @BindView(R.id.img_verification_code)
    ImageView imgVerificationCode;
    @BindView(R.id.tv_verification_code_title)
    TextView tvVerificationCodeTitle;
    @BindView(R.id.tv_verification_code_desc)
    TextView tvVerificationCodeDesc;
    @BindView(R.id.tv_edit_number)
    TextView tvEditNumber;
    @BindView(R.id.et_code_one)
    EditText etCodeOne;
    @BindView(R.id.et_code_two)
    EditText etCodeTwo;
    @BindView(R.id.et_code_three)
    EditText etCodeThree;
    @BindView(R.id.et_code_four)
    EditText etCodeFour;
    @BindView(R.id.ll_et_codes)
    LinearLayout llEtCodes;
    @BindView(R.id.tv_send_sms_again)
    TextView tvSendSmsAgain;

    String codeOne, codeTwo, codeThree, codeFour;

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            codeOne = etCodeOne.getText().toString();
            codeTwo = etCodeTwo.getText().toString();
            codeThree = etCodeThree.getText().toString();
            codeFour = etCodeFour.getText().toString();
            validateEditText();
        }
    };
    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "");
        initTextWatcher();
        setText();
    }

    private String getColoredSpanned(String text, String color) {
        return "<font color=" + color + ">" + text + "</font>";
    }

    private void setText() {
        String customString = "Kami sudah kirimkan kode melalui SMS<br>ke nomor <b>+62 28734784</b>";
        String coloredString = getColoredSpanned("Kirim lagi", "#36C0C0");
        tvVerificationCodeDesc.setText(Html.fromHtml(customString));
        tvSendSmsAgain.setText(Html.fromHtml("Tidak terima sms ?<br>" + coloredString));
    }

    private void initTextWatcher() {
        etCodeOne.addTextChangedListener(textWatcher);
        etCodeTwo.addTextChangedListener(textWatcher);
        etCodeThree.addTextChangedListener(textWatcher);
        etCodeFour.addTextChangedListener(textWatcher);
    }

    private void validateEditText() {
        if (codeOne.length() != 0 && etCodeTwo.length() != 0 && etCodeThree.length() != 0 && etCodeFour.length() != 0) {
            startActivity(new Intent(this, DashBoardActivity.class));
            finish();
        }
        if (codeOne.length() != 0) {
            etCodeTwo.setFocusable(true);
            etCodeTwo.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        }
        if (codeTwo.length() != 0) {
            etCodeThree.setFocusable(true);
            etCodeThree.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        }
        if (codeThree.length() != 0) {
            etCodeFour.setFocusable(true);
            etCodeFour.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        }
    }
}
