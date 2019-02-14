package zihuatanejo.ooo.librarytest.adapter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.view.ViewGroup;


import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;
import zihuatanejo.ooo.librarytest.databinding.ItemViewpagerBinding;
import zihuatanejo.ooo.librarytest.ui.home.ViewPagerItemViewModel;

/**
 * @author Zihuatanejo
 * @e-mail Zihuatanejo@Zihuatanejo.ooo
 * @time 2019/2/14
 */
public class ViewPagerBindingAdapter extends BindingViewPagerAdapter<ViewPagerItemViewModel> {
    @Override
    public void onBindBinding(final ViewDataBinding binding, int variableId, int layoutRes, int position, ViewPagerItemViewModel item) {
        super.onBindBinding(binding, variableId, layoutRes, position, item);
        //这里可以强转成ViewPagerItemViewModel对应的ViewDataBinding，
        ItemViewpagerBinding _binding = (ItemViewpagerBinding) binding;
        item.clickEvent.observe((LifecycleOwner) _binding.getRoot().getContext(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                ToastUtils.showShort(s);
            }
        });
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
