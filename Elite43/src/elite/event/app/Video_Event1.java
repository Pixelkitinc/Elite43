package elite.event.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.View;
import elite.act.app.MainActivity;
import elite.backend.app.MainActivity_Backend;

public class Video_Event1 implements OnCompletionListener {
	
	/**
	 * Invokes the video after completion and animation ends after execution. 
	 */
	
	@SuppressLint("NewApi")
	@Override
	public void onCompletion(MediaPlayer arg0) {
		MainActivity.video.stopPlayback();
		MainActivity.video_image_layout.setVisibility(View.VISIBLE);
		MainActivity.video_image_layout.setAlpha(0f);
		MainActivity.video_image_layout.animate().alpha(1f).setDuration(500).setListener(new AnimatorListenerAdapter() {
            @Override
			public void onAnimationEnd(Animator animation) {
                MainActivity.video_layout.setVisibility(View.GONE);
                MainActivity.video_image_layout.clearAnimation();
                MainActivity_Backend.NetworkAccess();
            }
        });
	}
}
