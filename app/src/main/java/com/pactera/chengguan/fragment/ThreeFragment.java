package com.pactera.chengguan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pactera.chengguan.R;
import com.pactera.chengguan.base.BaseFragment;

/**
 * Created by lijun on 2015/12/11.
 */
public class ThreeFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initView(R.layout.approval_three, inflater);
        return view;
    }
    @Override
    public void initContentView(View view) {

    }
    @Override
    protected void lazyLoad() {
    }
}
