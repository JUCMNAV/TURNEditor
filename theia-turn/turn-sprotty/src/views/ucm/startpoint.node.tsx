/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class StartPointNodeView implements IView {

    static readonly TYPE = 'turnnode:startpoint';

    render(node: TURNNode, context: RenderingContext): VNode {
        const xOffset = Math.max(node.bounds.width, 0);
        const yOffset = Math.max(node.bounds.height / 2, 0);
        const vnode = <g class-ucm-node={true} >
            {context.renderChildren(node)}
            <circle class-body={true} class-selected={node.selected} cx={25} cy={yOffset} r={25} />
            <line x1={50} x2={xOffset} y1={yOffset} y2={yOffset} />
        </g>;
        return vnode;
    }
}