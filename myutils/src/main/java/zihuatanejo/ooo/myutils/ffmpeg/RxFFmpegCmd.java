package zihuatanejo.ooo.myutils.ffmpeg;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;


public class RxFFmpegCmd {
    public Observable<FFmpegReturen> execute(String[] commands) {
        return Observable.create((ObservableOnSubscribe<FFmpegReturen>) emitter -> {
            //调用ffmpeg进行处理
            int result = 0;
            emitter.onNext(new FFmpegReturen(FFmpegReturen.RETURN_SUCCESS, result));
            emitter.onComplete();
        }).onErrorReturn(throwable -> new FFmpegReturen(FFmpegReturen.RETURN_ERROR, throwable.getMessage()));
    }

    public static class FFmpegReturen {
        public static final int RETURN_SUCCESS = 2;
        public static final int RETURN_ERROR = 3;
        public static final int RETURN_RUNNING = 5;
        public static final int RETURN_START = 4;
        private int state;
        private Object object;
        private String msg;
        private int progress;

        public FFmpegReturen(int state) {
            this.state = state;
        }
        public FFmpegReturen(int state, String msg) {
            this.state = state;
            this.object = msg;
            this.msg = msg;
        }
        public FFmpegReturen(int state, int progress) {
            this.state = state;
            this.object = progress;
            this.progress = progress;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }
    }
}
