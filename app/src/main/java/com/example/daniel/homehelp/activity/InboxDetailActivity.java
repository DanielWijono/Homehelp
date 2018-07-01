package com.example.daniel.homehelp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daniel.homehelp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InboxDetailActivity extends AppCompatActivity {

    @BindView(R.id.ll_chat_from_worker)
    LinearLayout llChatFromWorker;
    @BindView(R.id.ll_chat_from_typing)
    LinearLayout llChatFromTyping;
    @BindView(R.id.img_send_chat)
    ImageView imgSendChat;
    @BindView(R.id.ll_send_chat)
    LinearLayout llSendChat;
    @BindView(R.id.et_chat_type)
    EditText etChatType;

    String chatType;

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            chatType = etChatType.getText().toString();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox_detail);
        ButterKnife.bind(this);
        etChatType.addTextChangedListener(textWatcher);
    }

    @OnClick(R.id.img_send_chat)
    public void onViewClicked() {
        if (chatType.length() > 0) {
            View view = getLayoutInflater().inflate(R.layout.item_chat_from_typing, null);
            TextView textType = view.findViewById(R.id.tv_from_typing);
            TextView textTime = view.findViewById(R.id.tv_time_typing);

            textType.setText(chatType);

            llChatFromTyping.addView(view);
            etChatType.setText("");
        }
    }
}
