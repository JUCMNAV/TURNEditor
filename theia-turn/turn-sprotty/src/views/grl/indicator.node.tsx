/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class IndicatorNodeView implements IView {
    render(node: TURNNode, context: RenderingContext): VNode {
        const radius = node.size.width;
        const rhombStr = "m 30 30, h 75 l 20 20 l -20 20 h -40 l -20 -20 l 17 -20 z";
        return <g class-sprotty-node={true} class-module={true} class-mouseover={node.hoverFeedback}>
            <path d={rhombStr} class-selected={node.selected} r={radius} ></path>
            {context.renderChildren(node)}
        </g>;
    }
}