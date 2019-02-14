package zihuatanejo.ooo.librarytest.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import zihuatanejo.ooo.librarytest.BR;
import me.goldze.mvvmhabit.base.BaseFragment;
import zihuatanejo.ooo.librarytest.R;
import zihuatanejo.ooo.librarytest.databinding.FragmentMessageBinding;
import zihuatanejo.ooo.librarytest.ui.message.MessageViewModel;


/**
 * @author Zihuatanejo
 * @e-mail Zihuatanejo@Zihuatanejo.ooo
 * @time 2019/2/14
 */
public class MessageFragment extends BaseFragment<FragmentMessageBinding, MessageViewModel> {
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
        return R.layout.fragment_message;
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
        super.initData();
    }
}
