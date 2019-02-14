package zihuatanejo.ooo.librarytest;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.SPUtils;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;
import zihuatanejo.ooo.librarytest.databinding.ActivityMainBinding;
import zihuatanejo.ooo.librarytest.ui.fragment.HomeFragment;
import zihuatanejo.ooo.librarytest.ui.fragment.MessageFragment;
import zihuatanejo.ooo.librarytest.ui.fragment.OtherFragment;


public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> {
    private List<Fragment> mFragments;

    /**
     * 初始化根布局
     *
     * @param savedInstanceState
     * @return 布局layout的id
     */
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
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

    @Override
    public void initData() {
        initFragment();
        initBottomTab();
    }

    private void initFragment() {
        Fragment homeFragment = new HomeFragment();
        Fragment msgFragment = new MessageFragment();
        Fragment otherFragment = new OtherFragment();
        mFragments = new ArrayList<>();
        mFragments.add(homeFragment);
        mFragments.add(msgFragment);
        mFragments.add(otherFragment);

        //默认选中第一个
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, homeFragment);
        transaction.commitAllowingStateLoss();

    }

    private void initBottomTab() {
        NavigationController navigationController = binding.pagerBottomTab.material()
                .addItem(R.drawable.ic_launcher_background, "首页")
                .addItem(R.drawable.ic_launcher_foreground, "消息")
                .addItem(R.drawable.ic_launcher_background, "其他")
                .setDefaultColor(ContextCompat.getColor(this, R.color.gray))
                .build();
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                Fragment currentFragment = mFragments.get(index);
                if (currentFragment != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, currentFragment);
                    transaction.commitAllowingStateLoss();
                }
            }

            @Override
            public void onRepeat(int index) {

            }
        });
    }
}
