package com.vkhodonovych.sampledagger2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.vkhodonovych.sampledagger2.R;
import com.vkhodonovych.sampledagger2.api.WikiService;
import com.vkhodonovych.sampledagger2.api.model.WikiResponse;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {
    private static final String TAG = "MainActivity";

    @BindView(R.id.textView) TextView textView;

    @Inject WikiService wikiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        textView.setMovementMethod(new ScrollingMovementMethod());
        //FIXME tmp solution. Move this logic from here
        wikiService.getWiki().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<WikiResponse>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(Response<WikiResponse> wikiResponseResponse) {
                        if (wikiResponseResponse.isSuccessful()) {
                            WikiResponse wikiResponse = wikiResponseResponse.body();
                            textView.setText(wikiResponse.getQuery().getPages().getPage().extract);
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.e(TAG, "onError: ", throwable);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
