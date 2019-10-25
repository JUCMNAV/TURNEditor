/** @jsx svg */

import {Point, PolylineEdgeView, RenderingContext, SEdge} from "sprotty/lib";
import { VNode } from "snabbdom/vnode";
import { svg } from 'snabbdom-jsx';

export class DashedEdgeView extends PolylineEdgeView {
    protected renderLine(edge: SEdge, segments: Point[], context: RenderingContext): VNode {
        const firstPoint = segments[0]
        let path = `M ${firstPoint.x},${firstPoint.y}`;
        for (let i = 1; i < segments.length; i++) {
            const p = segments[i];
            path += `L ${p.x},${p.y}`;
        }
        return <path class-sprotty-edge={true} class-dashed={true} d={path} />;
    }
}