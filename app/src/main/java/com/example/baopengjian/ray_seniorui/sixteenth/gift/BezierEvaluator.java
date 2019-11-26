package com.example.baopengjian.ray_seniorui.sixteenth.gift;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by Ray on 2019-11-26.
 */
public class BezierEvaluator implements TypeEvaluator<PointF> {

    private PointF pointF1;
    private PointF pointF2;

    public BezierEvaluator(PointF pointF1, PointF pointF2) {
        this.pointF1 = pointF1;
        this.pointF2 = pointF2;
    }

    @Override
    public PointF evaluate(float t, PointF point0, PointF point3) {
        PointF point = new PointF();
        point.x = point0.x * (1 - t) * (1 - t) * (1 - t)
                + 3 * pointF1.x * t * (1 - t) * (1 - t)
                + 3 * pointF2.x * t * t * (1 - t)
                + point3.x * t * t * t;

        point.y = point0.y * (1 - t) * (1 - t) * (1 - t)
                + 3 * pointF1.y * t * (1 - t) * (1 - t)
                + 3 * pointF2.y * t * t * (1 - t)
                + point3.y * t * t * t;
        return point;
    }
}
