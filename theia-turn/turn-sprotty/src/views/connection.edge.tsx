/** @jsx svg */

import { Point, PolylineEdgeView, RenderingContext, SEdge} from "sprotty/lib";
import { VNode } from "snabbdom/vnode";
import {angle} from "../views-helper";
import { svg } from 'snabbdom-jsx';

export class ConnectionEdgeView extends PolylineEdgeView {

    static readonly TYPE = 'edge:connection';

    protected renderAdditionals(edge: SEdge, segments: Point[], context: RenderingContext): VNode[] {
        const p1 = segments[0];
        const p2 = segments[1];

        return [
            <path class-sprotty-edge={true} class-composition={true}
                  transform={`rotate(${angle(p1, p2)} ${p1.x} ${p1.y}) translate(${p1.x} ${p1.y})`} />
        ];
    }

    static readonly SOURCE_CORRECTION = Math.sqrt(1 + 2 * 2);
}