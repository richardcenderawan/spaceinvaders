package com.example.ujiansirrobin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;

import com.example.ujiansirrobin.R;

import java.util.Random;

import static com.example.ujiansirrobin.GameView.METEOR_DESTROYED;
import static com.example.ujiansirrobin.GameView.SCORE;


public class Meteor {

    private Bitmap mBitmap;
    private int mX;
    private int mY;
    private int mMaxX;
    private int mMinX;
    private int mMaxY;
    private int mMinY;

    private int mSpeed;
    private Rect mCollision;
    private int mScreenSizeX;
    private int mScreenSizeY;
    private int mHP;

    public Meteor(Context context, int screenSizeX, int screenSizeY){
        mScreenSizeX = screenSizeX;
        mScreenSizeY = screenSizeY;


        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.meteor_1);
        mBitmap = Bitmap.createScaledBitmap(mBitmap, mBitmap.getWidth() * 3/5, mBitmap.getHeight() * 3/5, false);

        mMaxX = screenSizeX - mBitmap.getWidth();
        mMaxY = screenSizeY - mBitmap.getHeight();
        mMinX = 0;
        mMinY = 0;
        mHP = 3;

        Random random = new Random();
        mSpeed = random.nextInt(3) + 1;

        mX = random.nextInt(mMaxX);
        mY = 0 - mBitmap.getHeight();

        mCollision = new Rect(mX, mY, mX + mBitmap.getWidth(), mY + mBitmap.getHeight());
    }

    public void update(){
        mY += 7 * mSpeed;

        mCollision.left = mX;
        mCollision.top = mY;
        mCollision.right = mX + mBitmap.getWidth();
        mCollision.bottom = mY + mBitmap.getHeight();
    }

    public Rect getCollision() {
        return mCollision;
    }

    public void hit(){
        if (--mHP ==0){
            SCORE += 20;
            METEOR_DESTROYED++;
            destroy();
        }else{

        }
    }

    public void destroy(){
        mY = mScreenSizeY + 1;

    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }
}
