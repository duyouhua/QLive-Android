package cn.nodemedia.qlive.view;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.nodemedia.NodePlayerView;
import cn.nodemedia.qlive.R;
import cn.nodemedia.qlive.contract.PlayContract;
import xyz.tanwb.airship.utils.StatusBarUtils;
import xyz.tanwb.airship.view.BaseActivity;

public class PlayActivity extends BaseActivity<PlayContract.Presenter> implements PlayContract.View, View.OnClickListener {

    private NodePlayerView playSurface;
    private ImageView playBack;

    @Override
    public int getLayoutId() {
        return R.layout.activity_play;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        StatusBarUtils.setColorToTransparent(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        assignViews();
    }

    /**
     * 实例化视图控件
     */
    private void assignViews() {
        playSurface = getView(R.id.play_surface);
        playBack = getView(R.id.play_back);
        playBack.setOnClickListener(this);
    }

    @Override
    public void initPresenter() {
        mPresenter.initPresenter(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play_back:
                exit();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void exit() {
        finish();
    }

    @Override
    public NodePlayerView getNodePlayerView() {
        return playSurface;
    }

}
