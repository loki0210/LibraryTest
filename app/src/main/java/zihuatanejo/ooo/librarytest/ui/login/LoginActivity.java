package zihuatanejo.ooo.librarytest.ui.login;

import android.databinding.Observable;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;


import me.goldze.mvvmhabit.base.BaseActivity;
import zihuatanejo.ooo.librarytest.BR;
import zihuatanejo.ooo.librarytest.R;
import zihuatanejo.ooo.librarytest.databinding.ActivityLoginBinding;

/**
 * @author Zihuatanejo
 * @e-mail Zihuatanejo@Zihuatanejo.ooo
 * @time 2019/2/13
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {
    /**
     * 初始化根布局
     *
     * @param savedInstanceState
     * @return 布局layout的id
     */
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    //监听ViewModel中pSwitchObservable的变化, 当ViewModel中执行【uc.pSwitchObservable.set(!uc.pSwitchObservable.get());】时会回调该方法
    @Override
    public void initViewObservable() {
        viewModel.uc.pSwitchObservable.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                //pSwitchObservable是boolean类型的观察者,所以可以直接使用它的值改变密码开关的图标
                if (viewModel.uc.pSwitchObservable.get()) {
                    //密码可见
                    //在xml中定义id后,使用binding可以直接拿到这个view的引用,不再需要findViewById去找控件了
                    binding.ivSwichPasswrod.setImageResource(R.drawable.ic_launcher_foreground);
                    binding.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    //密码不可见
                    binding.ivSwichPasswrod.setImageResource(R.drawable.ic_launcher_background);
                    binding.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
}
