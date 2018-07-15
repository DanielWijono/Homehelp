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
import de.hdodenhof.circleimageview.CircleImageView;

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
    @BindView(R.id.img_worker)
    CircleImageView imgWorker;
    @BindView(R.id.tv_worker_name)
    TextView tvWorkerName;
    @BindView(R.id.tv_date_time)
    TextView tvDateTime;
    @BindView(R.id.tv_work_type)
    TextView tvWorkType;

    List<String> listKerusakanFromStep3;
    String workType, notes, date, listKerusakan, totalWorker, problemDesc, location, time, workerClicked, workerName;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ButterKnife.bind(this);
        getBundle();
        setViewBagianKerusakan();
        promoDesc.setText("Untuk pemesanan berikutnya,\ngunakan kode promo: HOMEASIK");
        setViewRatingPage();
    }

    private void setViewRatingPage() {
        imgRatingOne.setAlpha(0.2f);
        imgRatingTwo.setAlpha(0.2f);
        imgRatingThree.setAlpha(0.2f);
        imgRatingFour.setAlpha(0.2f);
        imgRatingFive.setAlpha(0.2f);

        if (workerName.contains("jeff")) {
            imgWorker.setImageResource(R.drawable.ic_worker_face_one);
        } else {
            imgWorker.setImageResource(R.drawable.ic_worker_face_two);
        }

        tvWorkType.setText("Tipe : " + workType);
        tvWorkerName.setText(workerName);
        tvDateTime.setText(date + " Jam " + time);
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            workType = bundle.getString("WORK_TYPE");
            notes = bundle.getString("NOTES");
            date = bundle.getString("DATE");
            listKerusakan = bundle.getString("LIST_KERUSAKAN");
            totalWorker = bundle.getString("TOTAL_WORKER");
            location = bundle.getString("LOCATION");
            problemDesc = bundle.getString("PROBLEM_DESC");
            time = bundle.getString("TIME");
            workerClicked = bundle.getString("WORKER_CLICKED");
            workerName = bundle.getString("WORKER_NAME");
            listKerusakanFromStep3 = bundle.getStringArrayList("LIST_KERUSAKAN");
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
