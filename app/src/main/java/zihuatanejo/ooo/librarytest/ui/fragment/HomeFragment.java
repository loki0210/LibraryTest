package zihuatanejo.ooo.librarytest.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import me.goldze.mvvmhabit.base.BaseFragment;
import zihuatanejo.ooo.librarytest.BR;
import zihuatanejo.ooo.librarytest.R;
import zihuatanejo.ooo.librarytest.databinding.FragmentHomeBinding;
import zihuatanejo.ooo.librarytest.ui.home.HomeViewModel;

/**
 * @author Zihuatanejo
 * @e-mail Zihuatanejo@Zihuatanejo.ooo
 * @time 2019/2/14
 */
public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> {
    /**
     * 初始化根布局
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return 布局layout的id
     */
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_home;
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
        // 使用 TabLayout 和 ViewPager 相关联
        binding.tabs.setupWithViewPager(binding.viewPager);

        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabs));
    }

    @Override
    public void initViewObservable() {
        viewModel.addPage();
    }
}
