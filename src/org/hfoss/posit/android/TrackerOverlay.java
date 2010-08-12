/*
 * File: TrackerOverlay.java
 * 
 * Copyright (C) 2010 The Humanitarian FOSS Project (http://www.hfoss.org)
 * 
 * This file is part of POSIT, Portable Open Search and Identification Tool.
 *
 * POSIT is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License (LGPL) as published 
 * by the Free Software Foundation; either version 3.0 of the License, or (at
 * your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU LGPL along with this program; 
 * if not visit http://www.gnu.org/licenses/lgpl.html.
 * 
 */
package org.hfoss.posit.android;

import java.util.List;

import org.hfoss.posit.android.TrackerState.PointAndTime;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

/**
 * Code adapted from on online tutorial.
 * @see http://www.calvin.edu/~jpr5/android/tracker.html
 *
 */
public class TrackerOverlay extends Overlay {

	private static TrackerState mTrackerState;

	private List<PointAndTime> pointsAndTimes;

	public TrackerOverlay(TrackerState state) {
		mTrackerState = state;
//		pointsAndTimes = new ArrayList<PointAndTime>();
	}

	@Override
	public synchronized void draw(Canvas canvas, MapView mapView, boolean shadow) {
		pointsAndTimes = mTrackerState.getPoints();

		if (pointsAndTimes.isEmpty()) {
			return;
		}
		Projection projection = mapView.getProjection();
		Paint paint = new Paint();
		paint.setAlpha(150);
		for (int i = 0; i < pointsAndTimes.size(); i++) {
			PointAndTime pointAndTime = pointsAndTimes.get(i);
			Point point = projection.toPixels(pointAndTime.getGeoPoint(), null);
			long nextTime;
			if (i == pointsAndTimes.size() - 1) {
				nextTime = System.currentTimeMillis();
			} else {
				PointAndTime nextPointAndTime = pointsAndTimes.get(i + 1);
				nextTime = nextPointAndTime.getTime();
				Point nextPoint = projection.toPixels(nextPointAndTime
						.getGeoPoint(), null);
				canvas.drawLine(point.x, point.y, nextPoint.x, nextPoint.y,
						paint);
			}
			canvas.drawCircle(point.x, point.y, (float) Math
					.log((nextTime - pointAndTime.getTime()) / 100), paint);
		}
	}
	
}