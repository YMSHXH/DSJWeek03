package com.example.king.dsjweek03.weight;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.example.king.dsjweek03.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AddView extends ConstraintLayout {
    @BindView(R.id.minus)
    TextView minus;
    @BindView(R.id.et_num)
    TextView etNum;
    @BindView(R.id.add)
    TextView add;

    private int num = 1;
    private AddMinusCallback addMinusCallback;

    public void setAddMinusCallback(AddMinusCallback addMinusCallback) {
        this.addMinusCallback = addMinusCallback;
    }

    public AddView(Context context) {
        this(context, null);
    }

    public AddView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_add, this, true);
        Unbinder bind = ButterKnife.bind(this, view);

        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                num ++ ;
                etNum.setText(num + "");
                if (addMinusCallback != null) {
                    addMinusCallback.numCallback(num);
                }
            }
        });

        minus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                num -- ;
                if (num == 0) {
                    num = 1;
                    ToastUtils.showLong("不能再减了");
                }
                etNum.setText(num + "");
                if (addMinusCallback != null) {
                    addMinusCallback.numCallback(num);
                }
            }
        });
    }


    public interface AddMinusCallback{
        void numCallback(int num);
    }
}
