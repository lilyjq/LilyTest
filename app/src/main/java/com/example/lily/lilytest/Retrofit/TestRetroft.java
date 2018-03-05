package com.example.lily.lilytest.Retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lily.lilytest.R;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ljq
 * on 2018/2/10.
 */

public class TestRetroft extends AppCompatActivity{
    private Button button;
    private TextView textView;
    private static final String key="0b57ce9d9572231678006e98b9d4c884";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_test);
        button= (Button) findViewById(R.id.button_getResponse);
        textView= (TextView) findViewById(R.id.tv_message_output);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  getResponse();
                TestRxjava();
            }
        });

    }

    private void getResponse(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://web.juhe.cn:8080/environment/")//baseurl
                .addConverterFactory(GsonConverterFactory.create())//添加数据转换器用来处理 result
                .build();
        TestService service=retrofit.create(TestService.class);
        Call<AirResponse> responseCall=service.getAirResponse(key);

       // AirResponse response=responseCall.execute().body();//同步请求，不能在主线程中运行
       //异步请求
        responseCall.enqueue(new Callback<AirResponse>() {
            @Override
            public void onResponse(Call<AirResponse> call, Response<AirResponse> response) {
                  if(response!=null){
                      if(response.body().getResult()!=null){

                              textView.setText(""+response.body().getResult().size());

                      }
                  }
            }

            @Override
            public void onFailure(Call<AirResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }



    private void TestRxjava(){

        //被观察者
        Observable<Integer> observable=Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
           //ObservableEmitter事件发射器
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);//发射事件
            }
        });


        //观察者
        Observer<Integer> observer=new Observer<Integer>() {
            Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                //这里开始采用subscribe 链接
                Log.e("onSubscribe",""+d.toString());
               // disposable=d;
            }

            @Override
            public void onNext(Integer integer) {
                //处理onnext事件
                Log.e("onNext",""+integer);

            }

            @Override
            public void onError(Throwable e) {
                //处理错误的事件
                Log.e("onError",""+e.getMessage());
                //disposable.dispose();
            }

            @Override
            public void onComplete() {
                //完成事做出响应
                Log.e("onComplete","");
            }
        };
        //订阅
        //observable.subscribe(observer);
        observable.subscribeOn(Schedulers.newThread())//指定被观察者线程 即 发送事件的线程
                .observeOn(AndroidSchedulers.mainThread()) //指定观察者线程 即 处理事件时使用的线程
                .subscribe(observer);

    }

    private void TestRxjavaSwitchThread(){

    }
}
