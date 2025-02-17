/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2021. All rights reserved.
 */

package com.huawei.instructionstream.appui.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Window;

/**
 * BaseDialogFragment.
 *
 * @since 2021-06-10
 */
public abstract class BaseDialogFragment extends DialogFragment {
    protected int mRotation;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    /**
     * 设置旋转.Dialog根据rotation的角度来旋转方向
     *
     * @param rotation 旋转的方向,只能为以下四个值之一:
     *
     * @see android.view.Surface#ROTATION_0
     * @see android.view.Surface#ROTATION_90
     * @see android.view.Surface#ROTATION_180
     * @see android.view.Surface#ROTATION_270
     */
    public abstract void setRotation(int rotation);

    /**
     * 显示Dialog
     * @param rotation 当前希望显示的方向
     */
    public void show(FragmentManager manager,int rotation) {
        mRotation = rotation;
        super.show(manager, getClass().getSimpleName());
    }
}
