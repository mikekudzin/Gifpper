package com.mk.gifpper.dataadapters;

import android.animation.Animator;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Animatable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.mk.gifpper.animation.AnimationFactory;
import com.mk.gifpper.service.entities.FixedWidth;
import com.mk.gifpper.service.entities.GifModel;

/**
 * Created by Mike on 6/20/2016.
 */
public class CustomBindings {
    private static final int red = 0xff0000;

    @BindingAdapter("app:imageUrl")
    public static void loadImage(final SimpleDraweeView imageView, String url) {
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(url)
                .setAutoPlayAnimations(true)
                .setControllerListener(new ControllerListener(imageView))
                .build();
        imageView.setController(controller);
    }

    @BindingAdapter("app:gifObj")
    public static void loadImage(final SimpleDraweeView imageView, FixedWidth fixedWidth) {

        int imgWidth = Integer.valueOf(fixedWidth.getWidth());
        int imgHeight = Integer.valueOf(fixedWidth.getHeight());
        int viewHeight = (int) (imageView.getWidth() * ((float) imgHeight / imgWidth) + 0.5);
        imageView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        imageView.getLayoutParams().height = viewHeight;
        imageView.setAspectRatio((float) imgWidth / imgHeight);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(fixedWidth.getUrl())
                .setAutoPlayAnimations(true)
                .setControllerListener(new ControllerListener(imageView))
                .build();
        imageView.setController(controller);
    }

    @BindingAdapter("app:gifTrending")
    public static void resolveTrendingMark(final ImageView imageView, GifModel gifModel) {
        final String trendingDate = gifModel.getTrendingDatetime();
        boolean showTrendingMark = trendingDate != null && !TextUtils.isEmpty(trendingDate.trim());

        Animator animator = ((Animator) imageView.getTag());
        if (animator == null) {
            animator = AnimationFactory.INSTANCE.createHotAnimator(imageView);
            imageView.setTag(animator);
        }

        if (!showTrendingMark) {
            imageView.setVisibility(View.INVISIBLE);
            if (animator.isStarted()) {
                animator.cancel();
            }
        } else {
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int[] location = new int[2];
                    imageView.getLocationOnScreen(location);
                    Toast info = Toast.makeText(imageView.getContext(), "Was trending on " + trendingDate, Toast.LENGTH_SHORT);
                    info.setGravity(Gravity.TOP | Gravity.LEFT, location[0], location[1]);
                    info.show();
                }
            });
            animator.start();
        }
    }


    private static class ControllerListener extends BaseControllerListener<ImageInfo> {
        private SimpleDraweeView draweeView;

        public ControllerListener(SimpleDraweeView draweeView) {
            this.draweeView = draweeView;
        }

        void updateViewSize(@Nullable ImageInfo imageInfo) {
            if (imageInfo != null) {
                draweeView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
                draweeView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                draweeView.setAspectRatio((float) imageInfo.getWidth() / imageInfo.getHeight());
            }
        }

        @Override
        public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {
            updateViewSize(imageInfo);
        }

        @Override
        public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
            updateViewSize(imageInfo);
        }
    }
}
