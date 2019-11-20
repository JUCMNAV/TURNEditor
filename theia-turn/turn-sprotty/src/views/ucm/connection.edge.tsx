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
        } else if (segments.length === 4) {
            const p2 = segments[2];
            const p3 = segments[3];
            const midLength = Math.abs(p1.y - p2.y);
            const c = Math.min(midLength / 2.0, p1.x - p0.x, p3.x - p1.x);
            if (this.isGoingRight(p0, p1)) {
                path += this.getRightPath(c, p1);
                if (this.isGoingUp(p1, p2)) {
                    path += this.getArcPath(c, 0, p1.x, p1.y - c); // RIGHT UP
                    path += this.getUpPath(c, p2);
                    if (this.isGoingRight(p2, p3)) {
                        path += this.getArcPath(c, 1, p2.x + c, p2.y); // UP RIGHT
                    } else {
                        path += this.getArcPath(c, 0, p2.x - c, p2.y); // UP LEFT
                    }
                } else {
                    path += this.getArcPath(c, 1, p1.x, p1.y + c); // RIGHT DOWN
                    path += this.getDownPath(c, p2);
                    if (this.isGoingRight(p2, p3)) {
                        path += this.getArcPath(c, 0, p2.x + c, p2.y); // DOWN RIGHT
                    } else {
                        path += this.getArcPath(c, 1, p2.x - c, p2.y); // DOWN LEFT
                    }
                }
            } else {
                // TODO
            }
            path += this.getLinePath(p3.x, p3.y);
        } else if (segments.length === 6) {
            const p2 = segments[2];
            const p3 = segments[3];
            const p4 = segments[4];
            const p5 = segments[5];
            const midLength = Math.min(Math.abs(p1.y - p2.y), Math.abs(p3.y - p4.y));
            const c = Math.min(midLength / 2.0, Math.abs(p1.x - p0.x), Math.abs(p3.x - p2.x), Math.abs(p5.x - p4.x));
            if (this.isGoingRight(p0, p1)) {
                path += this.getRightPath(c, p1);
                if (this.isGoingUp(p1, p2)) {
                    path += this.getArcPath(c, 0, p1.x, p1.y - c); // RIGHT UP
                    path += this.getUpPath(c, p2);
                    if (this.isGoingRight(p2, p3)) {
                        path += this.getArcPath(c, 1, p2.x + c, p2.y); // UP RIGHT
                        path += this.getRightPath(c, p3);
                        if (this.isGoingUp(p3, p4)) {
                            path += this.getArcPath(c, 0, p3.x, p3.y - c); // RIGHT UP
                            path += this.getUpPath(c, p4);
                            if (this.isGoingRight(p4, p5)) {
                                path += this.getArcPath(c, 1, p4.x + c, p4.y); // UP RIGHT
                            } else {
                                path += this.getArcPath(c, 0, p4.x - c, p4.y); // UP LEFT
                            }
                        } else {
                            path += this.getArcPath(c, 1, p3.x, p3.y + c); // RIGHT DOWN
                            path += this.getDownPath(c, p4);
                            if (this.isGoingRight(p4, p5)) {
                                path += this.getArcPath(c, 0, p4.x + c, p4.y); // DOWN RIGHT
                            } else {
                                path += this.getArcPath(c, 1, p4.x - c, p4.y); // DOWN LEFT
                            }
                        }
                    } else {
                        path += this.getArcPath(c, 0, p2.x - c, p2.y); // UP LEFT
                        path += this.getLeftPath(c, p3);
                        if (this.isGoingUp(p3, p4)) {
                            path += this.getArcPath(c, 1, p3.x, p3.y - c); // LEFT UP
                            path += this.getUpPath(c, p4);
                            if (this.isGoingRight(p4, p5)) {
                                path += this.getArcPath(c, 1, p4.x + c, p4.y); // UP RIGHT
                            } else {
                                path += this.getArcPath(c, 0, p4.x - c, p4.y); // UP LEFT
                            }
                        } else {
                            path += this.getArcPath(c, 0, p3.x, p3.y + c); // LEFT DOWN
                            path += this.getDownPath(c, p4);
                            if (this.isGoingRight(p4, p5)) {
                                path += this.getArcPath(c, 0, p4.x + c, p4.y); // DOWN RIGHT
                            } else {
                                path += this.getArcPath(c, 1, p4.x - c, p4.y); // DOWN LEFT
                            }
                        }
                    }
                } else { // RIGHT, DOWN
                    path += this.getArcPath(c, 1, p1.x, p1.y + c); // RIGHT DOWN
                    path += this.getDownPath(c, p2);
                    if (this.isGoingRight(p2, p3)) {
                        path += this.getArcPath(c, 0, p2.x + c, p2.y); // DOWN RIGHT
                        path += this.getRightPath(c, p3);
                        if (this.isGoingUp(p3, p4)) {
                            path += this.getArcPath(c, 0, p3.x, p3.y - c); // RIGHT UP
                            path += this.getUpPath(c, p4);
                            if (this.isGoingRight(p4, p5)) {
                                path += this.getArcPath(c, 1, p4.x + c, p4.y); // UP RIGHT
                            } else {
                                path += this.getArcPath(c, 0, p4.x - c, p4.y); // UP LEFT
                            }
                        } else {
                            path += this.getArcPath(c, 1, p3.x, p3.y + c); // RIGHT DOWN
                            path += this.getDownPath(c, p4);
                            if (this.isGoingRight(p4, p5)) {
                                path += this.getArcPath(c, 0, p4.x + c, p4.y); // DOWN RIGHT
                            } else {
                                path += this.getArcPath(c, 1, p4.x - c, p4.y); // DOWN LEFT
                            }
                        }
                    } else { // RIGHT, DOWN, LEFT
                        path += this.getArcPath(c, 1, p2.x - c, p2.y); // DOWN LEFT
                        path += this.getLeftPath(c, p3);
                        if (this.isGoingUp(p3, p4)) {
                            path += this.getArcPath(c, 1, p3.x, p3.y - c); // LEFT UP
                            path += this.getUpPath(c, p4);
                            if (this.isGoingRight(p4, p5)) {
                                path += this.getArcPath(c, 1, p4.x + c, p4.y); // UP RIGHT
                            } else {
                                path += this.getArcPath(c, 0, p4.x - c, p4.y); // UP LEFT
                            }
                        } else {
                            path += this.getArcPath(c, 0, p3.x, p3.y + c); // LEFT DOWN
                            path += this.getDownPath(c, p4);
                            if (this.isGoingRight(p4, p5)) {
                                path += this.getArcPath(c, 0, p4.x + c, p4.y); // DOWN RIGHT
                            } else {
                                path += this.getArcPath(c, 1, p4.x - c, p4.y); // DOWN LEFT
                            }
                        }
                    }
                }
            } else { // LEFT
                path += ` L ${p1.x + c} ${p1.y}`;
                // TODO
            }
            path += this.getLinePath(p5.x, p5.y);
        } else {
            for (let p = 1; p < segments.length; p++) {
                path += ` L ${segments[p].x} ${segments[p].y}`;
            }
        }

        return <path d={path}/>;
    }

    protected renderDanglingEdge(message: string, edge: SEdge, context: RenderingContext): VNode {
        return <text class-sprotty-edge-dangling={true}>{message}</text>;
    }

    protected isGoingUp(firstPoint: Point, secondPoint: Point): boolean {
        return firstPoint.y > secondPoint.y;
    }

    protected isGoingRight(firstPoint: Point, secondPoint: Point): boolean {
        return secondPoint.x > firstPoint.x;
    }

    protected getDownPath(arcRadius: number, p: Point): String {
        return this.getLinePath(p.x, p.y - arcRadius);
    }

    protected getUpPath(arcRadius: number, p: Point): String {
        return this.getLinePath(p.x, p.y + arcRadius);
    }

    protected getLeftPath(arcRadius: number, p: Point): String {
        return this.getLinePath(p.x + arcRadius, p.y);
    }

    protected getRightPath(arcRadius: number, p: Point): String {
        return this.getLinePath(p.x - arcRadius, p.y);
    }

    protected getArcPath(arcRadius: number, clockwise: number, stopX: number, stopY: number): String {
        return ` A ${arcRadius} ${arcRadius} 0 0 ${clockwise} ${stopX} ${stopY}`;
    }

    protected getLinePath(stopX: number, stopY: number): String {
        return ` L ${stopX} ${stopY}`;
    }

}