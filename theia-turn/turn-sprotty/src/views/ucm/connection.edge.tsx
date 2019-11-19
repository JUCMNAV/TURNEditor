/** @jsx svg */

import { Point, RenderingContext, SEdge} from "sprotty/lib";
import { VNode } from "snabbdom/vnode";
import { svg } from 'snabbdom-jsx';
import {IView} from "sprotty/lib/base/views/view";

export class ConnectionEdgeView implements IView {

    static readonly TYPE = 'edge:connection';

    render(edge: Readonly<SEdge>, context: RenderingContext): VNode {
        const route = edge.route();
        if (route.length === 0)
            return this.renderDanglingEdge("Cannot compute route", edge, context);

        return <g class-ucm-edge={true}>
            {this.renderLine(edge, route, context)}
            {context.renderChildren(edge, { route })}
        </g>;
    }

    protected renderLine(edge: SEdge, segments: Point[], context: RenderingContext): VNode {

        const p0 = segments[0];
        const p1 = segments[1];
        let path = `M ${p0.x} ${p0.y}`;
        if (segments.length <= 2) {
            path += ` L ${p1.x} ${p1.y}`;
        } else if (segments.length > 2 && segments.length <= 4) {
            const p2 = segments[2];
            const p3 = segments[3];
            const midLength = Math.abs(p1.y - p2.y);
            const c = Math.min(midLength / 2.0, p1.x - p0.x, p3.x - p1.x);
            if (p3.y < p0.y) {
                path += ` L ${p1.x - c} ${p1.y}`;
                path += ` A ${c} ${c} 0 0 0 ${p1.x} ${p1.y - c}`;
                path += ` L ${p2.x} ${p2.y + c}`;
                path += ` A ${c} ${c} 0 0 1 ${p2.x + c} ${p2.y}`;
                path += ` L ${p3.x} ${p3.y}`;
            } else {
                path += ` L ${p1.x - c} ${p1.y}`;
                path += ` A ${c} ${c} 0 0 1 ${p1.x} ${p1.y + c}`;
                path += ` L ${p2.x} ${p2.y - c}`;
                path += ` A ${c} ${c} 0 0 0 ${p2.x + c} ${p2.y}`;
                path += ` L ${p3.x} ${p3.y}`;
            }
        } else {
            // const arcRadius = this.determineArcRadius(segments);
            // for (let p = 0; p < segments.length - 2; p++) {
            //     const direction = this.determineArcDirection(segments[p], segments[p + 1], segments[p + 2]);
            //     const linePoint = this.determineLinePoint(segments[p], segments[p + 1], arcRadius);
            //     const arcStopPoint = this.determineArcStopPoint(segments[p + 1], segments[p + 2], arcRadius);
            //     path += ` L ${linePoint.x} ${linePoint.y}`;
            //     path += ` A ${arcRadius} ${arcRadius} 0 0 ${direction} ${arcStopPoint.x} ${arcStopPoint.y}`;
            // }
            // path += ` L ${segments[segments.length - 1].x} ${segments[segments.length - 1].y}`;
            for (let p = 1; p < segments.length; p++) {
                path += ` L ${segments[p].x} ${segments[p].y}`;
            }
        }

        return <path d={path}/>;
    }

    protected renderDanglingEdge(message: string, edge: SEdge, context: RenderingContext): VNode {
        return <text class-sprotty-edge-dangling={true}>{message}</text>;
    }

    protected determineArcRadius(points: Point[]): number {
        let min = Number.MAX_VALUE;
        for (let i = 0; i < points.length - 1; i++) {
            if (points[i].x !== points[i + 1].x) {
                const xDifference = Math.abs(points[i].x - points[i + 1].x);
                min =  xDifference < min ? xDifference : min;
            } else if (points[i].y !== points[i + 1].y) {
                const yDifference = Math.abs(points[i].y - points[i + 1].y) / 2.0;
                min = yDifference < min ? yDifference : min;
            }
        }
        return min;
    }

    protected determineArcDirection(p1: Point, p2: Point, p3: Point): number {
        const xDirection = p3.x - p1.x;
        const yDirection = p1.y - p3.y;
        const isHorizontalBeforeVertical = p2.x - p1.x > 0;
        let arc: number = 0;
        if (isHorizontalBeforeVertical) {
            if (yDirection > 0 && xDirection > 0) {
                arc = 0;
            } else if (yDirection < 0 && xDirection > 0) {
                arc = 1;
            } else if (yDirection > 0 && xDirection < 0) {
                arc = 1;
            } else if (yDirection < 0 && xDirection < 0) {
                arc = 0;
            }
        } else {
            if (yDirection > 0 && xDirection > 0) {
                arc = 1;
            } else if (yDirection < 0 && xDirection > 0) {
                arc = 0;
            } else if (yDirection > 0 && xDirection < 0) {
                arc = 0;
            } else if (yDirection < 0 && xDirection < 0) {
                arc = 1;
            }
        }
        return arc;
    }

    protected determineArcStopPoint(p2: Point, p3: Point, arcRadius: number): Point {
        const xDirection = p3.x - p2.x;
        const yDirection = p2.y - p3.y;
        let x = p3.x;
        let y = p3.y;
        if (xDirection > 0) {
            x = p2.x + arcRadius;
        } else if (xDirection < 0) {
            x = p2.x - arcRadius;
        } else {
            if (yDirection > 0) {
                y = p2.y + arcRadius;
            } else if (yDirection < 0) {
                y = p2.y - arcRadius;
            }
        }
        return new class implements Point {
            readonly x: number = x;
            readonly y: number = y;
        };
    }

    protected determineLinePoint(p1: Point, p2: Point, arcRadius: number): Point {
        const xDirection = p2.x - p1.x;
        const yDirection = p1.y - p2.y;
        let x = p2.x;
        let y = p2.y;
        if (xDirection > 0) {
            x = p2.x - arcRadius;
        } else if (xDirection < 0) {
            x = p1.x + arcRadius;
        } else {
            if (yDirection > 0) {
                y = p2.y + arcRadius;
            } else if (yDirection < 0) {
                y = p1.y - arcRadius;
            }
        }
        return new class implements Point {
            readonly x: number = x;
            readonly y: number = y;
        };
    }
}