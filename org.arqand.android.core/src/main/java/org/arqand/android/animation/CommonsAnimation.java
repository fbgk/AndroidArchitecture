package org.arqand.android.animation;

import org.arqand.android.commons.activity.CommonsActivity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

/**
 * The Class CommonsAnimations.
 */
public class CommonsAnimation {
	
	/**
	 * Active animations. Seek animation to bring the view and will start
	 * 
	 * @param viewId
	 *            the view id
	 */
	public static void activeAnimations(int viewId) {
		activeAnimations(viewId, 0, null);
	}
	
	/**
	 * Active animations. It will make the animation for parameter tells
	 * 
	 * @param viewId
	 *            the view id
	 * @param animation
	 *            the animation
	 */
	public static void activeAnimations(int viewId, int animation) {
		activeAnimations(viewId, animation, null);
	}
	
	/**
	 * Active animations. It will make the animation that is indicated by the last parameter and action
	 * 
	 * @param viewId
	 *            the view id
	 * @param animation
	 *            the animation
	 * @param animationListener
	 *            the animation listener
	 */
	public static void activeAnimations(int viewId, int animation, AnimationListener animationListener) {
		View view = CommonsActivity.getActivity().findViewById(viewId);
		runAnimations(view, animation, animationListener);
	}
	
	/**
	 * Active animations. Seek animation to bring the view and will start
	 * 
	 * @param view
	 *            the view id
	 */
	public static void activeAnimations(View view) {
		runAnimations(view, 0, null);
	}
	
	/**
	 * Active animations. It will make the animation for parameter tells
	 * 
	 * @param view
	 *            the view
	 * @param animation
	 *            the animation
	 */
	public static void activeAnimations(View view, int animation) {
		runAnimations(view, animation, null);
	}
	
	/**
	 * Active animations. It will make the animation that is indicated by the last parameter and action
	 * 
	 * @param view
	 *            the view
	 * @param animation
	 *            the animation
	 * @param animationListener
	 *            the animation listener
	 */
	public static void activeAnimations(View view, int animation, AnimationListener animationListener) {
		runAnimations(view, animation, animationListener);
	}
	
	/**
	 * Run animations. Method developed to use various calls
	 * 
	 * @param view
	 *            the view
	 * @param animation
	 *            the animation
	 * @param animationListener
	 *            the animation listener
	 */
	private static void runAnimations(View view, int animation, AnimationListener animationListener) {
		if (view != null) {
			Animation animFadein = null;
			if (animation == 0) {
				animFadein = view.getAnimation();
			} else {
				animFadein = AnimationUtils.loadAnimation(CommonsActivity.getActivity(), animation);
			}
			if (animFadein != null) {
				if (animationListener != null) {
					animFadein.setAnimationListener(animationListener);
				}
				view.startAnimation(animFadein);
			}
		}
	}
	
}
