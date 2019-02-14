package zihuatanejo.ooo.librarytest.ui.home;

import android.support.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;

/**
 * @author Zihuatanejo
 * @e-mail Zihuatanejo@Zihuatanejo.ooo
 * @time 2019/2/14
 */
public class ViewPagerItemViewModel extends ItemViewModel {
    public String text;
    public SingleLiveEvent<String> clickEvent = new SingleLiveEvent();

    public ViewPagerItemViewModel(@NonNull BaseViewModel viewModel, String text) {
        super(viewModel);
        this.text = text;
    }

    public BindingCommand onClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //点击之后将逻辑转到adapter中处理
            clickEvent.setValue(text);
        }
    });
}
