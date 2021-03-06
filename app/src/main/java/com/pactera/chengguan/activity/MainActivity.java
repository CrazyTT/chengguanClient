package com.pactera.chengguan.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pactera.chengguan.R;
import com.pactera.chengguan.base.BaseActivity;
import com.pactera.chengguan.fragment.MaintainManageFragment;
import com.pactera.chengguan.fragment.TabThreeFragment;
import com.pactera.chengguan.fragment.TabOneFragment;
import com.pactera.chengguan.fragment.TabFourFragment;
import com.pactera.chengguan.fragment.TabTwoFragment;
import com.pactera.chengguan.view.DoubleClickExitHelper;

/**
 * Created by lijun on 2015/12/2.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private DoubleClickExitHelper mDoubleClickExit;

    /**
     * 用于案件的Fragment
     */
    private MaintainManageFragment tabOneFragment;

    /**
     * 用于广告的Fragment
     */
    private TabThreeFragment tabThreeFragment;

    /**
     * 用于通知的Fragment
     */
    private TabTwoFragment tabTwoFragment;
    /**
     * 更多Fragment
     */
    private TabFourFragment tabFourFragment;


    /**
     * 在Tab布局上显示案件图片的控件
     */
    private ImageView caseImage;

    /**
     * 在Tab布局上显示广告图片的控件
     */
    private ImageView advertiseImage;

    /**
     * 在Tab布局上显示通知图片的控件
     */
    private ImageView noticeImage;
    /**
     * 在Tab布局上显示更多的控件
     */
    private ImageView moreImage;

    /**
     * 在Tab布局上显示案件的控件
     */
    private TextView caseText;

    /**
     * 在Tab布局上显示广告的控件
     */
    private TextView advertiseText;

    /**
     * 在Tab布局上显示通知的控件
     */
    private TextView noticeText;
    /**
     * 在Tab布局上显示更多的控件
     */
    private TextView moreText;


    /**
     * 案件界面布局
     */
    private View caseLayout;

    /**
     * 广告界面布局
     */
    private View advertiseLayout;

    /**
     * 通知界面布局
     */
    private View noticeLayout;
    /**
     * 更多界面布局
     */
    private View moreLayout;

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化布局元素
        initViews();

        fragmentManager = getSupportFragmentManager();

        // 第一次启动时选中第0个tab
        setTabSelection(0);

    }


    /**
     * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
     */

    private void initViews() {
        mDoubleClickExit = new DoubleClickExitHelper(this);
        caseLayout = findViewById(R.id.case_layout);
        advertiseLayout = findViewById(R.id.advertise_layout);
        noticeLayout = findViewById(R.id.notice_layout);
        moreLayout = findViewById(R.id.more_layout);
        caseImage = (ImageView) findViewById(R.id.case_image);
        advertiseImage = (ImageView) findViewById(R.id.advertise_image);
        noticeImage = (ImageView) findViewById(R.id.notice_image);
        moreImage = (ImageView) findViewById(R.id.more_image);
        caseText = (TextView) findViewById(R.id.case_text);
        advertiseText = (TextView) findViewById(R.id.advertise_text);
        noticeText = (TextView) findViewById(R.id.notice_text);
        moreText = (TextView) findViewById(R.id.more_text);
        caseLayout.setOnClickListener(this);
        advertiseLayout.setOnClickListener(this);
        noticeLayout.setOnClickListener(this);
        moreLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.case_layout:
                // 选中第1个tab
                setTabSelection(0);
                break;
            case R.id.notice_layout:
                // 选中第2个tab
                setTabSelection(1);
                break;
            case R.id.advertise_layout:
                // 选中第3个tab
                setTabSelection(2);
                break;
            case R.id.more_layout:
                //选中第4个tab
                setTabSelection(3);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index 每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                caseImage.setImageResource(R.mipmap.ico_case_on);
                caseText.setTextColor(getResources().getColor(R.color.color21b6ec));
                if (tabOneFragment == null) {
                    // TabOneFragment，则创建一个并添加到界面上
                    tabOneFragment = new MaintainManageFragment();
                    transaction.add(R.id.content, tabOneFragment);
                } else {
                    // 如果CaseFragment不为空，则直接将它显示出来
                    transaction.show(tabOneFragment);
                }
                break;
            case 1:
                // 当点击了设置tab时，改变控件的图片和文字颜色
                noticeImage.setImageResource(R.mipmap.ico_notice_on);
                noticeText.setTextColor(getResources().getColor(R.color.color21b6ec));
                if (tabTwoFragment == null) {
                    // 如果NoticeFragment为空，则创建一个并添加到界面上
                    tabTwoFragment = new TabTwoFragment();
                    transaction.add(R.id.content, tabTwoFragment);
                } else {
                    // 如果NoticeFragment不为空，则直接将它显示出来
                    transaction.show(tabTwoFragment);
                }
                break;
            case 2:

                // 当点击了动态tab时，改变控件的图片和文字颜色
                advertiseImage.setImageResource(R.mipmap.ico_advertise_on);
                advertiseText.setTextColor(getResources().getColor(R.color.color21b6ec));
                if (tabThreeFragment == null) {
                    // TabThreeFragment，则创建一个并添加到界面上
                    tabThreeFragment = new TabThreeFragment();
                    transaction.add(R.id.content, tabThreeFragment);
                } else {
                    // TabThreeFragment，则直接将它显示出来
                    transaction.show(tabThreeFragment);
                }
                break;

            case 3:
                // 当点击了设置tab时，改变控件的图片和文字颜色
                moreImage.setImageResource(R.mipmap.ico_more_on);
                moreText.setTextColor(getResources().getColor(R.color.color21b6ec));
                if (tabFourFragment == null) {
                    // PersonalFragment，则创建一个并添加到界面上
                    tabFourFragment = new TabFourFragment();
                    transaction.add(R.id.content, tabFourFragment);
                } else {
                    // PersonalFragment，则直接将它显示出来
                    transaction.show(tabFourFragment);
                }
                break;
        }

        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        caseImage.setImageResource(R.mipmap.ico_case);
        caseText.setTextColor(Color.parseColor("#82858b"));
        advertiseImage.setImageResource(R.mipmap.ico_advertise);
        advertiseText.setTextColor(Color.parseColor("#82858b"));
        noticeImage.setImageResource(R.mipmap.ico_notice);
        noticeText.setTextColor(Color.parseColor("#82858b"));
        moreImage.setImageResource(R.mipmap.ico_more);
        moreText.setTextColor(Color.parseColor("#82858b"));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (tabOneFragment != null) {
            transaction.hide(tabOneFragment);
        }
        if (tabThreeFragment != null) {
            transaction.hide(tabThreeFragment);
        }
        if (tabTwoFragment != null) {
            transaction.hide(tabTwoFragment);
        }
        if (tabFourFragment != null) {
            transaction.hide(tabFourFragment);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

    }

    /**
     * 监听返回--是否退出程序
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 是否退出应用
            return mDoubleClickExit.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }
}
