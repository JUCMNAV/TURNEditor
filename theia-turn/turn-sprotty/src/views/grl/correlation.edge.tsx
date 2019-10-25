/** @jsx svg */

import {Point, RenderingContext, SEdge} from "sprotty/lib";
import {DashedEdgeView} from "./dashed.edge";
import { VNode } from "snabbdom/vnode";
import { svg } from 'snabbdom-jsx';
import {CompositionEdgeView} from "./composition.edge";
import {angle} from "../../views-helper";

export class CorrelationEdgeView extends DashedEdgeView {
    protected renderAdditionals(edge: SEdge, segments: Point[], context: RenderingContext): VNode[] {
        const p1 = segments[0];
        const p2 = segments[1];
        return [
            <path class-sprotty-edge={true} d="M 10,-4 L 0,0 L 10,4"
                  transform={`rotate(${angle(p1, p2)} ${p1.x} ${p1.y}) translate(${p1.x} ${p1.y})`} />
        ]
    }

    static readonly SOURCE_CORRECTION = Math.sqrt(1 * 1 + 2.5 * 2.5);

    protected getSourceAnchorCorrection(edge: SEdge): number {
        return CompositionEdgeView.SOURCE_CORRECTION;
    }
}