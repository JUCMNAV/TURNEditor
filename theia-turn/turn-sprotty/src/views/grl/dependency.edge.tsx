/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {Point, PolylineEdgeView, RenderingContext, SEdge} from "sprotty/lib";
import { VNode } from "snabbdom/vnode";
import {angle} from "../../views-helper";

export class DependencyEdgeView extends PolylineEdgeView {
    protected renderAdditionals(edge: SEdge, segments: Point[], context: RenderingContext): VNode[] {
        const p1 = segments[0];
        const p2 = segments[1];
        const rhombStr = "m 0, 10 m 15 -28 h 10 a10,10 0 0,1 10,10 v 10 a10,10 0 0,1 -10,10 h -10 v -30 z";
        return [
            <path class-sprotty-edge={true} class-composition={true} d={rhombStr} fill="#FFEB8A"
                  transform={`rotate(${angle(p1, p2)} ${p1.x} ${p1.y}) translate(${p1.x} ${p1.y})`} />
        ]
    }

    static readonly SOURCE_CORRECTION = Math.sqrt(1 * 1 + 2 * 2);

    protected getSourceAnchorCorrection(edge: SEdge): number {
        return DependencyEdgeView.SOURCE_CORRECTION;
    }
}