package zihuatanejo.ooo.myutils.ffmpeg;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FFmpegEditor {

    public interface FFmegEditorProgressListener {
        void onProgressListener(float f);
    }

    public enum FileSizeType {
        byteSize,
        kbSize,
        mbSize,
        gbSize,
        tSize
    }

    public static String getFileSuffixName(String str) {
        String[] split = str.split("\\.");
        return "." + split[split.length - 1];
    }

    private static boolean isString(String str) {
        return str != null && !"".equals(str.trim()) && !"null".equalsIgnoreCase(str);
    }

    private static int valueToInt(String str) {
        int i = 0;
        try {
            if (isString(str)) {
                i = Integer.valueOf(str);
            }
        } catch (Exception unused) {
            return i;
        }
        return i;
    }

    public static int getFileSize(String str, FileSizeType fileSizeType) {
        long length = new File(str).length();
        switch (fileSizeType) {
            case byteSize:
                return (int) length;
            case kbSize:
                return ((int) length) / 1024;
            case mbSize:
                return (((int) length) / 1024) / 1024;
            case gbSize:
                return ((((int) length) / 1024) / 1024) / 1024;
            case tSize:
                return (((((int) length) / 1024) / 1024) / 1024) / 1024;
            default:
                return (int) length;
        }
    }

    public static int getRotate(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        return valueToInt(mediaMetadataRetriever.extractMetadata(24));
    }

    public static long getDurationMs(String str) throws IllegalArgumentException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        return Long.valueOf(mediaMetadataRetriever.extractMetadata(9));
    }

    public static int getWidth(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        return valueToInt(mediaMetadataRetriever.extractMetadata(18));
    }

    public static int getHeight(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        return valueToInt(mediaMetadataRetriever.extractMetadata(19));
    }

    public static Bitmap getThumbnail(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        return mediaMetadataRetriever.getFrameAtTime(0);
    }

    private static long onProgressToLong(String str) {
        str = str.trim();
        int indexOf = str.indexOf("time=");
        int indexOf2 = str.indexOf("bitrate=");
        if (indexOf == -1 || indexOf2 == -1) {
            return 0;
        }
        String[] split = str.substring(indexOf + 5, indexOf2).split("\\.");
        String[] split2 = split[0].split(":");
        return (long) (((((Integer.parseInt(split2[0].trim()) * 3600) * 1000) + ((Integer.parseInt(split2[1].trim()) * 60) * 1000)) + (Integer.parseInt(split2[2].trim()) * 1000)) + Integer.parseInt(split[1].trim()));
    }


    public static int toInt(byte[] bArr) {
        return (((bArr[3] << 24) + (bArr[2] << 16)) + (bArr[1] << 8)) + (bArr[0]);
    }

    public static short toShort(byte[] bArr) {
        return (short) ((bArr[1] << 8) + (bArr[0]));
    }

    public static byte[] read(RandomAccessFile randomAccessFile, int i, int i2) throws IOException {
        randomAccessFile.seek((long) i);
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = randomAccessFile.readByte();
        }
        return bArr;
    }
}
