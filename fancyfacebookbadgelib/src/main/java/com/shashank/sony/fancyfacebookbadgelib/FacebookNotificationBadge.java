package com.shashank.sony.fancyfacebookbadgelib;

import ohos.agp.animation.Animator;
import ohos.agp.animation.AnimatorProperty;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.AttrSet;
import ohos.agp.components.Image;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.StackLayout;
import ohos.agp.components.Text;
import ohos.agp.utils.Color;
import ohos.app.Context;
import ohos.global.configuration.DeviceCapability;
import ohos.global.resource.NotExistException;
import ohos.global.resource.ResourceManager;
import ohos.global.resource.WrongTypeException;
import ohos.global.resource.solidxml.TypedAttribute;
import java.io.IOException;

/**
 * Main class for facebook Notification badge.
 */
public class FacebookNotificationBadge extends StackLayout {
    private static final int DEFAULT_TEXT_COLOR = Color.getIntColor("#3F51B5");
    private static final int DEFAULT_TEXT_SIZE = 24;
    private static final boolean DEFAULT_ANIMATION_ENABLED = true;
    private static final int DEFAULT_ANIMATION_DURATION = 500;
    private static final int DEFAULT_MAX_TEXT_LENGTH = 2;
    private static final String DEFAULT_MAX_LENGTH_REACHED_TEXT = "...";

    private StackLayout mContainer;
    private Image mIvBadgeBg;
    private Text mTvBadgeText;
    private int mBadgeTextColor = DEFAULT_TEXT_COLOR;
    private float mBadgeTextSize = dpToPx(DEFAULT_TEXT_SIZE);
    private int mAnimationDuration = DEFAULT_ANIMATION_DURATION;
    private AnimatorProperty mUpdate;
    private AnimatorProperty mShow;
    private AnimatorProperty mHide;
    private String mBadgeText;
    private boolean mIsBadgeShown;
    private boolean mAnimationEnabled = DEFAULT_ANIMATION_ENABLED;
    private int mMaxTextLength = DEFAULT_MAX_TEXT_LENGTH;
    private String mEllipsizeText = DEFAULT_MAX_LENGTH_REACHED_TEXT;

    /**
     * FacebookNotificationBadge constructor.
     *
     * @param context current context
     * @param attrs xml attrs
     */
    public FacebookNotificationBadge(Context context, AttrSet attrs) {
        super(context, attrs);

        ComponentContainer cmp;
        cmp = (ComponentContainer) LayoutScatter.getInstance(context).
                parse(ResourceTable.Layout_facebook_notification_badge, this, true);

        mContainer = (StackLayout) cmp.findComponentById(ResourceTable.Id_fl_container);
        mIvBadgeBg = (Image) cmp.findComponentById(ResourceTable.Id_iv_badge_bg);
        mTvBadgeText = (Text) cmp.findComponentById(ResourceTable.Id_tv_badge_text);

        try {
            mBadgeTextColor = TypedAttrUtil.getColor(attrs, "nbTextColor", new Color(DEFAULT_TEXT_COLOR));
            mTvBadgeText.setTextColor(new Color(mBadgeTextColor));

            mBadgeTextSize = context.getResourceManager().getElement((int) dpToPx(DEFAULT_TEXT_SIZE)).getInteger();
            mTvBadgeText.setTextSize((int) mBadgeTextSize, Text.TextSizeType.PX);

            mAnimationEnabled = TypedAttrUtil.getBoolean(attrs, "nbAnimationEnabled", DEFAULT_ANIMATION_ENABLED);

            mAnimationDuration = TypedAttrUtil.getInteger(attrs, "nbAnimationDuration", DEFAULT_ANIMATION_DURATION);

            mMaxTextLength = TypedAttrUtil.getInteger(attrs, "nbMaxTextLength", DEFAULT_MAX_TEXT_LENGTH);
            mEllipsizeText = TypedAttrUtil.getString(attrs, "nbEllipsizeText", DEFAULT_MAX_LENGTH_REACHED_TEXT);
            if (mEllipsizeText == null) {
                mEllipsizeText = DEFAULT_MAX_LENGTH_REACHED_TEXT;
            }
        } catch (NotExistException | WrongTypeException | IOException e) {
            e.printStackTrace();
        }

        if (mAnimationEnabled) {
            initUpdateAnimation();
        }
    }

    public void clear() {
        if (mIsBadgeShown) {
            if (mAnimationEnabled) {
                mHide.start();
            } else {
                mContainer.setVisibility(INVISIBLE);
            }
            mIsBadgeShown = false;
        }
    }

    public void show(String text) {
        mBadgeText = text;
        if (!mIsBadgeShown) {
            if (mAnimationEnabled) {
                mShow.start();
            } else {
                mContainer.setVisibility(VISIBLE);
                mTvBadgeText.setText(text);
            }
            mIsBadgeShown = true;
        } else {
            mTvBadgeText.setText(text);
        }
    }

    public boolean isAnimationEnabled() {
        return mAnimationEnabled;
    }

    public void setAnimationEnabled(boolean animationEnabled) {
        mAnimationEnabled = animationEnabled;
        if (animationEnabled && (mUpdate == null || mShow == null || mHide == null)) {
            initUpdateAnimation();
        }
    }
    public void setEmoji(Emoji emoji){
        if(emoji==Emoji.ANGRY)
            mIvBadgeBg.setPixelMap(ResourceTable.Media_angryimg);
        else if(emoji==Emoji.HAHA)
            mIvBadgeBg.setPixelMap(ResourceTable.Media_hahaimg);
        else if(emoji==Emoji.LIKE)
            mIvBadgeBg.setPixelMap(ResourceTable.Media_likeimg);
        else if(emoji==Emoji.LOVE)
            mIvBadgeBg.setPixelMap(ResourceTable.Media_loveimg);
        else if(emoji==Emoji.SAD)
            mIvBadgeBg.setPixelMap(ResourceTable.Media_sadimg);
        else if(emoji==Emoji.WOW)
            mIvBadgeBg.setPixelMap(ResourceTable.Media_wowimg);
    }

    public void setMaxTextLength(int maxLength) {
        mMaxTextLength = maxLength;
    }

    public void setText(String text) {
        if (text != null && text.length() > mMaxTextLength) {
            mBadgeText = mEllipsizeText;
        } else {
            mBadgeText = text;
        }
        if (text == null || text.isEmpty()) {
            clear();
        } else {
            if (mIsBadgeShown) {
                if (mAnimationEnabled) {
                    mUpdate.start();
                } else {
                    mTvBadgeText.setText(mBadgeText);
                }
            } else {
                show(mBadgeText);
            }
        }
    }

    public void setNumber(int number) {
        if (number == 0) {
            clear();
        } else {
            setText(String.valueOf(number));
        }
    }

    public int getTextColor() {
        return mBadgeTextColor;
    }

    public void setTextColor(int textColor) {
        mBadgeTextColor = textColor;
        mTvBadgeText.setTextColor(new Color(mBadgeTextColor));
    }


    private void initUpdateAnimation() {

        mUpdate = new AnimatorProperty(mContainer);
        mUpdate.scaleXFrom(1).scaleX(0.8f).scaleYFrom(1).scaleY(0.8f).alpha(1).setDuration(mAnimationDuration / 2);
        mUpdate.setLoopedCount(1);
        mUpdate.setStateChangedListener(new Animator.StateChangedListener() {
            @Override
            public void onStart(Animator animator) {
                mTvBadgeText.setText(mBadgeText);
            }

            @Override
            public void onStop(Animator animator) {
                //doNothing
            }

            @Override
            public void onCancel(Animator animator) {
                //doNothing
            }

            @Override
            public void onEnd(Animator animator) {
                //doNothing
            }

            @Override
            public void onPause(Animator animator) {
                //doNothing
            }

            @Override
            public void onResume(Animator animator) {
                //doNothing
            }
        });

        mShow = new AnimatorProperty(mContainer);
        mShow.scaleXFrom(0).scaleX(1).scaleYFrom(0).scaleY(1).alpha(1).setDuration(mAnimationDuration / 2);
        mShow.setStateChangedListener(new Animator.StateChangedListener() {
            @Override
            public void onStart(Animator animator) {
                mContainer.setVisibility(VISIBLE);
                mTvBadgeText.setText(mBadgeText);
            }

            @Override
            public void onStop(Animator animator) {
                //doNothing
            }

            @Override
            public void onCancel(Animator animator) {
                //doNothing
            }

            @Override
            public void onEnd(Animator animator) {
                //doNothing
            }

            @Override
            public void onPause(Animator animator) {
                //doNothing
            }

            @Override
            public void onResume(Animator animator) {
                //doNothing
            }
        });


        mHide = new AnimatorProperty(mContainer);
        mHide.scaleXFrom(1).scaleX(0).scaleYFrom(1).scaleY(0).alpha(1).setDuration(mAnimationDuration / 2);
        mHide.setStateChangedListener(new Animator.StateChangedListener() {
            @Override
            public void onStart(Animator animator) {
                //doNothing
            }

            @Override
            public void onStop(Animator animator) {
                mContainer.setVisibility(INVISIBLE);
            }

            @Override
            public void onCancel(Animator animator) {
                //doNothing
            }

            @Override
            public void onEnd(Animator animator) {
                //doNothing
            }

            @Override
            public void onPause(Animator animator) {
                //doNothing
            }

            @Override
            public void onResume(Animator animator) {
                //doNothing
            }
        });
    }

    private float dpToPx(float dp){
        ResourceManager resourceManager = getContext().getApplicationContext().getResourceManager();
        DeviceCapability deviceCapability = resourceManager.getDeviceCapability();
        return (dp * TypedAttribute.computeTranslateRatio(deviceCapability));
    }
}
