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
            path += ` A ${p1.x - p0.x} ${p1.x - p0.x} 0 0 0 ${p1.x} ${p1.y - p1.x + p0.x}`;
            path += ` L ${p1.x} ${p2.y + p3.x - p1.x}`;
            path += ` A ${p3.x - p1.x} ${p3.x - p1.x} 0 0 1 ${p3.x} ${p3.y}`;
        }

        return <path d={path}/>;
    }

    protected renderDanglingEdge(message: string, edge: SEdge, context: RenderingContext): VNode {
        return <text class-sprotty-edge-dangling={true}>{message}</text>;
    }
}