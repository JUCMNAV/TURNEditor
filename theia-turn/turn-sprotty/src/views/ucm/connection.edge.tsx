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
        } else if (segments.length > 2) {
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
        }

        return <path d={path}/>;
    }

    protected renderDanglingEdge(message: string, edge: SEdge, context: RenderingContext): VNode {
        return <text class-sprotty-edge-dangling={true}>{message}</text>;
    }
}