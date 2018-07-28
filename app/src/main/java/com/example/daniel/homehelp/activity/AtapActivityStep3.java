package com.example.daniel.homehelp.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;
import com.example.daniel.homehelp.adapter.AtapKerusakanAdapter;
import com.shuhart.stepview.StepView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AtapActivityStep3 extends AppCompatActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.step_view)
    StepView stepView;
    @BindView(R.id.ll_toolbar_atap)
    LinearLayout llToolbarAtap;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar_layout_atap)
    AppBarLayout appBarLayoutAtap;
    @BindView(R.id.img_atap)
    ImageView imgAtap;
    @BindView(R.id.service_atap_recycler_view)
    RecyclerView serviceAtapRecyclerView;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    @BindView(R.id.tv_substract)
    TextView tvSubstract;
    @BindView(R.id.tv_tukang_sum)
    TextView tvTukangSum;
    @BindView(R.id.tv_plus)
    TextView tvPlus;
    @BindView(R.id.next_button)
    TextView nextButton;
    @BindView(R.id.ll_footer)
    LinearLayout llFooter;
    @BindView(R.id.et_problem_desc)
    EditText etProblemDesc;
    @BindView(R.id.img_toolbar)
    ImageView imgToolbar;
    @BindView(R.id.ll_notes)
    LinearLayout llNotes;
    @BindView(R.id.image_capture_one)
    ImageView imageCaptureOne;
    @BindView(R.id.image_capture_two)
    ImageView imageCaptureTwo;
    @BindView(R.id.image_capture_three)
    ImageView imageCaptureThree;

    String workType, notes, date, problemDesc, location, time;
    AtapKerusakanAdapter atapKerusakanAdapter;
    List<String> listKerusakanFromAdapter = new ArrayList<>();

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            problemDesc = etProblemDesc.getText().toString();
        }
    };

    int REQUEST_CAMERA = 123;
    int REQUEST_CAMERA_TWO = 345;
    int REQUEST_CAMERA_THREE = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atap_step3);
        ButterKnife.bind(this);
        initRecyclerView();
        Utils.setupAppToolbarForActivity(this, toolbar, "Pemesanan");
        getBundle();
        etProblemDesc.addTextChangedListener(textWatcher);
        imgToolbar.setImageResource(R.drawable.ic_step_three);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            workType = bundle.getString("WORK_TYPE");
            notes = bundle.getString("NOTES");
            date = bundle.getString("DATE");
            location = bundle.getString("LOCATION");
            time = bundle.getString("TIME");
        }
    }

    private void initRecyclerView() {
        serviceAtapRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        atapKerusakanAdapter = new AtapKerusakanAdapter(this);
        serviceAtapRecyclerView.setAdapter(atapKerusakanAdapter);
    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void cameraIntentTwo() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA_TWO);
    }

    private void cameraIntentThree() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA_THREE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {
                onCaptureImageResult(data);
            } else if (requestCode == REQUEST_CAMERA_TWO) {
                onCaptureImageResultTwo(data);
            } else if (requestCode == REQUEST_CAMERA_THREE) {
                onCaptureImageResultThree(data);
            }
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageCaptureOne.setImageBitmap(thumbnail);
    }

    private void onCaptureImageResultTwo(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageCaptureTwo.setImageBitmap(thumbnail);
    }

    private void onCaptureImageResultThree(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageCaptureThree.setImageBitmap(thumbnail);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            }
        }
    }

    @OnClick({R.id.tv_substract, R.id.tv_plus, R.id.next_button, R.id.image_capture_one, R.id.image_capture_two, R.id.image_capture_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_substract:
                if (tvTukangSum.getText().toString().equals("2")) {
                    tvTukangSum.setText("1");
                }
                break;
            case R.id.tv_plus:
                if (tvTukangSum.getText().toString().equals("1")) {
                    tvTukangSum.setText("2");
                }
                break;
            case R.id.next_button:
                listKerusakanFromAdapter = AtapKerusakanAdapter.listKerusakan;

                Intent intent = new Intent(this, AtapActivityStep4.class);
                intent.putExtra("WORK_TYPE", workType);
                intent.putExtra("NOTES", notes);
                intent.putExtra("DATE", date);
                intent.putExtra("LOCATION", location);
                intent.putExtra("TOTAL_WORKER", tvTukangSum.getText().toString());
                intent.putExtra("PROBLEM_DESC", problemDesc);
                intent.putExtra("TIME", time);
                intent.putStringArrayListExtra("LIST_KERUSAKAN", (ArrayList<String>) listKerusakanFromAdapter);
                startActivity(intent);
                break;
            case R.id.image_capture_one:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
                } else {
                    cameraIntent();
                }
                break;
            case R.id.image_capture_two:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
                } else {
                    cameraIntentTwo();
                }
                break;
            case R.id.image_capture_three:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
                } else {
                    cameraIntentThree();
                }
                break;
        }
    }
}
