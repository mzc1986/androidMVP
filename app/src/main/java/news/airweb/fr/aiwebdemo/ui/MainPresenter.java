package news.airweb.fr.aiwebdemo.ui;


import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import news.airweb.fr.aiwebdemo.models.Content;
import news.airweb.fr.aiwebdemo.network.NetworkClient;
import news.airweb.fr.aiwebdemo.network.NetworkInterface;


public class MainPresenter implements MainPresenterInterface {

    MainViewInterface mvi;
    private String TAG = "MainPresenter";

    public MainPresenter(MainViewInterface mvi) {
        this.mvi = mvi;
    }

    @Override
    public void getNews() {
        mvi.showProgressBar();
        getObservable().subscribeWith(getObserver());
    }

    public Observable<Content> getObservable(){
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                            .getNews()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<Content> getObserver(){
        return new DisposableObserver<Content>() {

            @Override
            public void onNext(@NonNull Content newsResponse) {
                Log.d(TAG,"OnNext"+newsResponse.getNews());
                mvi.displayNews(newsResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                mvi.displayError("Error fetching News Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
                mvi.hideProgressBar();
            }
        };
    }
}
