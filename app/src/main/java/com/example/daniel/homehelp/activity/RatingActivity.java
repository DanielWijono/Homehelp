package com.example.daniel.homehelp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RatingActivity extends AppCompatActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_atap)
    ImageView imgAtap;
    @BindView(R.id.rating_bar)
    RatingBar ratingBar;
    @BindView(R.id.ll_rating)
    LinearLayout llRating;
    @BindView(R.id.ll_order_summary)
    LinearLayout llOrderSummary;
    @BindView(R.id.ll_payment_method)
    LinearLayout llPaymentMethod;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    @BindView(R.id.ll_kerusakan_desc)
    LinearLayout llKerusakanDesc;
    @BindView(R.id.tv_submit_rating)
    TextView tvSubmitRating;
    @BindView(R.id.ll_comment_rating)
    LinearLayout llCommentRating;
    @BindView(R.id.tv_give_your_rating)
    TextView tvGiveYourRating;
    @BindView(R.id.tv_give_your_comment)
    TextView tvGiveYourComment;
    @BindView(R.id.tv_rincian)
    TextView tvRincian;
    @BindView(R.id.promo_desc)
    TextView promoDesc;
    @BindView(R.id.img_rating_one)
    ImageView imgRatingOne;
    @BindView(R.id.img_rating_two)
    ImageView imgRatingTwo;
    @BindView(R.id.img_rating_three)
    ImageView imgRatingThree;
    @BindView(R.id.img_rating_four)
    ImageView imgRatingFour;
    @BindView(R.id.img_rating_five)
    ImageView imgRatingFive;
    @BindView(R.id.tv_rating_desc)
    TextView tvRatingDesc;

    List<String> listKerusakanFromStep3;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ButterKnife.bind(this);
        getBundle();
        setViewBagianKerusakan();
        promoDesc.setText("Untuk pemesanan berikutnya,\ngunakan kode promo: HOMEASIK");
        imgRatingOne.setAlpha(0.2f);
        imgRatingTwo.setAlpha(0.2f);
        imgRatingThree.setAlpha(0.2f);
        imgRatingFour.setAlpha(0.2f);
        imgRatingFive.setAlpha(0.2f);
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            listKerusakanFromStep3 = bundle.getStringArrayList("LIST_KERUSAKAN");
            System.out.println("list kerusakan rating : " + listKerusakanFromStep3);
        }
    }

    private void setViewBagianKerusakan() {
        for (int i = 0; i < listKerusakanFromStep3.size(); i++) {
            View view = getLayoutInflater().inflate(R.layout.item_kerusakan_step4, null);
            TextView tvItemKerusakan = view.findViewById(R.id.tv_item_kerusakan);
            ImageView imgItemKerusakan = view.findViewById(R.id.image_item_kerusakan);

            tvItemKerusakan.setText(listKerusakanFromStep3.get(i));
            imgItemKerusakan.setImageResource(R.drawable.ic_checked);
            llKerusakanDesc.addView(view);
        }
    }

    @OnClick({R.id.img_rating_one, R.id.img_rating_two, R.id.img_rating_three, R.id.img_rating_four, R.id.img_rating_five, R.id.tv_submit_rating})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_rating_one:
                imgRatingOne.setAlpha(1f);
                imgRatingTwo.setAlpha(0.2f);
                imgRatingThree.setAlpha(0.2f);
                imgRatingFour.setAlpha(0.2f);
                imgRatingFive.setAlpha(0.2f);
                tvRatingDesc.setText("Mengecewakan");
                break;
            case R.id.img_rating_two:
                imgRatingOne.setAlpha(0.2f);
                imgRatingTwo.setAlpha(1f);
                imgRatingThree.setAlpha(0.2f);
                imgRatingFour.setAlpha(0.2f);
                imgRatingFive.setAlpha(0.2f);
                tvRatingDesc.setText("Netral");
                break;
            case R.id.img_rating_three:
                imgRatingOne.setAlpha(0.2f);
                imgRatingTwo.setAlpha(0.2f);
                imgRatingThree.setAlpha(1f);
                imgRatingFour.setAlpha(0.2f);
                imgRatingFive.setAlpha(0.2f);
                tvRatingDesc.setText("Baik");
                break;
            case R.id.img_rating_four:
                imgRatingOne.setAlpha(0.2f);
                imgRatingTwo.setAlpha(0.2f);
                imgRatingThree.setAlpha(0.2f);
                imgRatingFour.setAlpha(1f);
                imgRatingFive.setAlpha(0.2f);
                tvRatingDesc.setText("Puas");
                break;
            case R.id.img_rating_five:
                imgRatingOne.setAlpha(0.2f);
                imgRatingTwo.setAlpha(0.2f);
                imgRatingThree.setAlpha(0.2f);
                imgRatingFour.setAlpha(0.2f);
                imgRatingFive.setAlpha(1f);
                tvRatingDesc.setText("Sangat Puas");
                break;
            case R.id.tv_submit_rating:
                if (i == 0) {
                    tvGiveYourRating.setVisibility(View.GONE);
                    ratingBar.setVisibility(View.GONE);
                    llCommentRating.setVisibility(View.VISIBLE);
                    tvGiveYourComment.setVisibility(View.VISIBLE);
                    tvRatingDesc.setVisibility(View.GONE);
                    i++;
                } else {
                    Utils.intentWithClearTask(this, DashBoardActivity.class);
                }
                break;
        }
    }
}
