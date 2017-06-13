package com.xxh.mobilehelper.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpFragment;
import com.xxh.mobilehelper.presenter.GamePresenter;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**

 */
public class GamingFragment extends BaseMvpFragment<GamePresenter> {


    @BindView(R.id.test_empty)
    TextView mTestEmpty;

    public static GamingFragment newInstance() {
        GamingFragment fragment = new GamingFragment();
        return fragment;
    }


    @Override
    public GamePresenter createPresenter() {
        return new GamePresenter();
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.test_empty)
    public void  clickOnView(View view){
        Observable.empty().subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                Log.e("TAG", "next");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e("TAG", "error");
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.e("TAG", "complete");
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gaming;
    }


}
