/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {Point, PolylineEdgeView, RenderingContext, SEdge} from "sprotty/lib";
import { VNode } from "snabbdom/vnode";
import {angle} from "../../views-helper";

export class DecompositionEdgeView extends PolylineEdgeView {
    protected renderAdditionals(edge: SEdge, segments: Point[], context: RenderingContext): VNode[] {
        const p1 = segments[0];
        const p2 = segments[1];
        const r = 6;
        const rhombStr = "M 0,0 l" + r + "," + (r / 2) + " l" + r + ",-" + (r / 2) + " l-" + r + ",-" + (r / 2) + " l-" + r + "," + (r / 2) + " Z";
        return [
            <path class-sprotty-edge={true} class-composition={true} d={rhombStr}
                  transform={`rotate(${angle(p1, p2)} ${p1.x} ${p1.y}) translate(${p1.x} ${p1.y})`} />
        ]
    }

    static readonly SOURCE_CORRECTION = Math.sqrt(1 * 1 + 2 * 2);

    protected getSourceAnchorCorrection(edge: SEdge): number {
        return DecompositionEdgeView.SOURCE_CORRECTION;
    }
}