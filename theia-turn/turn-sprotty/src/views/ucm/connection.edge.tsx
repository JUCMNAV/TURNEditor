/** @jsx svg */

import { Point, PolylineEdgeView, RenderingContext, SEdge} from "sprotty/lib";
import { VNode } from "snabbdom/vnode";
import { svg } from 'snabbdom-jsx';

export class ConnectionEdgeView extends PolylineEdgeView {

    static readonly TYPE = 'edge:connection';

    protected renderLine(edge: SEdge, segments: Point[], context: RenderingContext): VNode {
        const p1 = segments[0];
        const p2 = segments[1];
        return <line class-sprotty-edge={true} x1={p1.x} x2={p2.x} y1={p1.y} y2={p2.y} stroke-width="10"/>;
    }
}