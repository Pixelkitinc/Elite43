package elite.event.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.view.View;
import elite.act.app.MainActivity;
import elite.backend.app.MainActivity_Backend;

@SuppressLint("NewApi")
public class Video_Event2 implements OnErrorListener {
	
	/**
	 * Executes when error occurred on video.
	 */
	@SuppressLint("NewApi")
	@Override
	public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
		MainActivity.video.stopPlayback();
		MainActivity.video_layout.setVisibility(View.GONE);
		MainActivity.video_image_layout.setVisibility(View.VISIBLE);
		MainActivity.video_image_layout.setAlpha(0f);
		MainActivity.video_image_layout.animate().alpha(1f).setDuration(500).setListener(new AnimatorListenerAdapter() {
            @Override
			public void onAnimationEnd(Animator animation) {
                MainActivity.video_image_layout.clearAnimation();
                MainActivity_Backend.NetworkAccess();
            }
        });
		return false;
	}
}
