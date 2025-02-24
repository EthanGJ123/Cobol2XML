/*
 * @(#)LimitingLinearCalculator.java	 1.0.0
 *
 * Copyright (c) 1999 Steven J. Metsker
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 */
 
package utensil;
public class LimitingLinearCalculator extends LinearCalculator {
/**
 * Create a LimitingLinearCalculator from known points on two scales.
 *
 * @param xFrom xFrom
 * @param xTo xTo
 * @param yFrom yFrom
 * @param yTo yTo
 */
public LimitingLinearCalculator(double xFrom, double xTo, double yFrom, double yTo) {
	super(xFrom, xTo, yFrom, yTo);
}
/**
 * Return the value on the first scale, corresponding to the given
 * value on the second scale. Limit the X value to be between xFrom
 * and xTo.
 *
 * @return the value on the first scale, corresponding to the given
 *         value on the second scale
 */
public double calculateXforGivenY(double y) {
	if (y <= yTo && y <= yFrom) {
		return yFrom <= yTo ? xFrom : xTo;
	}
	if (y >= yTo && y >= yFrom) {
		return yFrom >= yTo ? xFrom : xTo;
	}
	return super.calculateXforGivenY(y);
}
/**
 * Return the value on the second scale, corresponding to the given
 * value on the first scale. Limit the Y value to be between yFrom
 * and yTo.
 *
 * @return the value on the second scale, corresponding to the given
 *         value on the first scale
 */
public double calculateYforGivenX(double x) {
	if (x <= xTo && x <= xFrom) {
		return xFrom <= xTo ? yFrom : yTo;
	}
	if (x >= xTo && x >= xFrom) {
		return xFrom >= xTo ? yFrom : yTo;
	}
	return super.calculateYforGivenX(x);
}
}